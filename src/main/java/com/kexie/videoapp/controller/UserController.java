package com.kexie.videoapp.controller;

import com.kexie.videoapp.common.api.CommonPage;
import com.kexie.videoapp.common.api.CommonResult;
import com.kexie.videoapp.common.utils.StringsUtils;
import com.kexie.videoapp.condition.VideoCondition;
import com.kexie.videoapp.dto.CommonUserDetails;
import com.kexie.videoapp.dto.UserLoginParam;
import com.kexie.videoapp.dto.UserRegisterParam;
import com.kexie.videoapp.mbg.model.Collect;
import com.kexie.videoapp.mbg.model.User;
import com.kexie.videoapp.mbg.model.Video;
import com.kexie.videoapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 欲隐君。 on 2020/10/20
 */
@Controller
@Api(tags = "UserController",description = "用户管理")
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<User> register(@RequestBody UserRegisterParam userRegisterParam){

        if (StringsUtils.isEmpty(userRegisterParam.getUsername())){
            return CommonResult.failed("用户名不能为空");
        }
        if (StringsUtils.isEmpty(userRegisterParam.getPassword())){
            return CommonResult.failed("密码不能为空");
        }
        User user = userService.register(userRegisterParam);
        if (user == null){
            return CommonResult.failed("该用户名已存在，操作失败了！！！（＞人＜；）");
        }
        return CommonResult.success(user,"注册成功!!~~  φ(*￣0￣)");
    }


    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UserLoginParam userLoginParam){
        String token = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());

        if (token == null){
            return CommonResult.validateFailed("用户名或密码错误！！（；´д｀）ゞ");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap,"登录成功！！~~ φ(゜▽゜*)♪");
    }

    @ApiOperation("根据用户名查询个人资料")
    @RequestMapping(value = "/personal.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getPersonal(){

        String username = getCommonUserDetails().getUsername();

        User user = userService.getUserByUsername(username);

        return CommonResult.success(user);

    }

    @ApiOperation("上传视频文件")
    @RequestMapping(value = "/uploadVideo.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadVideo(@RequestParam("videoFile")MultipartFile videoFile, @RequestParam("imageFile") MultipartFile imageFile,Video video){
        CommonResult commonResult;

        String account = getCommonUserDetails().getAccount();
        video.setUserAccount(account);

        if (videoFile.isEmpty()){
            return CommonResult.failed("上传失败，文件是空的！！！");
        }

        int count = userService.uploadVideo(videoFile,imageFile,video);
        if (count == 1){
            commonResult = CommonResult.success("上传文件成功");
            LOGGER.debug("upload File success");
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("upload File failed");
        }
        return commonResult;
    }

    @ApiOperation("查询视频列表")
    @RequestMapping(value = "/getVideoList.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getVideoList(VideoCondition videoCondition,
                                     @RequestParam(value = "pageNum",defaultValue = "1")
                                     @ApiParam("页码") Integer pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5")
                                     @ApiParam("每页数量") Integer pageSize){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (StringsUtils.isNotEmpty(videoCondition.getTime())){
            try {
                Date date = simpleDateFormat.parse(videoCondition.getTime());
                videoCondition.setUpdateTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<Video> videos =  userService.selectVideos(videoCondition,pageNum,pageSize);

        for (Video video : videos) {
            String userAccount = video.getUserAccount();
            User user = userService.getUserByAccount(userAccount);
            String name = user.getUsername();
            video.setUsername(name);
        }

        return CommonResult.success(CommonPage.restPage(videos),"操作成功");
    }

    @ApiOperation("点击视频收藏接口")
    @RequestMapping(value = "/collectVideo.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult collectVideo(@RequestBody Collect collect){
        CommonResult commonResult;
        String account = getCommonUserDetails().getAccount();
        collect.setUserAccount(account);
        collect.setCollectTime(new Date());

        Integer count = userService.createCollect(collect);

        if (count == 1) {
            commonResult = CommonResult.success(collect,"操作成功");
            LOGGER.debug("收藏成功 ： {}",collect);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("收藏失败 ： {}",collect);
        }
        return commonResult;
    }


    private static CommonUserDetails getCommonUserDetails(){
        CommonUserDetails commonUserDetails = null;
        //获取用户认证信息对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 认证信息可能为空，因此需要进行判断。
        if (Objects.nonNull(authentication)) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof CommonUserDetails){
                commonUserDetails = (CommonUserDetails) principal;
            }
        }
        return commonUserDetails;
    }
}

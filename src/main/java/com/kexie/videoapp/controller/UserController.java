package com.kexie.videoapp.controller;

import com.kexie.videoapp.common.api.CommonMessage;
import com.kexie.videoapp.common.api.CommonPage;
import com.kexie.videoapp.common.api.CommonResult;
import com.kexie.videoapp.common.utils.StringsUtils;
import com.kexie.videoapp.condition.CollectCondition;
import com.kexie.videoapp.condition.MessageCondition;
import com.kexie.videoapp.condition.PraiseCondition;
import com.kexie.videoapp.condition.VideoCondition;
import com.kexie.videoapp.dto.CommonUserDetails;
import com.kexie.videoapp.dto.UserLoginParam;
import com.kexie.videoapp.dto.UserRegisterParam;
import com.kexie.videoapp.mbg.model.*;
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

import javax.servlet.http.HttpServletRequest;
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

    @ApiOperation("修改个人资料")
    @RequestMapping(value = "/modify.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modify(@RequestBody User user){
        CommonResult commonResult;

        String account = getCommonUserDetails().getAccount();
        Integer count =  userService.updateUser(account,user);

        if (count == 1) {
            commonResult = CommonResult.success(user);
            LOGGER.debug("修改个人信息成功 ： {}",user);
        }else {
            commonResult = CommonResult.failed("修改信息失败");
            LOGGER.debug("修改个人信息失败 ： {}",user);
        }

        return commonResult;
    }

    @ApiOperation("上传视频文件")
    @RequestMapping(value = "/uploadVideo.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadVideo(@RequestParam("videoFile")MultipartFile videoFile, @RequestParam("imageFile") MultipartFile imageFile, Video video, HttpServletRequest request){
        CommonResult commonResult;

        String account = getCommonUserDetails().getAccount();
        video.setUserAccount(account);

        if (videoFile.isEmpty()){
            return CommonResult.failed("上传失败，文件是空的！！！");
        }

        int count = userService.uploadVideo(videoFile,imageFile,video,request);
        if (count == 1){
            commonResult = CommonResult.success("上传文件成功");
            LOGGER.debug("upload File success");
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("upload File failed");
        }
        return commonResult;
    }

    @ApiOperation("上传头像文件")
    @RequestMapping(value = "/uploadHeadImage.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadHeadImage(@RequestParam("headImage")MultipartFile headIamge, HttpServletRequest request){
        CommonResult commonResult;

        String account = getCommonUserDetails().getAccount();


        if (headIamge.isEmpty()){
            return CommonResult.failed("上传失败，图片文件是空的！！！");
        }

        int count = userService.uploadHeadImage(headIamge,account,request);
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
            video.setUser(user);
        }

        return CommonResult.success(CommonPage.restPage(videos),"操作成功");
    }

    @ApiOperation("获取当前用户收藏列表")
    @RequestMapping(value = "getCollectionList.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getCollectionList(CollectCondition collectCondition,
                                          @RequestParam(value = "pageNum",defaultValue = "1")
                                          @ApiParam("页码") Integer pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "5")
                                          @ApiParam("每页数量") Integer pageSize){
        String account = getCommonUserDetails().getAccount();
        collectCondition.setUserAccount(account);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (StringsUtils.isNotEmpty(collectCondition.getTime())){
            try {
                Date date = simpleDateFormat.parse(collectCondition.getTime());
                collectCondition.setCollectTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<Collect> collectList = userService.selectCollects(collectCondition,pageNum,pageSize);

        for (Collect collect : collectList) {
            Integer videoId = collect.getVideoId();
            VideoCondition videoCondition = new VideoCondition();
            videoCondition.setId(videoId);
            Video video = userService.selectVideo(videoCondition);
            collect.setVideo(video);
        }

        return CommonResult.success(CommonPage.restPage(collectList),"操作成功");
    }

    @ApiOperation("视频收藏接口")
    @RequestMapping(value = "/collectVideo.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult collectVideo(@RequestBody Collect collect){
        CommonResult commonResult;
        String account = getCommonUserDetails().getAccount();
        collect.setUserAccount(account);
        collect.setCollectTime(new Date());

        Integer count = userService.createCollect(collect);
        collect.setCollectNum(collect.getCollectNum() + 1);
        if (count == 1) {
            commonResult = CommonResult.success(collect,"操作成功");
            LOGGER.debug("收藏成功 ： {}",collect);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("收藏失败 ： {}",collect);
        }
        return commonResult;
    }


    @ApiOperation("视频点赞接口")
    @RequestMapping(value = "/praiseVideo.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult praiseVideo(@RequestBody Praise praise){
        CommonResult commonResult;
        String account = getCommonUserDetails().getAccount();
        praise.setUserAccount(account);
        praise.setPraiseTime(new Date());

        Integer count = userService.createPraise(praise);
        praise.setPraiseNum(praise.getPraiseNum() + 1);
        if (count == 1) {
            commonResult = CommonResult.success(praise,"操作成功");
            LOGGER.debug("点赞成功 ： {}",praise);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("点赞失败 ： {}",praise);
        }
        return commonResult;
    }

    @ApiOperation("进入视频详情接口")
    @RequestMapping(value = "/playVideo.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult playVideo(VideoCondition videoCondition,@RequestBody(required = false) Message message){

        Video video =  userService.selectVideo(videoCondition);
        String userAccount = video.getUserAccount();
        User user = userService.getUserByAccount(userAccount);
        video.setUser(user);

        String account = null;
        try {
            account = getCommonUserDetails().getAccount();
        }catch (NullPointerException exception){
            LOGGER.debug("当前无用户登录");
        }

        if (StringsUtils.isNotEmpty(account)){
            CollectCondition collectCondition = new CollectCondition();
            collectCondition.setUserAccount(account);
            collectCondition.setVideoId(video.getId());
            Collect collect = userService.selectCollect(collectCondition);

            PraiseCondition praiseCondition = new PraiseCondition();
            praiseCondition.setUserAccount(account);
            praiseCondition.setVideoId(video.getId());
            Praise praise = userService.selectPraise(praiseCondition);

            if (collect != null){
                video.setCollectStatus(collect.getCollectStatus());
            }
            if (praise != null){
                video.setPraiseStatus(praise.getPraiseStatus());
            }
        }


        Integer watchNum = video.getWatchNum();
        video.setWatchNum(watchNum + 1);
        userService.updateVideo(video);

        if(message != null){
            if (message.getMsgStatus().equals("1")){
                userService.updateMessage(message);
            }
        }

        return CommonResult.success(video,"操作成功");
    }

    @ApiOperation("获取当前视频id对应的所有评论")
    @RequestMapping(value = "getMessages.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getMessages(MessageCondition messageCondition,
                                    @RequestParam(value = "pageNum",defaultValue = "1")
                                    @ApiParam("页码") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "5")
                                    @ApiParam("每页数量") Integer pageSize){

        List<Message> messages = userService.selectMessage(messageCondition, pageNum, pageSize);

        for (Message message : messages) {
            String subscriberAccount = message.getSubscriberAccount();
            User subscriber = userService.getUserByAccount(subscriberAccount);
            message.setSubscriber(subscriber);
        }

        return CommonResult.success(CommonPage.restPage(messages),"操作成功");
    }

    @ApiOperation("用户发送评论")
    @RequestMapping(value = "publish.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult publish(@RequestBody Message message){
        CommonResult commonResult;

        String account = getCommonUserDetails().getAccount();  //留言者account

        message.setSubscriberAccount(account);
        message.setMsgType("1");
        message.setMsgStatus("2");
        message.setSendTime(new Date());

        Integer count = userService.createMessage(message);

        if (count == 1) {
            commonResult = CommonResult.success(message,"操作成功");
            LOGGER.debug("发送消息成功 ： {}",message);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("发送消息失败 ： {}",message);
        }
        return commonResult;
    }


    @ApiOperation("获取未读消息数量及所有消息列表(可根据id查询消息)")
    @RequestMapping(value = "getMessageList.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getMessageList(MessageCondition condition,
                                       @RequestParam(value = "pageNum",defaultValue = "1")
                                       @ApiParam("页码") Integer pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "5")
                                       @ApiParam("每页数量") Integer pageSize){
        CommonResult commonResult = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (StringsUtils.isNotEmpty(condition.getTime())){
            try {
                Date date = simpleDateFormat.parse(condition.getTime());
                condition.setSendTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        int unread = 0;
        String account = getCommonUserDetails().getAccount(); //被留言者account
        condition.setAnnouncerAccount(account);
        List<Message> messages = userService.selectMessage(condition,pageNum,pageSize);
        for (Message message : messages) {
            Integer objectId = message.getObjectId();
            VideoCondition videoCondition = new VideoCondition();
            videoCondition.setId(objectId);
            Video video = userService.selectVideo(videoCondition);
            message.setVideo(video);

            if (message.getMsgStatus().equals("2")){
                unread++;
            }
        }

        return commonResult.success(CommonMessage.restPage(messages,unread),"操作成功");
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

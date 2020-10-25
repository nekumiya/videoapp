package com.kexie.videoapp.service.impl;

import com.github.pagehelper.PageHelper;
import com.kexie.videoapp.common.api.CommonResult;
import com.kexie.videoapp.common.utils.JwtTokenUtil;
import com.kexie.videoapp.common.utils.StringsUtils;
import com.kexie.videoapp.condition.CollectCondition;
import com.kexie.videoapp.condition.PraiseCondition;
import com.kexie.videoapp.condition.VideoCondition;
import com.kexie.videoapp.dto.UserRegisterParam;
import com.kexie.videoapp.mbg.mapper.CollectMapper;
import com.kexie.videoapp.mbg.mapper.PraiseMapper;
import com.kexie.videoapp.mbg.mapper.UserMapper;
import com.kexie.videoapp.mbg.mapper.VideoMapper;
import com.kexie.videoapp.mbg.model.*;
import com.kexie.videoapp.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 欲隐君。 on 2020/10/20
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private PraiseMapper praiseMapper;


    @Override
    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(example);
        if (userList != null && userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User getUserByAccount(String account) {
        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(account);
        List<User> userList = userMapper.selectByExample(example);
        if (userList != null && userList.size()>0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public User register(UserRegisterParam userRegisterParam) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterParam,user);
        User user1 = getUserByUsername(userRegisterParam.getUsername());
        if (user1 != null){
            return null;
        }

        int random = (int)((Math.random()*9+1)*100000);
        String account = "bt"+ random;
        user.setAccount(account);
        user.setType("1");

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.insert(user);
        return user;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @ApiOperation("修改个人资料")
    @RequestMapping(value = "/modify.do",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePersonal(@RequestBody User user){
        return null;
    }


    @Override
    public int uploadVideo(MultipartFile videoFile, MultipartFile imageFile, Video video) {
        User user = getUserByAccount(video.getUserAccount());


        String videoFileName = videoFile.getOriginalFilename();
        String imageFileName = imageFile.getOriginalFilename();

        String videoFileType = videoFileName.substring(videoFileName.lastIndexOf(".") + 1);

        String filePath = "C:\\Users\\Nekumiya\\Desktop\\videoapp\\video\\"
                               + user.getUsername() + "\\"
                               + UUID.randomUUID().toString() + "\\";


        File videoDestFile = new File(filePath + videoFileName);
        File imageDestFile = new File(filePath + imageFileName);


        if (!videoDestFile.getParentFile().exists()){
            videoDestFile.getParentFile().mkdirs();
        }
        if (!imageDestFile.getParentFile().exists()){
            imageDestFile.getParentFile().mkdirs();
        }

        video.setCoverImage(filePath + imageFileName);
        video.setVideoUrl(filePath + videoFileName);
        video.setVideoType(videoFileType);
        video.setUpdateTime(new Date());
        video.setWatchNum(0);
        video.setCollectNum(0);
        video.setPraiseNum(0);

        videoMapper.insertSelective(video);
        try {
            videoFile.transferTo(videoDestFile);
            LOGGER.debug("视频文件上传成功：{}",videoDestFile);
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
            return 0;
        }
        try {
            imageFile.transferTo(imageDestFile);
            LOGGER.debug("封面文件上传成功：{}",imageDestFile);
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
            return 0;
        }

        return 1;
    }

    @Override
    public List<Video> selectVideos(VideoCondition condition, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        VideoExample example = new VideoExample();
        VideoExample.Criteria criteria = example.createCriteria();
        if (condition.getId() != null && condition.getId() != 0){
            criteria.andIdEqualTo(condition.getId());
        }
        if (StringsUtils.isNotEmpty(condition.getTitle())){
            criteria.andTitleLike("%" + condition.getTitle() + "%");
        }
        if (StringsUtils.isNotEmpty(condition.getLabels())){
            criteria.andLabelsLike("%" + condition.getLabels() + "%");
        }
        if (StringsUtils.isNotEmpty(condition.getDescription())){
            criteria.andDescriptionLike("%" + condition.getDescription() + "%");
        }
        if (StringsUtils.isNotEmpty(condition.getVideoType())){
            criteria.andVideoTypeLike("%" + condition.getVideoType() + "%");
        }
        if(null != condition.getUpdateTime()) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(condition.getUpdateTime());
            calendar.add(Calendar.DAY_OF_MONTH,1);
            Date time = calendar.getTime();

            criteria.andUpdateTimeBetween(condition.getUpdateTime(),time);
        }
        if (condition.getWatchNum() != null && condition.getWatchNum() != 0){
            criteria.andWatchNumEqualTo(condition.getWatchNum());
        }
        if (condition.getCollectNum() != null && condition.getCollectNum() != 0){
            criteria.andCollectNumEqualTo(condition.getCollectNum());
        }
        if (condition.getPraiseNum() != null && condition.getPraiseNum() != 0){
            criteria.andPraiseNumEqualTo(condition.getPraiseNum());
        }
        if (condition.getCategoryId() != null && condition.getCategoryId() != 0){
            criteria.andCategoryIdEqualTo(condition.getCategoryId());
        }
        if (StringsUtils.isNotEmpty(condition.getUserAccount())){
            criteria.andUserAccountEqualTo("%" + condition.getUserAccount() + "%");
        }
        example.setOrderByClause("update_time DESC");
        return videoMapper.selectByExample(example);

    }

    @Override
    public Integer createCollect(Collect collect) {
        Video video = new Video();
        video.setId(collect.getVideoId());


        if (collect.getCollectStatus().equals("1")){

            video.setCollectNum(collect.getCollectNum() + 1);
            videoMapper.updateByPrimaryKeySelective(video);

            return collectMapper.insertSelective(collect);
        }else if (collect.getCollectStatus().equals("2")){

            int i = collect.getCollectNum() - 1;
            if ( i <= 0){
                i = 0;
            }
            video.setCollectNum(i);
            videoMapper.updateByPrimaryKeySelective(video);

            CollectExample example = new CollectExample();
            CollectExample.Criteria criteria = example.createCriteria();
            criteria.andUserAccountEqualTo(collect.getUserAccount());
            criteria.andVideoIdEqualTo(collect.getVideoId());

            return collectMapper.deleteByExample(example);

        }
        return 0;
    }

    @Override
    public Integer createPraise(Praise praise) {
        Video video = new Video();
        video.setId(praise.getVideoId());


        if (praise.getPraiseStatus().equals("1")){

            video.setPraiseNum(praise.getPraiseNum() + 1);
            videoMapper.updateByPrimaryKeySelective(video);

            return praiseMapper.insertSelective(praise);
        }else if (praise.getPraiseStatus().equals("2")){

            int i = praise.getPraiseNum() - 1;
            if ( i <= 0){
                i = 0;
            }
            video.setPraiseNum(i);
            videoMapper.updateByPrimaryKeySelective(video);

            PraiseExample example = new PraiseExample();
            PraiseExample.Criteria criteria = example.createCriteria();
            criteria.andUserAccountEqualTo(praise.getUserAccount());
            criteria.andVideoIdEqualTo(praise.getVideoId());

            return praiseMapper.deleteByExample(example);

        }
        return 0;

    }

    @Override
    public Video selectVideo(VideoCondition videoCondition) {
        return videoMapper.selectByPrimaryKey(videoCondition.getId());
    }

    @Override
    public Collect selectCollect(CollectCondition collectCondition) {

        CollectExample example = new CollectExample();
        CollectExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(collectCondition.getUserAccount());
        criteria.andVideoIdEqualTo(collectCondition.getVideoId());

        List<Collect> collectList = collectMapper.selectByExample(example);
        if (collectList != null && collectList.size()>0){
            return collectList.get(0);
        }

        return  null;

    }

    @Override
    public Praise selectPraise(PraiseCondition praiseCondition) {
        PraiseExample example = new PraiseExample();
        PraiseExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(praiseCondition.getUserAccount());
        criteria.andVideoIdEqualTo(praiseCondition.getVideoId());

        List<Praise> praiseList = praiseMapper.selectByExample(example);
        if (praiseList != null && praiseList.size()>0){
            return praiseList.get(0);
        }

        return  null;

    }

    @Override
    public Integer updateVideo(Video video) {
        return videoMapper.updateByPrimaryKeySelective(video);
    }

}

package com.kexie.videoapp.service;

import com.kexie.videoapp.condition.*;
import com.kexie.videoapp.dto.UserRegisterParam;
import com.kexie.videoapp.mbg.model.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 欲隐君。 on 2020/10/20
 */

public interface UserService {

    User getUserByUsername(String username);

    User getUserByAccount(String account);

    User register(UserRegisterParam userRegisterParam);

    String login(String username,String password);

    int uploadVideo(MultipartFile videoFile, MultipartFile imageFile, Video video, HttpServletRequest request);

    List<Video> selectVideos(VideoCondition videoCondition, Integer pageNum, Integer pageSize);

    Integer createCollect(Collect collect);

    Integer createPraise(Praise praise);

    Video selectVideo(VideoCondition videoCondition);

    Collect selectCollect(CollectCondition collectCondition);

    Praise selectPraise(PraiseCondition praiseCondition);

    Integer updateVideo(Video video);

    int uploadHeadImage(MultipartFile headIamge, String account, HttpServletRequest request);

    Integer updateUser(String account, User user);

    Integer createMessage(Message message);

    List<Message> selectMessage(MessageCondition condition, Integer pageNum, Integer pageSize);

    Integer updateMessage(Message message);

    List<Collect> selectCollects(CollectCondition collectCondition, Integer pageNum, Integer pageSize);

    Integer createAttention(Attention attention);

    Attention selectAttention(AttentionCondition attentionCondition);

    List<Attention> selectAttentions(AttentionCondition attentionCondition, Integer pageNum, Integer pageSize);
}

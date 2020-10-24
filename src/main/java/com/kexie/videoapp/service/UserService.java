package com.kexie.videoapp.service;

import com.kexie.videoapp.condition.VideoCondition;
import com.kexie.videoapp.dto.UserRegisterParam;
import com.kexie.videoapp.mbg.model.Collect;
import com.kexie.videoapp.mbg.model.User;
import com.kexie.videoapp.mbg.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 欲隐君。 on 2020/10/20
 */

public interface UserService {

    User getUserByUsername(String username);

    User getUserByAccount(String account);

    User register(UserRegisterParam userRegisterParam);

    String login(String username,String password);

    int uploadVideo(MultipartFile videoFile, MultipartFile imageFile, Video video);

    List<Video> selectVideos(VideoCondition videoCondition, Integer pageNum, Integer pageSize);

    Integer createCollect(Collect collect);
}

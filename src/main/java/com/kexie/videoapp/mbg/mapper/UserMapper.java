package com.kexie.videoapp.mbg.mapper;

import com.kexie.videoapp.mbg.model.User;
import com.kexie.videoapp.mbg.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("username") String username, @Param("account") String account);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(@Param("id") Integer id, @Param("username") String username, @Param("account") String account);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
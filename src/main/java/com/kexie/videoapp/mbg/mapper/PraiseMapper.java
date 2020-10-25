package com.kexie.videoapp.mbg.mapper;

import com.kexie.videoapp.mbg.model.Praise;
import com.kexie.videoapp.mbg.model.PraiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PraiseMapper {
    long countByExample(PraiseExample example);

    int deleteByExample(PraiseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Praise record);

    int insertSelective(Praise record);

    List<Praise> selectByExample(PraiseExample example);

    Praise selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Praise record, @Param("example") PraiseExample example);

    int updateByExample(@Param("record") Praise record, @Param("example") PraiseExample example);

    int updateByPrimaryKeySelective(Praise record);

    int updateByPrimaryKey(Praise record);
}
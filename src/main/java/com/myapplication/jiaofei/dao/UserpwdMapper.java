package com.myapplication.jiaofei.dao;

import com.myapplication.jiaofei.pojo.Userpwd;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserpwdMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Userpwd record);

    int insertSelective(Userpwd record);

    Userpwd selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Userpwd record);

    int updateByPrimaryKey(Userpwd record);
}
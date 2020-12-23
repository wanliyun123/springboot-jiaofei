package com.myapplication.jiaofei.dao;

import com.myapplication.jiaofei.pojo.Useraccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UseraccountMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Useraccount record);

    int insertSelective(Useraccount record);

    Useraccount selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Useraccount record);

    int updateByPrimaryKey(Useraccount record);
}
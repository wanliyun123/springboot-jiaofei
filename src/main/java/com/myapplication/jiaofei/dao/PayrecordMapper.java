package com.myapplication.jiaofei.dao;

import com.myapplication.jiaofei.pojo.Payrecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PayrecordMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Payrecord record);

    int insertSelective(Payrecord record);

    List<Payrecord> selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Payrecord record);

    int updateByPrimaryKey(Payrecord record);
}
package com.jay.mapper;

import com.jay.po.Moviecategory;
import com.jay.po.MoviecategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MoviecategoryMapper {
    long countByExample(MoviecategoryExample example);

    int deleteByExample(MoviecategoryExample example);

    int deleteByPrimaryKey(Integer movcatid);

    int insert(Moviecategory record);

    int insertSelective(Moviecategory record);

    List<Moviecategory> selectByExample(MoviecategoryExample example);

    Moviecategory selectByPrimaryKey(Integer movcatid);

    int updateByExampleSelective(@Param("record") Moviecategory record, @Param("example") MoviecategoryExample example);

    int updateByExample(@Param("record") Moviecategory record, @Param("example") MoviecategoryExample example);

    int updateByPrimaryKeySelective(Moviecategory record);

    int updateByPrimaryKey(Moviecategory record);
}
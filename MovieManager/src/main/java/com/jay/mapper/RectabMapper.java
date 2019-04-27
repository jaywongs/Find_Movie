package com.jay.mapper;

import com.jay.po.Rectab;
import com.jay.po.RectabExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RectabMapper {
    long countByExample(RectabExample example);

    int deleteByExample(RectabExample example);

    int insert(Rectab record);

    int insertSelective(Rectab record);

    List<Rectab> selectByExample(RectabExample example);

    int updateByExampleSelective(@Param("record") Rectab record, @Param("example") RectabExample example);

    int updateByExample(@Param("record") Rectab record, @Param("example") RectabExample example);
}
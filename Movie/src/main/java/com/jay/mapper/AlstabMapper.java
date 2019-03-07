package com.jay.mapper;

import com.jay.po.Alstab;
import com.jay.po.AlstabExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlstabMapper {
    long countByExample(AlstabExample example);

    int deleteByExample(AlstabExample example);

    int insert(Alstab record);

    int insertSelective(Alstab record);

    List<Alstab> selectByExample(AlstabExample example);

    int updateByExampleSelective(@Param("record") Alstab record, @Param("example") AlstabExample example);

    int updateByExample(@Param("record") Alstab record, @Param("example") AlstabExample example);
}
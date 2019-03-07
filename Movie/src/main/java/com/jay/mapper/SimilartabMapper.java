package com.jay.mapper;

import com.jay.po.Similartab;
import com.jay.po.SimilartabExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SimilartabMapper {
    long countByExample(SimilartabExample example);

    int deleteByExample(SimilartabExample example);

    int insert(Similartab record);

    int insertSelective(Similartab record);

    List<Similartab> selectByExampleWithBLOBs(SimilartabExample example);

    List<Similartab> selectByExample(SimilartabExample example);

    int updateByExampleSelective(@Param("record") Similartab record, @Param("example") SimilartabExample example);

    int updateByExampleWithBLOBs(@Param("record") Similartab record, @Param("example") SimilartabExample example);

    int updateByExample(@Param("record") Similartab record, @Param("example") SimilartabExample example);
}
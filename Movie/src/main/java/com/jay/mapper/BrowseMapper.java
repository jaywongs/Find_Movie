package com.jay.mapper;

import com.jay.po.Browse;
import com.jay.po.BrowseExample;
import com.jay.po.SelectQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrowseMapper {
    long countByExample(BrowseExample example);

    int deleteByExample(BrowseExample example);

    int deleteByPrimaryKey(Integer browseid);

    int insert(Browse record);

    int insertSelective(Browse record);

    List<Browse> selectByExample(BrowseExample example);

    Browse selectByPrimaryKey(Integer browseid);

    int updateByExampleSelective(@Param("record") Browse record, @Param("example") BrowseExample example);

    int updateByExample(@Param("record") Browse record, @Param("example") BrowseExample example);

    int updateByPrimaryKeySelective(Browse record);

    int updateByPrimaryKey(Browse record);

    int booluserunlikedmovie(int userid,String movieid);

    int insertuserfavourtemovie(SelectQuery selectquery);

}
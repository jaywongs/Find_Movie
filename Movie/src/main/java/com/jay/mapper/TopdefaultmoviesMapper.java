package com.jay.mapper;
import com.jay.po.Movie;
import com.jay.po.Topdefaultmovies;
import com.jay.po.TopdefaultmoviesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopdefaultmoviesMapper {
    long countByExample(TopdefaultmoviesExample example);

    int deleteByExample(TopdefaultmoviesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Topdefaultmovies record);

    int insertSelective(Topdefaultmovies record);

    List<Topdefaultmovies> selectByExample(TopdefaultmoviesExample example);

    Topdefaultmovies selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Topdefaultmovies record, @Param("example") TopdefaultmoviesExample example);

    int updateByExample(@Param("record") Topdefaultmovies record, @Param("example") TopdefaultmoviesExample example);

    int updateByPrimaryKeySelective(Topdefaultmovies record);

    int updateByPrimaryKey(Topdefaultmovies record);

    List<Movie> selectRegDefaultMovie();

}
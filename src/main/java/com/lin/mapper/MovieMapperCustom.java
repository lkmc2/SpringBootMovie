package com.lin.mapper;

import com.lin.model.Movie;
import com.lin.utils.MyMapper;

import java.util.List;

/**
 * 自定义电影Mapper
 * @author lkmc2
 */
public interface MovieMapperCustom extends MyMapper<Movie> {
    /**
     * 生成含有n条电影的随机列表
     * @param count 生成条数
     * @return 随机电影列表
     */
    List<Movie> randomList(Integer count);

    /**
     * 根据条件分页查询电影
     * @param movie 电影
     * @return 电影列表
     */
    List<Movie> list(Movie movie);

    /**
     * 查询符合条件的电影数
     * @param movie 电影
     * @return 符合条件的电影数
     */
    int queryTotalCount(Movie movie);
}
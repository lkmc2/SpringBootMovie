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
}
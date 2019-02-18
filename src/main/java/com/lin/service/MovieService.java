package com.lin.service;

import com.lin.model.Movie;

import java.util.List;

/**
 * 电影服务接口
 * @author lkmc2
 */
public interface MovieService {
    /**
     * 分页查询热门电影列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影列表
     */
    List<Movie> getHotMovieList(Integer page, Integer pageSize);
}

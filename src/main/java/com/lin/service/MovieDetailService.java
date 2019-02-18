package com.lin.service;

import com.lin.model.vo.MovieDetailVo;

import java.util.List;

/**
 * 电影动态服务接口
 * @author lkmc2
 */
public interface MovieDetailService {
    /**
     * 分页查询最新电影动态列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影动态列表
     */
    List<MovieDetailVo> getNewestDetailList(Integer page, Integer pageSize);

    /**
     * 根据电影id获取电影详情信息
     * @param movieId 电影id
     * @return 电影详情信息列表
     */
    List<MovieDetailVo> getByMovieId(Integer movieId);
}

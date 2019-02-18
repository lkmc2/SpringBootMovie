package com.lin.mapper;

import com.lin.model.MovieDetail;
import com.lin.model.vo.MovieDetailVo;
import com.lin.utils.MyMapper;

import java.util.List;

/**
 * 自定义电影详情Mapper
 * @author lkmc2
 */
public interface MovieDetailMapperCustom extends MyMapper<MovieDetail> {
    /**
     * 查询最新电影动态列表
     * @return 最新电影动态列表
     */
    List<MovieDetailVo> getNewestDetailList();

    /**
     * 根据电影id获取电影详情信息
     * @param movieId 电影id
     * @return 电影详情信息列表
     */
    List<MovieDetailVo> getByMovieId(Integer movieId);
}
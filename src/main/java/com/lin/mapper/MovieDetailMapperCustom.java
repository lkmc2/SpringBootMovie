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
     * 查询所有电影动态列表
     * @return 最新电影动态列表
     */
    List<MovieDetailVo> getAllMovieDetailList();

    /**
     * 根据电影id获取电影详情信息
     * @param movieId 电影id
     * @return 电影详情信息列表
     */
    List<MovieDetailVo> getByMovieId(Integer movieId);

    /**
     * 根据条件分页查询电影动态
     * @param movieDetail 电影动态
     * @return 电影动态列表
     */
    List<MovieDetailVo> list(MovieDetail movieDetail);

    /**
     * 查询符合条件的电影数
     * @param movieDetail 电影动态
     * @return 符合条件的电影数
     */
    int queryTotalCount(MovieDetail movieDetail);

    /**
     * 根据网站id获取电影动态列表
     * @param websiteId 网站id
     * @return 电影动态列表
     */
    List<MovieDetailVo> getByWebsiteId(Integer websiteId);
}
package com.lin.service;

import com.lin.model.MovieDetail;
import com.lin.model.vo.MovieDetailVo;

import java.util.List;

/**
 * 电影动态服务接口
 * @author lkmc2
 */
public interface MovieDetailService {
    /**
     * 分页查询所有电影动态列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影动态列表
     */
    List<MovieDetailVo> getAllMovieDetailList(Integer page, Integer pageSize);

    /**
     * 根据电影id获取电影详情信息
     * @param movieId 电影id
     * @return 电影详情信息列表
     */
    List<MovieDetailVo> getByMovieId(Integer movieId);

    /**
     * 获取所有记录条数
     * @return 所有记录条数
     */
    int getTotalCount();

    /**
     * 分页查询电影动态
     * @param movieDetail 电影动态
     * @param page 当前页数
     * @param pageSize 每页条数
     * @return 电影动态列表
     */
    List<MovieDetailVo> list(MovieDetail movieDetail, Integer page, Integer pageSize);

    /**
     * 根据电影名查询符合条件的电影动态数
     * @param movieDetail 电影动态
     * @return 符合条件的电影动态数
     */
    int queryTotalCount(MovieDetail movieDetail);

    /**
     * 保存电影动态
     * @param movieDetail 电影动态
     * @return 是否保存成功
     */
    boolean save(MovieDetail movieDetail);

    /**
     * 根据id删除电影动态
     * @param movieDetailId 电影动态id
     * @return 是否删除成功
     */
    boolean deleteMovieDetailById(Integer movieDetailId);

    /**
     * 根据网站id获取电影动态列表
     * @param websiteId 网站id
     * @return 电影动态列表
     */
    List<MovieDetailVo> getByWebsiteId(Integer websiteId);
}

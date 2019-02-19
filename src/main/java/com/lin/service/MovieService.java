package com.lin.service;

import com.lin.model.Movie;

import java.util.List;

/**
 * 电影服务接口
 * @author lkmc2
 */
public interface MovieService {
    /**
     * 分页查询所有电影列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影列表
     */
    List<Movie> getAllMovieList(Integer page, Integer pageSize);

    /**
     * 分页查询热门电影列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影列表
     */
    List<Movie> getHotMovieList(Integer page, Integer pageSize);

    /**
     * 分页查询最新电影列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影列表
     */
    List<Movie> newestMovieList(Integer page, Integer pageSize);

    /**
     * 根据id查询电影详情信息
     * @param id 电影id
     * @return id对应的电影
     */
    Movie getById(Integer id);

    /**
     * 根据id获取上一部电影
     * @param id 电影id
     * @return 上一部电影
     */
    Movie getLast(Integer id);

    /**
     * 根据id获取下一部电影
     * @param id 电影id
     * @return 下一部电影
     */
    Movie getNext(Integer id);

    /**
     * 生成含有n条电影的随机列表
     * @param count 生成条数
     * @return 随机电影列表
     */
    List<Movie> randomList(Integer count);

    /**
     * 根据电影名查询电影列表
     * @param movieName 电影名
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影列表
     */
    List<Movie> queryMovieByName(String movieName, Integer page, Integer pageSize);

    /**
     * 获取所有记录条数
     * @return 所有记录条数
     */
    Integer getTotalCount();

    /**
     * 保存电影到数据库
     * @param movie 电影
     */
    boolean save(Movie movie);
}

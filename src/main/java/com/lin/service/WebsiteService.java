package com.lin.service;

import com.lin.model.Movie;
import com.lin.model.MovieDetail;
import com.lin.model.Website;
import com.lin.model.vo.MovieDetailVo;

import java.util.List;

/**
 * 电影网站服务接口
 * @author lkmc2
 */
public interface WebsiteService {
    /**
     * 分页查询所有网站列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影网站列表
     */
    List<Website> getAllWebsiteList(Integer page, Integer pageSize);

    /**
     * 获取所有记录条数
     * @return 所有记录条数
     */
    int getTotalCount();

    /**
     * 根据条件分页查询电影网站
     * @param website 电影网站
     * @param page 当前页数
     * @param pageSize 每页条数
     * @return 电影网站列表
     */
    List<Website> list(Website website, Integer page, Integer pageSize);
}

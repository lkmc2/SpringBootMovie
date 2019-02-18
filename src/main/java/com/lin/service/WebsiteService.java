package com.lin.service;

import com.lin.model.Website;

import java.util.List;

/**
 * 网站服务接口
 * @author lkmc2
 */
public interface WebsiteService {
    /**
     * 分页查询最新网站列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 电影列表
     */
    List<Website> newestWebSiteList(Integer page, Integer pageSize);
}

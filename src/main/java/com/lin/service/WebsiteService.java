package com.lin.service;

import com.lin.model.Website;

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

    /**
     * 查询符合条件的电影网站
     * @param website 电影网站
     * @return 符合条件的电影网站数
     */
    int queryTotalCount(Website website);

    /**
     * 保存电影网站
     * @param website 电影网站
     * @return 是否保存成功
     */
    boolean save(Website website);

    /**
     * 根据id删除网站
     * @param websiteId 网站id
     * @return 是否删除成功
     */
    boolean deleteWebsite(Integer websiteId);
}

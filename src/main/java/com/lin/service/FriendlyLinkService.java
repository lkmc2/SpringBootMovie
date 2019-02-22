package com.lin.service;

import com.lin.model.FriendlyLink;

import java.util.List;

/**
 * 友情链接服务接口
 * @author lkmc2
 */
public interface FriendlyLinkService {
    /**
     * 分页查询最新友情链接列表
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 最新友情链接列表
     */
    List<FriendlyLink> newestLinkList(Integer page, Integer pageSize);

    /**
     * 分页查询友情链接
     * @param friendlyLink 友情链接
     * @param page 当前页
     * @param pageSize 每页条数
     * @return 友情链接列表
     */
    List<FriendlyLink> list(FriendlyLink friendlyLink, Integer page, Integer pageSize);

    /**
     * 查询符合条件的友情链接数
     * @param friendlyLink 友情链接
     * @return 符合条件的友情链接数
     */
    int queryTotalCount(FriendlyLink friendlyLink);

    /**
     * 保存友情链接
     * @param friendlyLink 友情链接
     * @return 是否保存成功
     */
    boolean save(FriendlyLink friendlyLink);

    /**
     * 根据id删除友情链接
     * @param linkId 友情链接id
     * @return 是否删除成功
     */
    boolean deleteLink(Integer linkId);
}

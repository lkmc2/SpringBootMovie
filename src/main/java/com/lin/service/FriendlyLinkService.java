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
}

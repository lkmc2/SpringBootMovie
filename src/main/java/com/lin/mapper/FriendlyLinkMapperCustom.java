package com.lin.mapper;

import com.lin.model.FriendlyLink;
import com.lin.utils.MyMapper;

import java.util.List;

/**
 * 自定义友情链接Mapper
 * @author lkmc2
 */
public interface FriendlyLinkMapperCustom extends MyMapper<FriendlyLink> {
    /**
     * 分页查询友情链接
     * @param friendlyLink 友情链接
     * @return 友情链接列表
     */
    List<FriendlyLink> list(FriendlyLink friendlyLink);

    /**
     * 查询符合条件的友情链接数
     * @param friendlyLink 友情链接
     * @return 符合条件的友情链接数
     */
    int queryTotalCount(FriendlyLink friendlyLink);
}
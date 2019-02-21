package com.lin.mapper;

import com.lin.model.Website;
import com.lin.utils.MyMapper;

import java.util.List;

/**
 * 自定义网站Mapper
 * @author lkmc2
 */
public interface WebsiteMapperCustom extends MyMapper<Website> {
    /**
     * 根据查询条件进行网站分页查询
     * @param website 网站
     * @return 符合条件的网站列表
     */
    List<Website> list(Website website);

    /**
     * 查询符合条件的电影网站数
     * @param website 电影网站
     * @return 符合条件的电影网站数
     */
    int queryTotalCount(Website website);
}
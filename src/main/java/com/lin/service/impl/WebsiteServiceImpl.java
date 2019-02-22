package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.WebsiteMapper;
import com.lin.mapper.WebsiteMapperCustom;
import com.lin.model.Website;
import com.lin.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 网站服务
 * @author lkmc2
 */
@Service
@CacheConfig(cacheNames = {"websiteServiceImpl"})
public class WebsiteServiceImpl implements WebsiteService {

    @Autowired
    private WebsiteMapper websiteMapper;

    @Autowired
    private WebsiteMapperCustom websiteMapperCustom;

    @Override
    @Cacheable(key = "targetClass + methodName + #p0 + #p1")
    public List<Website> getAllWebsiteList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        // 创建查询条件（根据id排列）
        Example example = new Example(Website.class);
        example.setOrderByClause("id");

        return websiteMapper.selectByExample(example);
    }

    @Override
    @Cacheable(key = "targetClass + methodName")
    public int getTotalCount() {
        return websiteMapper.selectCount(null);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.name + #p0.url + #p1 + #p2")
    public List<Website> list(Website website, Integer page, Integer pageSize) {
        // 进行分页
        PageHelper.startPage(page, pageSize);
        // 根据查询条件进行分页
        return websiteMapperCustom.list(website);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.name + #p0.url")
    public int queryTotalCount(Website website) {
        return websiteMapperCustom.queryTotalCount(website);
    }

    @Override
    // 方法执行后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean save(Website website) {
        // 没有id时插入数据
        if (website.getId() == null) {
            return websiteMapper.insertSelective(website) >= 1;
        }
        // 更新数据
        return websiteMapper.updateByPrimaryKeySelective(website) >= 1;
    }

    @Override
    // 方法执行后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean deleteWebsite(Integer websiteId) {
        return websiteMapper.deleteByPrimaryKey(websiteId) >= 1;
    }

}

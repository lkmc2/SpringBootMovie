package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.FriendlyLinkMapper;
import com.lin.mapper.FriendlyLinkMapperCustom;
import com.lin.model.FriendlyLink;
import com.lin.service.FriendlyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 友情链接服务
 * @author lkmc2
 */
@Service
@CacheConfig(cacheNames = {"friendlyLinkServiceImpl"})
public class FriendlyLinkServiceImpl implements FriendlyLinkService {

    @Autowired
    private FriendlyLinkMapper friendlyLinkMapper;

    @Autowired
    private FriendlyLinkMapperCustom friendlyLinkMapperCustom;

    @Override
    @Cacheable(key = "targetClass + methodName + #p0 + #p1")
    public List<FriendlyLink> newestLinkList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        // 创建查询条件（根据权重排列）
        Example example = new Example(FriendlyLink.class);
        example.setOrderByClause("sort");

        return friendlyLinkMapper.selectByExample(example);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.name + #p0.url + #p1 + #p2")
    public List<FriendlyLink> list(FriendlyLink friendlyLink, Integer page, Integer pageSize) {
        // 使用分页插件
        PageHelper.startPage(page, pageSize);
        // 分页查询友情链接
        return friendlyLinkMapperCustom.list(friendlyLink);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.name + #p0.url")
    public int queryTotalCount(FriendlyLink friendlyLink) {
        return friendlyLinkMapperCustom.queryTotalCount(friendlyLink);
    }

    @Override
    // 方法执行后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean save(FriendlyLink friendlyLink) {
        // 没有id时插入数据
        if (friendlyLink.getId() == null) {
            return friendlyLinkMapper.insert(friendlyLink) >= 1;
        }
        // 更新数据
        return friendlyLinkMapper.updateByPrimaryKeySelective(friendlyLink) >= 1;
    }

    @Override
    // 方法执行后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean deleteLink(Integer linkId) {
        return friendlyLinkMapper.deleteByPrimaryKey(linkId) >= 1;
    }

}

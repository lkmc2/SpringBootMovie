package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.FriendlyLinkMapper;
import com.lin.model.FriendlyLink;
import com.lin.service.FriendlyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 友情链接服务
 * @author lkmc2
 */
@Service
public class FriendlyLinkServiceImpl implements FriendlyLinkService {

    @Autowired
    private FriendlyLinkMapper friendlyLinkMapper;

    @Override
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

}

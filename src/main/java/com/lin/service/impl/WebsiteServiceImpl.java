package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.WebsiteMapper;
import com.lin.model.Movie;
import com.lin.model.Website;
import com.lin.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 网站服务
 * @author lkmc2
 */
@Service
public class WebsiteServiceImpl implements WebsiteService {

    @Autowired
    private WebsiteMapper websiteMapper;

    @Override
    public List<Website> newestWebSiteList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        // 创建查询条件（根据id排列）
        Example example = new Example(Movie.class);
        example.setOrderByClause("id");

        return websiteMapper.selectByExample(example);
    }

}

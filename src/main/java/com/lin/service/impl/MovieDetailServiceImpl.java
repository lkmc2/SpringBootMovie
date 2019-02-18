package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.MovieDetailMapperCustom;
import com.lin.model.vo.MovieDetailVo;
import com.lin.service.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 电影动态服务
 * @author lkmc2
 */
@Service
public class MovieDetailServiceImpl implements MovieDetailService {

    @Autowired
    private MovieDetailMapperCustom movieDetailMapperCustom;

    @Override
    public List<MovieDetailVo> getNewestDetailList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        return movieDetailMapperCustom.getNewestDetailList();
    }

}

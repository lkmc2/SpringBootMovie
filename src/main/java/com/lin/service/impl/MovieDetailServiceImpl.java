package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.MovieDetailMapper;
import com.lin.mapper.MovieDetailMapperCustom;
import com.lin.model.MovieDetail;
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
    private MovieDetailMapper movieDetailMapper;

    @Autowired
    private MovieDetailMapperCustom movieDetailMapperCustom;

    @Override
    public List<MovieDetailVo> getAllMovieDetailList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        return movieDetailMapperCustom.getAllMovieDetailList();
    }

    @Override
    public List<MovieDetailVo> getByMovieId(Integer movieId) {
        return movieDetailMapperCustom.getByMovieId(movieId);
    }

    @Override
    public int getTotalCount() {
        return movieDetailMapperCustom.selectCount(null);
    }

    @Override
    public List<MovieDetailVo> list(MovieDetail movieDetail, Integer page, Integer pageSize) {
        // 进行分页
        PageHelper.startPage(page, pageSize);
        return movieDetailMapperCustom.list(movieDetail);
    }

    @Override
    public int queryTotalCount(MovieDetail movieDetail) {
        return movieDetailMapperCustom.queryTotalCount(movieDetail);
    }

    @Override
    public boolean save(MovieDetail movieDetail) {
        return movieDetailMapper.insert(movieDetail) >= 1;
    }


}

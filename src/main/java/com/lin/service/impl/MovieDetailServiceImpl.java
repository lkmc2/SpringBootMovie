package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.MovieDetailMapper;
import com.lin.mapper.MovieDetailMapperCustom;
import com.lin.model.MovieDetail;
import com.lin.model.vo.MovieDetailVo;
import com.lin.service.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 电影动态服务
 * @author lkmc2
 */
@Service
@CacheConfig(cacheNames = {"movieDetailServiceImpl"})
public class MovieDetailServiceImpl implements MovieDetailService {

    @Autowired
    private MovieDetailMapper movieDetailMapper;

    @Autowired
    private MovieDetailMapperCustom movieDetailMapperCustom;

    @Override
    @Cacheable(key = "targetClass + methodName + #p0 + #p1")
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
    @Cacheable(key = "targetClass + methodName + #p0")
    public List<MovieDetailVo> getByMovieId(Integer movieId) {
        return movieDetailMapperCustom.getByMovieId(movieId);
    }

    @Override
    @Cacheable(key = "targetClass + methodName")
    public int getTotalCount() {
        return movieDetailMapperCustom.selectCount(null);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.movieId + #p0.websiteId + #p1 + #p2")
    public List<MovieDetailVo> list(MovieDetail movieDetail, Integer page, Integer pageSize) {
        // 进行分页
        PageHelper.startPage(page, pageSize);
        return movieDetailMapperCustom.list(movieDetail);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.movieId + #p0.websiteId")
    public int queryTotalCount(MovieDetail movieDetail) {
        return movieDetailMapperCustom.queryTotalCount(movieDetail);
    }

    @Override
    // 方法调用后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean save(MovieDetail movieDetail) {
        // id为空则插入数据
        if (movieDetail.getId() == null) {
            return movieDetailMapper.insert(movieDetail) >= 1;
        }
        // 更新数据
        return movieDetailMapper.updateByPrimaryKeySelective(movieDetail) >= 1;
    }

    @Override
    // 方法执行后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean deleteMovieDetailById(Integer movieDetailId) {
        return movieDetailMapper.deleteByPrimaryKey(movieDetailId) >= 1;
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0")
    public List<MovieDetailVo> getByWebsiteId(Integer websiteId) {
        return movieDetailMapperCustom.getByWebsiteId(websiteId);
    }

}

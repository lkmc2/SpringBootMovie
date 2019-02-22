package com.lin.service.impl;

import com.github.pagehelper.PageHelper;
import com.lin.mapper.MovieMapper;
import com.lin.mapper.MovieMapperCustom;
import com.lin.model.Movie;
import com.lin.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 电影服务
 * @author lkmc2
 */
@Service
@CacheConfig(cacheNames = {"movieServiceImpl"})
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieMapperCustom movieMapperCustom;

    @Override
    @Cacheable(key = "targetClass + methodName + #p0 + #p1")
    public List<Movie> getAllMovieList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        // 创建查询条件（根据发布日期降序排列）
        Example example = new Example(Movie.class);
        example.setOrderByClause("publish_date desc");

        return movieMapper.selectByExample(example);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0 + #p1")
    public List<Movie> getHotMovieList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        // 创建查询条件（热度为1，根据发布日期降序排列）
        Example example = new Example(Movie.class);
        example.setOrderByClause("publish_date desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("hot", 1);

        return movieMapper.selectByExample(example);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0 + #p1")
    public List<Movie> newestMovieList(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        // 使用分页插件
        PageHelper.startPage(page, pageSize);

        // 创建查询条件（根据发布日期降序排列）
        Example example = new Example(Movie.class);
        example.setOrderByClause("publish_date desc");

        return movieMapper.selectByExample(example);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0")
    public Movie getById(Integer id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0")
    public Movie getLast(Integer id) {
        return movieMapper.selectByPrimaryKey(id - 1);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0")
    public Movie getNext(Integer id) {
        return movieMapper.selectByPrimaryKey(id + 1);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0")
    public List<Movie> randomList(Integer count) {
        if (count == null) {
            count = 10;
        }
        return movieMapperCustom.randomList(count);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0 + #p1 + #p2")
    public List<Movie> queryMovieByName(String movieName, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 32;
        }

        // 进行分页
        PageHelper.startPage(page, pageSize);

        // 创建查询条件（电影名like，根据发布日期降序排序）
        Example example = new Example(Movie.class);
        example.setOrderByClause("publish_date desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%" + movieName + "%");

        return movieMapper.selectByExample(example);
    }

    @Override
    @Cacheable(key = "targetClass + methodName")
    public Integer getTotalCount() {
        return movieMapper.selectCount(null);
    }

    @Override
    // 方法执行后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean save(Movie movie) {
        // id为空时，插入电影数据
        if (movie.getId() == null) {
            return movieMapper.insertSelective(movie) >= 1;
        }
        // 更新电影数据
        return movieMapper.updateByPrimaryKey(movie) >= 1;
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.name + #p1 + #p2")
    public List<Movie> list(Movie movie, Integer page, Integer pageSize) {
        // 进行分页
        PageHelper.startPage(page, pageSize);
        return movieMapperCustom.list(movie);
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0.id")
    public int queryTotalCount(Movie movie) {
        return movieMapperCustom.queryTotalCount(movie);
    }

    @Override
    // 方法执行后清空所有缓存
    @CacheEvict(allEntries = true)
    public boolean deleteMovie(int movieId) {
        return movieMapper.deleteByPrimaryKey(movieId) >= 1;
    }

    @Override
    @Cacheable(key = "targetClass + methodName + #p0")
    public Movie findById(Integer movieId) {
        return movieMapper.selectByPrimaryKey(movieId);
    }

}

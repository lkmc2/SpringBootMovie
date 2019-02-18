package com.lin.mapper;

import com.lin.model.MovieDetail;
import com.lin.model.vo.MovieDetailVo;
import com.lin.utils.MyMapper;

import java.util.List;

/**
 * 自定义电影详情Mapper
 * @author lkmc2
 */
public interface MovieDetailMapperCustom extends MyMapper<MovieDetail> {
    /**
     * 查询最新电影动态列表
     * @return 最新电影动态列表
     */
    List<MovieDetailVo> getNewestDetailList();
}
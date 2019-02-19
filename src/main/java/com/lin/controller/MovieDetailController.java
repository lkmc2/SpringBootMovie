package com.lin.controller;

import com.lin.model.vo.MovieDetailVo;
import com.lin.service.MovieDetailService;
import com.lin.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 电影动态控制器
 * @author lkmc2
 */
@Controller
@RequestMapping("movieDetail")
public class MovieDetailController {

    @Autowired
    private MovieDetailService movieDetailService;

    /**
     * 分页查询电影动态信息
     * @param page 当前页数
     * @return 电影动态展示页
     */
    @GetMapping("/list/{page}")
    public ModelAndView list(@PathVariable(value = "page", required = false) Integer page) {
        // 分页查询电影动态列表，每页20条数据
        List<MovieDetailVo> movieDetailList = movieDetailService.getAllMovieDetailList(page, 20);
        // 所有记录条数
        int total = movieDetailService.getTotalCount();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("movieDetailList", movieDetailList);
        mv.addObject("pageCode", PageUtils.generatePagination("/movieDetail/list", total, page, 20));
        mv.addObject("title", "电影网站动态信息列表");
        mv.addObject("mainPage", "movieDetail/movie_detail_list");
        mv.addObject("fragment", "movie_detail_list");
        return mv;
    }

}

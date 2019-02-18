package com.lin.controller;

import com.lin.model.Movie;
import com.lin.model.Website;
import com.lin.model.vo.MovieDetailVo;
import com.lin.service.MovieDetailService;
import com.lin.service.MovieService;
import com.lin.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 首页控制器
 * @author lkmc2
 */
@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieDetailService movieDetailService;

    @Autowired
    private WebsiteService websiteService;

    /**
     * 跳转到首页
     * @return 首页视图名
     */
    @GetMapping("/index")
    public ModelAndView login() {
        // 首页32条热门电影列表
        List<Movie> indexHotMovieList = movieService.getHotMovieList(1, 32);
        // 侧边栏10条热门电影列表
        List<Movie> hotMovieList = movieService.getHotMovieList(1, 10);
        // 最新电影动态列表
        List<MovieDetailVo> detailList = movieDetailService.getNewestDetailList(1, 10);
        // 最新网站列表
        List<Website> websiteList = websiteService.newestWebSiteList(1, 10);
        // 最新电影列表
        List<Movie> newestMovieList = movieService.newestMovieList(1, 10);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("title", "首页");
        mv.addObject("mainPage", "movie/indexMovie");
        mv.addObject("fragment", "indexMovie");
        mv.addObject("newestIndexHotMovieList", indexHotMovieList);
        mv.addObject("hotMovieList", hotMovieList);
        mv.addObject("newestDetailList", detailList);
        mv.addObject("newestWebSiteList", websiteList);
        mv.addObject("newestMovieList", newestMovieList);
        return mv;
    }

}

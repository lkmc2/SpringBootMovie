package com.lin.controller;

import com.lin.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 首页控制器
 * @author lkmc2
 */
@Controller
public class IndexController {

    /**
     * 跳转到首页
     * @return 首页视图名
     */
    @GetMapping("/index")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("title", "首页");
        mv.addObject("mainPage", "movie/indexMovie");
        mv.addObject("fragment", "indexMovie");

        List<Movie> movieList = Arrays.asList(
                new Movie(1, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(2, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(3, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(4, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(5, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(6, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(7, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(8, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影"),
                new Movie(9, 1, "20170830092804.jpg", "流浪地球", new Date(), "流浪地球 迅雷下载", "很好看的电影")
        );
        // 热门电影列表
        mv.addObject("newestIndexHotMovieList", movieList);
        return mv;
    }

}

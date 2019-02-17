package com.lin.controller;

import com.lin.model.Movie;
import com.lin.service.MovieService;
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

    /**
     * 跳转到首页
     * @return 首页视图名
     */
    @GetMapping("/index")
    public ModelAndView login() {
        // 查询热门电影列表
        List<Movie> movieList = movieService.getHotMovie(1, 10);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("title", "首页");
        mv.addObject("mainPage", "movie/indexMovie");
        mv.addObject("fragment", "indexMovie");
        mv.addObject("newestIndexHotMovieList", movieList);
        return mv;
    }

}

package com.lin.controller;

import com.lin.model.Movie;
import com.lin.service.MovieDetailService;
import com.lin.service.MovieService;
import com.lin.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * 电影控制器
 * @author lkmc2
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieDetailService movieDetailService;

    /**
     * 搜索电影 简单模糊查询
     * @param movie 电影
     * @param bindingResult Valid 验证结果
     * @return 搜索结果页面
     */
    @RequestMapping("/search")
    public ModelAndView search(@Valid Movie movie, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("index");

        if (bindingResult.hasErrors()) {
            // 发生错误则跳转到首页
            mv.addObject("error", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            mv.addObject("title", "首页");
            mv.addObject("mainPage", "movie/indexMovie");
            mv.addObject("fragment", "indexMovie");
            mv.addObject("movie", movie);
        } else {
            // 跳转到搜索结果页面
            String movieName = movie.getName();

            // 根据电影名查询电影列表（最多查询32条）
            List<Movie> movieList = movieService.queryMovieByName(movieName, 1, 32);

            mv.addObject("title", movieName);
            mv.addObject("movieList", movieList);
            mv.addObject("mainPage", "movie/search_result");
            mv.addObject("fragment", "search_result");
            mv.addObject("movie", movie);
            mv.addObject("total", movieList.size());
        }
        return mv;
    }

    @GetMapping("/list/{page}")
    public ModelAndView list(@PathVariable(value = "page", required = false) Integer page) {
        // 分页查询电影列表，每页20条数据
        List<Movie> movieList = movieService.getAllMovieList(page, 20);
        // 所有记录条数
        int total = movieService.getTotalCount();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("movieList", movieList);
        mv.addObject("pageCode", PageUtils.generatePagination("/movie/list", total, page, 20));
        mv.addObject("title", "电影列表");
        mv.addObject("mainPage", "movie/movie_list");
        mv.addObject("fragment", "movie_list");
        return mv;
    }

    /**
     * 根据id查询电影详情信息
     * @param id 电影id
     * @return 电影详情页
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Integer id) {
        // 根据id获取电影信息
        Movie movie = movieService.getById(id);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("movie", movie);
        mv.addObject("title", movie.getTitle());
        mv.addObject("pageCode", this.generateUpAndDownPageCode(movieService.getLast(id), movieService.getNext(id)));
        mv.addObject("movieDetailList", movieDetailService.getByMovieId(id));
        mv.addObject("randomMovieList", movieService.randomList(8));
        mv.addObject("mainPage", "movie/detail");
        mv.addObject("fragment", "detail");
        return mv;
    }

    /**
     * 生成上一篇和下一篇博客的代码
     * @param lastMovie 上一篇博客
     * @param nextMovie 下一篇博客
     * @return 上一篇和下一篇博客的代码
     */
    private String generateUpAndDownPageCode(Movie lastMovie, Movie nextMovie) {
        StringBuilder pageCode = new StringBuilder();

        if (lastMovie == null || lastMovie.getId() == null) {
            pageCode.append("<p>上一篇：没有了</p>");
        } else {
            pageCode.append(String.format("<p>上一篇：<a href='/movie/%s'>%s</a></p>", lastMovie.getId(), lastMovie.getTitle()));
        }
        if (nextMovie == null || nextMovie.getId() == null) {
            pageCode.append("<p>下一篇：没有了</p>");
        } else {
            pageCode.append(String.format("<p>下一篇：<a href='/movie/%s'>%s</a></p>", nextMovie.getId(), nextMovie.getTitle()));
        }

        return pageCode.toString();
    }

}

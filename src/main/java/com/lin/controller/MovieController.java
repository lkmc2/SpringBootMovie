package com.lin.controller;

import com.lin.model.Movie;
import com.lin.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 电影控制器
 * @author lkmc2
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 根据id查询电影详情信息
     * @param id 电影id
     * @return 电影详情页
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Integer id) {
        // 根据id获取电影信息
        Movie movie = movieService.selectById(id);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("movie", movie);
        mv.addObject("title", movie.getTitle());
        mv.addObject("pageCode", this.generateUpAndDownPageCode(movieService.getLast(id), movieService.getNext(id)));
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

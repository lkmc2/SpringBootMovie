package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
        return mv;
    }

    /**
     * 跳转到关于本站页
     * @return 关于本站页
     */
    @GetMapping("/aboutMe")
    public ModelAndView aboutMe() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("title", "关于本站");
        mv.addObject("mainPage", "common/aboutMe");
        mv.addObject("fragment", "aboutMe");
        return mv;
    }

}

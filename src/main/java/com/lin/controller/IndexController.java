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
        return mv;
    }

}

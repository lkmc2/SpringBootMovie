package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页控制器
 * @author lkmc2
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String login() {
        return "index";
    }

}

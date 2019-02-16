package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lkmc2
 * @date 2019/2/16
 * @description 用户控制器
 */
@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

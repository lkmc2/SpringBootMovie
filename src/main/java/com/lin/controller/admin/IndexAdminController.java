package com.lin.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员首页控制器
 * @author lkmc2
 */
@Controller
@RequestMapping("admin")
public class IndexAdminController {

    /**
     * 跳转到添加电影页面
     * @return 添加电影页面
     */
    @GetMapping("/addMovie")
    public String addMovie() {
        return "admin/addMovie";
    }

    /**
     * 跳转到电影动态管理页面
     * @return 电影动态管理页面
     */
    @GetMapping("/detailManage")
    public String detailManage() {
        return "admin/detailManage";
    }

    /**
     * 跳转到电影信息管理页面
     * @return 电影信息管理页面
     */
    @GetMapping("/movieManage")
    public String movieManage() {
        return "admin/movieManage";
    }

    /**
     * 跳转到电影信息修改页面
     * @return 电影信息修改页面
     */
    @GetMapping("/modifyMovie")
    public String modifyMovie() {
        return "admin/modifyMovie";
    }

    /**
     * 跳转到网址信息管理页面
     * @return 网址信息管理页面
     */
    @GetMapping("/websiteManage")
    public String websiteManage() {
        return "admin/websiteManage";
    }

    /**
     * 跳转到友情链接管理页面
     * @return 友情链接管理页面
     */
    @GetMapping("/linkManage")
    public String linkManage() {
        return "admin/linkManage";
    }

}

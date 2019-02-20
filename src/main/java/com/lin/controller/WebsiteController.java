package com.lin.controller;

import com.lin.model.Website;
import com.lin.service.WebsiteService;
import com.lin.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 电影网站控制器
 * @author lkmc2
 */
@Controller
@RequestMapping("website")
public class WebsiteController {

    @Autowired
    private WebsiteService websiteService;

    /**
     * 分页查询电影网站信息
     * @param page 当前页数
     * @return 电影网站展示页
     */
    @GetMapping("/list/{page}")
    public ModelAndView list(@PathVariable(value = "page", required = false) Integer page) {
        // 分页查询电影网站列表，每页20条数据
        List<Website> websiteList = websiteService.getAllWebsiteList(page, 20);
        // 所有记录条数
        int total = websiteService.getTotalCount();

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("websiteList", websiteList);
        mv.addObject("pageCode", PageUtils.generatePagination("/website/queryMovie", total, page, 20));
        mv.addObject("title", "电影网站列表");
        mv.addObject("mainPage", "website/website_list");
        mv.addObject("fragment", "website_list");
        return mv;
    }

}

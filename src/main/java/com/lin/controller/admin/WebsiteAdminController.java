package com.lin.controller.admin;

import com.lin.init.InitSystem;
import com.lin.model.Website;
import com.lin.service.MovieDetailService;
import com.lin.service.WebsiteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员网站控制器
 * @author lkmc2
 */
@RestController
@RequestMapping("admin/website")
public class WebsiteAdminController {

    @Autowired
    private WebsiteService websiteService;

    @Autowired
    private MovieDetailService movieDetailService;

    @Autowired
    private InitSystem initSystem;

    @Value("${imageFilePath}")
    private String imageFilePath;

    /**
     * 分页查询电影网站
     * @param website 电影网站
     * @param page 当前页数
     * @param rows 每页条数
     * @return 查询结果
     */
    @PostMapping("/list")
    public Map<String, Object> queryMovieDetail(Website website,
                                                @RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "rows", required = false) Integer rows) {
        // 根据电影名查询电影网站列表
        List<Website> movieList = websiteService.list(website, page, rows);
        // 查询符合条件的电影网站数
        int total = websiteService.queryTotalCount(website);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", movieList);
        resultMap.put("total", total);
        return resultMap;
    }

    /**
     * 保存电影网站
     * @param website 电影网站
     * @param request 请求
     * @return 执行结果
     */
    @PostMapping("/save")
    public Map<String, Object> save(Website website, HttpServletRequest request) {
        // 保存电影网站
        boolean success = websiteService.save(website);
        // 刷新全局数据
        initSystem.loadData(request.getServletContext());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", success);
        return resultMap;
    }

    /**
     * 网站下拉框模糊查询
     * @param q EasyUI传来的查询参数（网站地址）
     * @return 符合条件的网站列表
     */
    @PostMapping("/comboList")
    public List<Website> comboList(String q) {
        if (StringUtils.isEmpty(q)) {
            return null;
        }

        Website website = new Website();
        website.setUrl(q);
        // 根据条件分页查询电影
        return websiteService.list(website, 1, 20);
    }

    /**
     * 删除电影网站信息
     * @param ids 多个电影网站id
     * @return 执行结果
     */
    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestParam("ids") String ids, HttpServletRequest request) {
        String[] idStr = ids.split(",");
        // 是否删除成功
        boolean isDeleteSuccess = true;

        for (String id : idStr) {
            int websiteId = Integer.parseInt(id);

            // 当网站被电影动态表引用时，不删除该网站
            if (movieDetailService.getByWebsiteId(websiteId).size() > 0) {
                isDeleteSuccess = false;
            } else {
                // 删除指定id的网站
                websiteService.deleteWebsite(websiteId);
            }
        }
        // 重新加载全局电影信息
        initSystem.loadData(request.getServletContext());

        Map<String, Object> resultMap = new HashMap<>();
        if (isDeleteSuccess) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "电影动态信息存在电影网站信息，不能删除！");
        }
        return resultMap;
    }

}

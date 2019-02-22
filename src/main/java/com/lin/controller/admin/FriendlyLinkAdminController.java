package com.lin.controller.admin;

import com.lin.init.InitSystem;
import com.lin.model.FriendlyLink;
import com.lin.service.FriendlyLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员友情链接控制器
 * @author lkmc2
 */
@RestController
@RequestMapping("admin/friendly_link")
public class FriendlyLinkAdminController {

    @Autowired
    private FriendlyLinkService friendlyLinkService;

    @Autowired
    private InitSystem initSystem;

    /**
     * 分页查询友情链接
     * @param friendlyLink 友情链接
     * @param page 当前页数
     * @param rows 每页条数
     * @return 查询结果
     */
    @PostMapping("/list")
    public Map<String, Object> queryMovieDetail(FriendlyLink friendlyLink,
                                                @RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "rows", required = false) Integer rows) {
        // 根据条件查询友情链接列表
        List<FriendlyLink> movieList = friendlyLinkService.list(friendlyLink, page, rows);
        // 查询符合条件的友情链接数
        int total = friendlyLinkService.queryTotalCount(friendlyLink);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", movieList);
        resultMap.put("total", total);
        return resultMap;
    }

    /**
     * 保存友情链接
     * @param friendlyLink 友情链接
     * @param request 请求
     * @return 执行结果
     */
    @PostMapping("/save")
    public Map<String, Object> save(FriendlyLink friendlyLink, HttpServletRequest request) {
        // 保存友情链接
        boolean success = friendlyLinkService.save(friendlyLink);
        // 刷新全局数据
        initSystem.loadData(request.getServletContext());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", success);
        return resultMap;
    }

    /**
     * 删除友情链接信息
     * @param ids 多个友情链接id
     * @return 执行结果
     */
    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestParam("ids") String ids, HttpServletRequest request) {
        String[] idStr = ids.split(",");
        // 是否删除成功
        boolean isDeleteSuccess = true;

        for (String id : idStr) {
            int linkId = Integer.parseInt(id);

            // 删除指定id的友情链接
            boolean success =  friendlyLinkService.deleteLink(linkId);
            if (!success) {
                isDeleteSuccess = false;
            }

        }
        // 重新加载全局电影信息
        initSystem.loadData(request.getServletContext());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", isDeleteSuccess);
        return resultMap;
    }

}

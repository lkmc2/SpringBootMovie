package com.lin.controller.admin;

import com.lin.init.InitSystem;
import com.lin.model.MovieDetail;
import com.lin.model.vo.MovieDetailVo;
import com.lin.service.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员电影动态控制器
 * @author lkmc2
 */
@RestController
@RequestMapping("admin/movieDetail")
public class MovieDetailAdminController {

    @Autowired
    private MovieDetailService movieDetailService;

    @Autowired
    private InitSystem initSystem;

    /**
     * 分页查询电影动态
     * @param movieDetail 电影动态
     * @param page 当前页数
     * @param rows 每页条数
     * @return 查询结果
     */
    @PostMapping("/list")
    public Map<String, Object> queryMovieDetail(MovieDetail movieDetail,
                                                @RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "rows", required = false) Integer rows) {
        // 根据电影名查询电影列表
        List<MovieDetailVo> movieList = movieDetailService.list(movieDetail, page, rows);
        // 根据电影名查询符合条件的电影动态数
        int total = movieDetailService.queryTotalCount(movieDetail);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", movieList);
        resultMap.put("total", total);
        return resultMap;
    }

    /**
     * 保存电影动态到数据库
     * @param movieDetail 电影动态
     * @param request 请求
     * @return 执行结果
     */
    @PostMapping("/save")
    public Map<String, Object> save(MovieDetail movieDetail, HttpServletRequest request) {
        // 更新发布日期
        movieDetail.setPublishDate(new Date());
        // 保存电影动态到数据库
        boolean success = movieDetailService.save(movieDetail);
        // 刷新全局数据
        initSystem.loadData(request.getServletContext());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", success);
        return resultMap;
    }

    /**
     * 删除电影动态信息
     * @param ids 多个电影动态id
     * @return 执行结果
     */
    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestParam("ids") String ids, HttpServletRequest request) {
        String[] idStr = ids.split(",");
        // 是否删除成功
        boolean isDeleteSuccess = true;

        for (String id : idStr) {
            int movieDetailId = Integer.parseInt(id);
            // 根据id删除电影动态
            boolean success = movieDetailService.deleteMovieDetailById(movieDetailId);
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

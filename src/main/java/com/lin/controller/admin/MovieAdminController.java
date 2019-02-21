package com.lin.controller.admin;

import com.lin.init.InitSystem;
import com.lin.model.Movie;
import com.lin.service.MovieDetailService;
import com.lin.service.MovieService;

import com.lin.utils.DateUtils;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员电影控制器
 * @author lkmc2
 */
@RestController
@RequestMapping("admin/movie")
public class MovieAdminController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieDetailService movieDetailService;

    @Autowired
    private InitSystem initSystem;

    @Value("${imageFilePath}")
    private String imageFilePath;

    /**
     * 分页查询电影
     * @param movie 电影
     * @param page 当前页数
     * @param rows 每页条数
     * @return 查询结果
     */
    @PostMapping("/list")
    public Map<String, Object> queryMovie(Movie movie,
                                          @RequestParam(value = "page", required = false) Integer page,
                                          @RequestParam(value = "rows", required = false) Integer rows) {
        // 根据电影名查询电影列表
        List<Movie> movieList = movieService.list(movie, page, rows);
        // 根据电影名查询符合条件的电影数
        int total = movieService.queryTotalCount(movie);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", movieList);
        resultMap.put("total", total);
        return resultMap;
    }

    /**
     * 保存电影到数据库
     * @param movie 电影
     * @param file 上传的文件
     * @param request 请求
     * @return 执行结果
     */
    @PostMapping("/save")
    public Map<String, Object> save(Movie movie,
                                    @RequestParam("imageFile") MultipartFile file,
                                    HttpServletRequest request) throws IOException {
        if (file != null && !file.isEmpty()) {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件后缀名
            if (fileName != null) {
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                String newFileName = DateUtils.getCurrentDateStr() + suffixName;
                // 保存图片到本地服务器
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));
                // 设置电影的图片名
                movie.setImageName(newFileName);
            }
        }
        // 设置发布时间
        movie.setPublishDate(new Date());

        // 保存电影到数据库
        boolean success = movieService.save(movie);
        // 刷新全局数据
        initSystem.loadData(request.getServletContext());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", success);
        return resultMap;
    }

    /**
     * 删除电影信息
     * @param ids 多个电影id
     * @return 执行结果
     */
    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestParam("ids") String ids, HttpServletRequest request) {
        String[] idStr = ids.split(",");
        // 是否删除成功
        boolean isDeleteSuccess = true;

        for (String id : idStr) {
            int movieId = Integer.parseInt(id);

            // 当电影被电影详情表引用时，不删除该电影
            if (movieDetailService.getByMovieId(movieId).size() > 0) {
                isDeleteSuccess = false;
            } else {
                // 删除指定id的电影
                movieService.deleteMovie(movieId);
            }
        }
        // 重新加载全局电影信息
        initSystem.loadData(request.getServletContext());

        Map<String, Object> resultMap = new HashMap<>();
        if (isDeleteSuccess) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "电影动态信息存在电影信息，不能删除！");
        }
        return resultMap;
    }

}

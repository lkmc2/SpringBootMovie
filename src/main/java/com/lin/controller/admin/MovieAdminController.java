package com.lin.controller.admin;

import com.lin.init.InitSystem;
import com.lin.model.Movie;
import com.lin.service.MovieDetailService;
import com.lin.service.MovieService;

import com.lin.utils.DateUtils;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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

}

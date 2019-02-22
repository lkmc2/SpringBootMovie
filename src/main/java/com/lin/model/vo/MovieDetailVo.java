package com.lin.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电影动态Vo
 * @author lkmc2
 */
@Data
public class MovieDetailVo implements Serializable {
    private Integer id; // 电影动态id
    private String info; // 详情信息
    private Integer movieId; // 电影id
    private String movieName; // 电影名
    private Integer websiteId; // 网站id
    private String websiteName; // 网站名称
    private String websiteUrl; // 网站网址
    private String url; // 电影网址
    private Date publishDate; // 发布日期
}

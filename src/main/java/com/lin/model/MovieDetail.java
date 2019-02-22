package com.lin.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "movie_detail")
public class MovieDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 电影动态id
    private String info; // 详情信息

    @Column(name = "movie_id")
    private Integer movieId; // 电影id

    @Column(name = "website_id")
    private Integer websiteId; // 网站id

    private String url; // 电影网址

    @Column(name = "publish_date")
    private Date publishDate; // 发布日期
}
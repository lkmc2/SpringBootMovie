package com.lin.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "movie_detail")
public class MovieDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 电影动态id
    private String info; // 详情信息

    @Column(name = "film_id")
    private Integer filmId; // 电影id

    @Column(name = "web_site_id")
    private Integer webSiteId; // 网站id

    private String url; // 电影网址

    @Column(name = "publish_date")
    private Date publishDate; // 发布日期
}
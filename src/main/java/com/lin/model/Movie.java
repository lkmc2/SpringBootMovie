package com.lin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 电影id
    private Integer hot; // 热度

    @Column(name = "image_name")
    private String imageName; // 图片名


    private String name; // 电影名

    @Column(name = "publish_date")
    private Date publishDate; // 发布日期

    private String title; // 电影标题
    private String content; // 电影介绍
}
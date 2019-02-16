package com.lin.model;

import java.util.Date;
import javax.persistence.*;

public class Movie {
    /**
     * 电影id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 热度
     */
    private Integer hot;

    /**
     * 图片名
     */
    @Column(name = "image_name")
    private String imageName;

    /**
     * 电影名
     */
    private String name;

    /**
     * 发布日期
     */
    @Column(name = "publish_date")
    private Date publishDate;

    /**
     * 电影标题
     */
    private String title;

    /**
     * 电影介绍
     */
    private String content;

    /**
     * 获取电影id
     *
     * @return id - 电影id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置电影id
     *
     * @param id 电影id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取热度
     *
     * @return hot - 热度
     */
    public Integer getHot() {
        return hot;
    }

    /**
     * 设置热度
     *
     * @param hot 热度
     */
    public void setHot(Integer hot) {
        this.hot = hot;
    }

    /**
     * 获取图片名
     *
     * @return image_name - 图片名
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 设置图片名
     *
     * @param imageName 图片名
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * 获取电影名
     *
     * @return name - 电影名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置电影名
     *
     * @param name 电影名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取发布日期
     *
     * @return publish_date - 发布日期
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 设置发布日期
     *
     * @param publishDate 发布日期
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取电影标题
     *
     * @return title - 电影标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置电影标题
     *
     * @param title 电影标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取电影介绍
     *
     * @return content - 电影介绍
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置电影介绍
     *
     * @param content 电影介绍
     */
    public void setContent(String content) {
        this.content = content;
    }
}
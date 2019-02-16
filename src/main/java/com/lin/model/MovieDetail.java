package com.lin.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "movie_detail")
public class MovieDetail {
    /**
     * 电影动态id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 详情信息
     */
    private String info;

    /**
     * 电影id
     */
    @Column(name = "film_id")
    private Integer filmId;

    /**
     * 网站id
     */
    @Column(name = "web_site_id")
    private Integer webSiteId;

    /**
     * 电影网址
     */
    private String url;

    /**
     * 发布日期
     */
    @Column(name = "publish_date")
    private Date publishDate;

    /**
     * 获取电影动态id
     *
     * @return id - 电影动态id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置电影动态id
     *
     * @param id 电影动态id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取详情信息
     *
     * @return info - 详情信息
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置详情信息
     *
     * @param info 详情信息
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取电影id
     *
     * @return film_id - 电影id
     */
    public Integer getFilmId() {
        return filmId;
    }

    /**
     * 设置电影id
     *
     * @param filmId 电影id
     */
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    /**
     * 获取网站id
     *
     * @return web_site_id - 网站id
     */
    public Integer getWebSiteId() {
        return webSiteId;
    }

    /**
     * 设置网站id
     *
     * @param webSiteId 网站id
     */
    public void setWebSiteId(Integer webSiteId) {
        this.webSiteId = webSiteId;
    }

    /**
     * 获取电影网址
     *
     * @return url - 电影网址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置电影网址
     *
     * @param url 电影网址
     */
    public void setUrl(String url) {
        this.url = url;
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
}
package com.lin.model;

import javax.persistence.*;

@Table(name = "friendly_link")
public class FriendlyLink {
    /**
     * 友情链接id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 友情链接名
     */
    private String name;

    /**
     * 排序比重
     */
    private Integer sort;

    /**
     * 链接网址
     */
    private String url;

    /**
     * 获取友情链接id
     *
     * @return id - 友情链接id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置友情链接id
     *
     * @param id 友情链接id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取友情链接名
     *
     * @return name - 友情链接名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置友情链接名
     *
     * @param name 友情链接名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序比重
     *
     * @return sort - 排序比重
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序比重
     *
     * @param sort 排序比重
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取链接网址
     *
     * @return url - 链接网址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接网址
     *
     * @param url 链接网址
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
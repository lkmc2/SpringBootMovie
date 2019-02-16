package com.lin.model;

import javax.persistence.*;

public class Website {
    /**
     * 网站信息id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 网站名
     */
    private String name;

    /**
     * 网站地址
     */
    private String url;

    /**
     * 获取网站信息id
     *
     * @return id - 网站信息id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置网站信息id
     *
     * @param id 网站信息id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取网站名
     *
     * @return name - 网站名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置网站名
     *
     * @param name 网站名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取网站地址
     *
     * @return url - 网站地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置网站地址
     *
     * @param url 网站地址
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
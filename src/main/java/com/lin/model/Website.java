package com.lin.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 网站信息id
    private String name; // 网站名
    private String url; // 网站地址
}
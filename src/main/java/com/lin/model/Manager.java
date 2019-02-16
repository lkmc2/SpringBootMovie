package com.lin.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 管理员id
    private String username; // 用户名
    private String password; // 密码
}
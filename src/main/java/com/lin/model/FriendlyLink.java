package com.lin.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "friendly_link")
public class FriendlyLink implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 友情链接id
    private String name; // 友情链接名
    private Integer sort; // 排序比重
    private String url; // 链接网址
}
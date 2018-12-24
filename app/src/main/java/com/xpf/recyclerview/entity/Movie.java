package com.xpf.recyclerview.entity;

/**
 * Created by xpf on 2018/12/24 :)
 * Function:封装一个 movie 实体类
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class Movie {

    private String cover;
    private String name;

    public Movie(String img, String name) {
        this.cover = img;
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

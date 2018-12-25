package com.xpf.recyclerview.entity;

/**
 * Created by xpf on 2018/12/24 :)
 * Function:Film 电影
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class Film {

    public String name;
    public int length;
    public int price;
    public String content;

    public Film() {
    }

    public Film(String name, int length, int price, String content) {
        this.length = length;
        this.name = name;
        this.price = price;
        this.content = content;
    }
}

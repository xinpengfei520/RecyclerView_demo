package com.xpf.recyclerview.entity;

/**
 * Created by xpf on 2018/12/26 :)
 * Function:Video
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class Video {

    private String img;
    private String name;

    public Video() {
    }

    public Video(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

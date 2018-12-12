package com.xpf.recyclerview.entity;

/**
 * Created by x-sir on 2018/12/12 :)
 * Function:
 */
public class ThirdTypeBean {

    private String name;
    private String content;

    public ThirdTypeBean() {
    }

    public ThirdTypeBean(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

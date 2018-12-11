package com.xpf.recyclerview.entity;

/**
 * Created by xpf on 2018/12/11 :)
 * Function:首页面点击的 Item
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class ClickItem {

    private String title;
    private Class<?> activity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getActivity() {
        return activity;
    }

    public void setActivity(Class<?> activity) {
        this.activity = activity;
    }
}
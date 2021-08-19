package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.JSectionEntity;

/**
 * Created by xpf on 2018/12/24 :)
 * Function:封装一个区块实体类
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MySection extends JSectionEntity {

    private Movie movie;
    private boolean isHeader = false;
    private boolean isMore = false;
    private String header = "";

    public MySection(boolean isHeader, String header, boolean isMore) {
        this.isHeader = isHeader;
        this.isMore = isMore;
        this.header = header;
    }

    public MySection(Movie movie) {
        this.movie = movie;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    @Override
    public boolean isHeader() {
        return isHeader;
    }

    public String getHeader() {
        return header;
    }

    public Movie getMovie() {
        return movie;
    }
}

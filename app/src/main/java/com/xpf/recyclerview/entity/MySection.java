package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by xpf on 2018/12/24 :)
 * Function:封装一个区块实体类
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MySection extends SectionEntity<Movie> {

    private boolean isMore;

    public MySection(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }

    public MySection(Movie t) {
        super(t);
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}

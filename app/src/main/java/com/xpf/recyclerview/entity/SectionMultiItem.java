package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by xpf on 2018/12/26 :)
 * Function:SectionMultiItem
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class SectionMultiItem implements MultiItemEntity {

    public static final int HEAD = 111;
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    private String header;
    private int itemType;
    private boolean isMore;
    private boolean isHeader;
    private Video video;

    public SectionMultiItem(boolean isHeader, String header, boolean isMore) {
        this.isHeader = isHeader;
        this.isMore = isMore;
        this.header = header;
    }

    public SectionMultiItem(int itemType, Video video) {
        this.video = video;
        this.itemType = itemType;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public String getHeader() {
        return header;
    }
}

package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;

/**
 * Created by xpf on 2018/12/26 :)
 * Function:SectionMultiItem
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class SectionMultiItem extends SectionMultiEntity<Video> implements MultiItemEntity {

    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int IMG_TEXT = 3;
    private int itemType;
    private boolean isMore;
    private Video video;

    public SectionMultiItem(boolean isHeader, String header, boolean isMore) {
        super(isHeader, header);
        this.isMore = isMore;
    }

    public SectionMultiItem(int itemType, Video video) {
        super(video);
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
}

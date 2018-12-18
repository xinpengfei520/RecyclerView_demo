package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by x-sir on 2018/12/12 :)
 * Function:封装一个多类型的数据
 */
public class MultipleQuickEntity<T> implements MultiItemEntity {

    public static final int NAME = 1;
    public static final int NAME_IMG = 2;
    public static final int NAME_CONTENT = 3;
    public static final int LOGO_CONTENT = 4;

    public static final int SPAN_SIZE1 = 1;
    public static final int SPAN_SIZE2 = 2;
    public static final int SPAN_SIZE3 = 3;
    public static final int SPAN_SIZE4 = 4;

    private int spanSize;
    private int itemType;
    private T t;

    public MultipleQuickEntity() {
    }

    public MultipleQuickEntity(int itemType, T t) {
        this.itemType = itemType;
        this.t = t;
    }

    public MultipleQuickEntity(int itemType, T t, int spanSize) {
        this.t = t;
        this.itemType = itemType;
        this.spanSize = spanSize;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public int setItemType() {
        return itemType;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}

package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by x-sir on 2018/12/25 :)
 * Function:
 */
public class ItemClickEntity implements MultiItemEntity {

    public static final int CLICK_ITEM_VIEW = 1;
    public static final int CLICK_ITEM_CHILD_VIEW = 2;
    public static final int LONG_CLICK_ITEM_VIEW = 3;
    public static final int LONG_CLICK_ITEM_CHILD_VIEW = 4;
    public static final int NEST_CLICK_ITEM_CHILD_VIEW = 5;
    public int type;

    public ItemClickEntity(final int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}

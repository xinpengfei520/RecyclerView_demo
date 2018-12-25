package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xpf.recyclerview.adapter.ExpandableItemAdapter;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:二级 Item
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class Level1Item extends AbstractExpandableItem<Person> implements MultiItemEntity {
    public String title;
    public String subTitle;

    public Level1Item(String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}
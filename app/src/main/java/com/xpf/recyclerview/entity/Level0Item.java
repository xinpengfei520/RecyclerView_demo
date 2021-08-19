package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.xpf.recyclerview.adapter.ExpandableItemAdapter;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:一级 Item
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class Level0Item extends BaseExpandNode implements MultiItemEntity {

    public String title;
    public String subTitle;
    private List<BaseNode> childNode;

    public Level0Item(List<BaseNode> childNode, String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
        this.childNode = childNode;
        setExpanded(false);
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }

    @Override
    public List<BaseNode> getChildNode() {
        return childNode;
    }
}

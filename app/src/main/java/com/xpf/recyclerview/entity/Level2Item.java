package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

public class Level2Item extends BaseNode {
    private String title;

    public Level2Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}

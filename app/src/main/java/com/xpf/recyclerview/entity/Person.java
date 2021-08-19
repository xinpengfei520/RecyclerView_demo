package com.xpf.recyclerview.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.xpf.recyclerview.adapter.ExpandableItemAdapter;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:Person bean.
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class Person extends BaseNode implements MultiItemEntity {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_PERSON;
    }

    @Override
    public List<BaseNode> getChildNode() {
        return null;
    }
}
package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.ExpandableItemAdapter;
import com.xpf.recyclerview.data.DataServer;

import java.util.ArrayList;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:可展开的 Item 效果（类似于 QQ 的分组效果）
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class ExpandableActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExpandableItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        mRecyclerView = findViewById(R.id.recyclerView);
        ArrayList<MultiItemEntity> expandableData = DataServer.getExpandableData();

        mAdapter = new ExpandableItemAdapter(expandableData);

        // 设置布局管理器
        final GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItemViewType(position) == ExpandableItemAdapter.TYPE_PERSON ? 1 : manager.getSpanCount();
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        // 这种情况下，布局管理器必须要在 setAdapter 之后设置！！！
        mRecyclerView.setLayoutManager(manager);
        mAdapter.expandAll();
    }
}

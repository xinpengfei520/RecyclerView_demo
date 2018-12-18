package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemQuickAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.MultipleQuickEntity;

import java.util.List;

/**
 * Created by xpf on 2018/12/18 :)
 * Function:分类型数据练习，使用 BaseMultiItemQuickAdapter 实现
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MultipleItemQuickActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_quick);
        mRecyclerView = findViewById(R.id.recyclerView);

        final List<MultipleQuickEntity> data = DataServer.getMultipleItemData();
        final MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(data);
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        mRecyclerView.setAdapter(multipleItemAdapter);
    }
}

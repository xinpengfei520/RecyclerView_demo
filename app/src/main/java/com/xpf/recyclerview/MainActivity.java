package com.xpf.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xpf.recyclerview.activity.AddHeadRecyclerViewActivity;
import com.xpf.recyclerview.activity.LinearLayoutActivity;
import com.xpf.recyclerview.activity.StaggeredGridLayoutActivity;
import com.xpf.recyclerview.activity.onViewAttachedToWindow;
import com.xpf.recyclerview.adapter.ClickItemAdapter;
import com.xpf.recyclerview.entity.ClickItem;
import com.xpf.recyclerview.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:主页面
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MainActivity extends AppCompatActivity {

    private static final Class<?>[] ACTIVITY = {
            LinearLayoutActivity.class, StaggeredGridLayoutActivity.class,
            AddHeadRecyclerViewActivity.class, onViewAttachedToWindow.class};

    private static final String[] TITLE = {
            "LinearLayoutActivity", "StaggeredGridLayoutActivity",
            "AddHeadRecyclerViewActivity", "onViewAttachedToWindow"};

    private RecyclerView mRecyclerView;

    private List<ClickItem> mItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initData() {
        mItemList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            ClickItem item = new ClickItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            mItemList.add(item);
        }
    }

    private void setAdapter() {
        BaseQuickAdapter adapter = new ClickItemAdapter(R.layout.item_textview, mItemList);
        adapter.openLoadAnimation();
        View header = getLayoutInflater().inflate(R.layout.header_view, (ViewGroup) mRecyclerView.getParent(), false);
        adapter.addHeaderView(header);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}

package com.xpf.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xpf.recyclerview.activity.AddHeadRecyclerViewActivity;
import com.xpf.recyclerview.activity.CustomDragSwipeActivity;
import com.xpf.recyclerview.activity.DataBindingActivity;
import com.xpf.recyclerview.activity.DragAndSwipeActivity;
import com.xpf.recyclerview.activity.ExpandableActivity;
import com.xpf.recyclerview.activity.HeaderFooterViewActivity;
import com.xpf.recyclerview.activity.ItemClickEventActivity;
import com.xpf.recyclerview.activity.LinearLayoutActivity;
import com.xpf.recyclerview.activity.MultiItemActivity;
import com.xpf.recyclerview.activity.MultipleItemQuickActivity;
import com.xpf.recyclerview.activity.SectionActivity;
import com.xpf.recyclerview.activity.SectionMultiItemActivity;
import com.xpf.recyclerview.activity.StaggeredGridLayoutActivity;
import com.xpf.recyclerview.activity.UpFetchActivity;
import com.xpf.recyclerview.activity.OnViewAttachedToWindow;
import com.xpf.recyclerview.adapter.ClickItemAdapter;
import com.xpf.recyclerview.decoration.DividerItemDecoration;
import com.xpf.recyclerview.entity.ClickItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:主页面
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MainActivity extends AppCompatActivity {

    private static final Class<?>[] ACTIVITY = {
            LinearLayoutActivity.class, StaggeredGridLayoutActivity.class, AddHeadRecyclerViewActivity.class,
            OnViewAttachedToWindow.class, MultiItemActivity.class, MultipleItemQuickActivity.class, SectionActivity.class,
            DragAndSwipeActivity.class, ItemClickEventActivity.class, ExpandableActivity.class, DataBindingActivity.class,
            UpFetchActivity.class, SectionMultiItemActivity.class, CustomDragSwipeActivity.class, HeaderFooterViewActivity.class};

    private static final String[] TITLE = {
            "LinearLayoutActivity", "StaggeredGridLayoutActivity", "AddHeadRecyclerViewActivity",
            "onViewAttachedToWindow", "MultiItemActivity", "MultipleItemQuickActivity", "SectionActivity",
            "DragAndSwipeActivity", "ItemClickEventActivity", "ExpandableActivity", "DataBindingActivity",
            "UpFetchActivity", "SectionMultiItemActivity", "CustomDragSwipeActivity", "HeaderFooterViewActivity"};

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
        // 开启加载动画
        adapter.setAnimationEnable(true);
        // 添加头部布局
        View header = getLayoutInflater().inflate(R.layout.header_view, (ViewGroup) mRecyclerView.getParent(), false);
        adapter.addHeaderView(header);
        // 添加尾部布局
        View footer = getLayoutInflater().inflate(R.layout.footer_view, (ViewGroup) mRecyclerView.getParent(), false);
        adapter.addFooterView(footer);
        // 注意：头和尾都可以添加多个，且尾可以添加到指定的下标位置
        adapter.setOnItemClickListener((adapter1, view, position) -> {
            Intent intent = new Intent(MainActivity.this, ACTIVITY[position]);
            startActivity(intent);
        });

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}

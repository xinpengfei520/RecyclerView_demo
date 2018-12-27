package com.xpf.recyclerview.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.base.BaseAdapterWrapper;
import com.xpf.recyclerview.base.BaseQuickAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.decoration.DividerItemDecoration;
import com.xpf.recyclerview.decoration.ItemDividerDecoration;
import com.xpf.recyclerview.entity.DragItem;
import com.xpf.recyclerview.utils.ToastUtils;

import java.util.ArrayList;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:使用 BaseAdapterWrapper 实现添加头和尾布局
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class HeaderFooterViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<DragItem> mDragItemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_footer_view);

        initView();
        iniData();
        setAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void iniData() {
        mDragItemData = DataServer.getDragItemData();
    }

    private void setAdapter() {
        BaseQuickAdapter<DragItem> baseQuickAdapter = new BaseQuickAdapter<DragItem>(mDragItemData) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_drag_swipe;
            }

            @SuppressLint({"SetTextI18n"})
            @Override
            public void convert(VH holder, DragItem data, int position) {
                ImageView imageView = holder.getView(R.id.ivLogo);
                imageView.setImageResource(R.drawable.icon_dragger);
                TextView textView = holder.getView(R.id.tvTitle);
                textView.setText(data.title + data.index);
                holder.itemView.setOnClickListener(v -> ToastUtils.showShort(data.title + ",position:" + position));
            }
        };

        BaseAdapterWrapper baseAdapterWrapper = new BaseAdapterWrapper(baseQuickAdapter);
        View headerView = LayoutInflater.from(this).inflate(R.layout.header_view, mRecyclerView, false);
        View footerView = LayoutInflater.from(this).inflate(R.layout.footer_view, mRecyclerView, false);
        baseAdapterWrapper.addFooterView(footerView);
        baseAdapterWrapper.addHeaderView(headerView);
        mRecyclerView.setAdapter(baseAdapterWrapper);

        // 添加分割线
        ItemDividerDecoration decoration = new ItemDividerDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(decoration);
    }
}

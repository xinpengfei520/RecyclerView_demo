package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.ItemClickAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.ItemClickEntity;
import com.xpf.recyclerview.utils.ToastUtils;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:Item 的点击事件及其 Item 子 View 的点击事件处理
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class ItemClickEventActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ItemClickAdapter itemClickAdapter;
    private List<ItemClickEntity> itemClickData;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_click_event);

        initView();
        initData();
        setAdapter();
        initListener();
    }

    private void setAdapter() {
        itemClickAdapter = new ItemClickAdapter(itemClickData);
        itemClickAdapter.openLoadAnimation();
        itemClickAdapter.isFirstOnly(false);
        mRecyclerView.setAdapter(itemClickAdapter);

        // 处理位置问题，手动滑动到顶部
        mHandler.postDelayed(() -> {
            mRecyclerView.scrollToPosition(0);
            itemClickAdapter.notifyDataSetChanged();
        }, 1000);
    }

    private void initData() {
        itemClickData = DataServer.getItemClickData();
        mHandler = new Handler(Looper.getMainLooper());
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initListener() {
        itemClickAdapter.setOnItemClickListener((adapter, view, position) -> ToastUtils.showShort("onItemClick()"));

        itemClickAdapter.setOnItemLongClickListener((adapter, view, position) -> {
            ToastUtils.showShort("onItemLongClick()");
            return true;
        });

        itemClickAdapter.setOnItemChildClickListener((adapter, view, position) -> ToastUtils.showShort("onItemChildClick()"));

        itemClickAdapter.setOnItemChildLongClickListener((adapter, view, position) -> {
            ToastUtils.showShort("onItemChildLongClick()");
            return true;
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}

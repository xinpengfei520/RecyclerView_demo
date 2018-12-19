package com.xpf.recyclerview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemQuickAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.MultipleQuickEntity;
import com.xpf.recyclerview.request.SimulateRequest;

import java.util.List;

/**
 * Created by xpf on 2018/12/18 :)
 * Function:分类型数据练习，使用 BaseMultiItemQuickAdapter 实现
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MultipleItemQuickActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeLayout;
    private MultipleItemQuickAdapter multipleItemAdapter;

    /**
     * 每页的数量
     */
    private static final int PAGE_SIZE = 10;
    /**
     * 页数
     */
    private int mPageNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_quick);
        initViews();
        setAdapter();
        initListener();
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mSwipeLayout = findViewById(R.id.swipeLayout);
        mSwipeLayout.setColorSchemeColors(Color.rgb(50, 223, 189));
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
    }

    private void initListener() {
        multipleItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MultipleItemQuickActivity.this, "position===" + position, Toast.LENGTH_SHORT).show();
            }
        });
        multipleItemAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        }, mRecyclerView);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {
        mPageNumber = 1;
        // 这里的作用是防止下拉刷新的时候还可以上拉加载
        multipleItemAdapter.setEnableLoadMore(false);
        new SimulateRequest(mPageNumber, new SimulateRequest.RequestCallBack() {
            @Override
            public void success(List<MultipleQuickEntity> data) {
                setData(true, data);
                multipleItemAdapter.setEnableLoadMore(true);
                mSwipeLayout.setRefreshing(false);
            }

            @Override
            public void fail(Exception e) {
                Toast.makeText(MultipleItemQuickActivity.this, "网络请求失败！", Toast.LENGTH_LONG).show();
                multipleItemAdapter.setEnableLoadMore(true);
                mSwipeLayout.setRefreshing(false);
            }
        }).start();
    }

    private void loadMore() {
        new SimulateRequest(mPageNumber, new SimulateRequest.RequestCallBack() {
            @Override
            public void success(List<MultipleQuickEntity> data) {
                boolean isRefresh = mPageNumber == 1;
                Toast.makeText(MultipleItemQuickActivity.this, "dataSize:" + data.size(), Toast.LENGTH_SHORT).show();
                setData(isRefresh, data);
            }

            @Override
            public void fail(Exception e) {
                multipleItemAdapter.loadMoreFail();
                Toast.makeText(MultipleItemQuickActivity.this, "网络请求失败！", Toast.LENGTH_LONG).show();
            }
        }).start();
    }

    private void setData(boolean isRefresh, List data) {
        mPageNumber++;
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {
            multipleItemAdapter.setNewData(data);
        } else {
            if (size > 0) {
                multipleItemAdapter.addData(data);
            }
        }
        if (size < PAGE_SIZE) {
            // 第一页如果不够一页就不显示没有更多数据布局
            multipleItemAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(this, "no more data", Toast.LENGTH_SHORT).show();
        } else {
            multipleItemAdapter.loadMoreComplete();
        }
    }

    private void setAdapter() {
        final List<MultipleQuickEntity> data = DataServer.getMultipleItemData();
        multipleItemAdapter = new MultipleItemQuickAdapter(data);
        // 设置加载动画，有 5 种动画效果可选（ALPHAIN、SCALEIN、SLIDEIN_BOTTOM、SLIDEIN_LEFT、SLIDEIN_RIGHT）
        multipleItemAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        // 设置是否只有第一次加载时显示动画
        multipleItemAdapter.isFirstOnly(false);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        mRecyclerView.setAdapter(multipleItemAdapter);
    }

}

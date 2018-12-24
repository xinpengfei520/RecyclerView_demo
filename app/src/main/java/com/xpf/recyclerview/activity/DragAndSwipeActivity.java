package com.xpf.recyclerview.activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.DraggerAdapter;
import com.xpf.recyclerview.data.DataServer;

import java.util.List;

/**
 * Created by xpf on 2018/12/24 :)
 * Function:拖动和滑动删除练习
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class DragAndSwipeActivity extends AppCompatActivity {

    private static final String TAG = "DragAndSwipeActivity";
    private RecyclerView recyclerView;
    private List<String> mData;
    private DraggerAdapter draggerAdapter;
    private ItemDragAndSwipeCallback mItemDragAndSwipeCallback;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_swipe);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mData = DataServer.getLinearData(60);

        initListener();
    }

    private void initListener() {
        OnItemDragListener onItemDragListener = new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i(TAG, "onItemDragStart()");
            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
                Log.i(TAG, "onItemDragMoving()");
            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i(TAG, "onItemDragEnd()");
            }
        };

        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i(TAG, "onItemSwipeStart()");
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i(TAG, "clearView()");
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
                Log.i(TAG, "onItemSwiped()");
            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
                Log.i(TAG, "onItemSwipeMoving()");
            }
        };

        draggerAdapter = new DraggerAdapter(R.layout.item_dragger, mData);
        mItemDragAndSwipeCallback = new ItemDragAndSwipeCallback(draggerAdapter);

        // 创建 Item 拖动时的帮助类
        mItemTouchHelper = new ItemTouchHelper(mItemDragAndSwipeCallback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

        // 设置滑动删除的标记，支持开始和结束为止滑动（另外，还有 DOWN & UP）
        mItemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        // 开启滑动删除
        draggerAdapter.enableSwipeItem();
        // 设置滑动删除的监听器
        draggerAdapter.setOnItemSwipeListener(onItemSwipeListener);
        // 设置 Item 可拖动
        draggerAdapter.enableDragItem(mItemTouchHelper);
        // 设置 Item 拖动时的监听器
        draggerAdapter.setOnItemDragListener(onItemDragListener);
        // 设置 RecycleView 的适配器
        recyclerView.setAdapter(draggerAdapter);

        draggerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(DragAndSwipeActivity.this, "点击了position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

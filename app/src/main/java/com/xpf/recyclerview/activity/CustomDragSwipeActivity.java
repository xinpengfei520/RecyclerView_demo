package com.xpf.recyclerview.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.base.BaseItemTouchCallback;
import com.xpf.recyclerview.base.BaseQuickAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.decoration.DividerItemDecoration;
import com.xpf.recyclerview.decoration.ItemDividerDecoration;
import com.xpf.recyclerview.entity.DragItem;

import java.util.ArrayList;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:自定义拖拽侧滑 Item 效果
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class CustomDragSwipeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ItemTouchHelper mHelper;
    private BaseQuickAdapter<DragItem> mAdapter;
    private ArrayList<DragItem> mDragItemData;
    private BaseItemTouchCallback.OnStartDragListener mListener = new BaseItemTouchCallback.OnStartDragListener() {
        @Override
        public void startDrag(RecyclerView.ViewHolder holder) {
            mHelper.startDrag(holder);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_drag_swip);

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
        mAdapter = new BaseQuickAdapter<DragItem>(mDragItemData) {
            @Override
            public int getLayoutId(int viewType) {
                return R.layout.item_drag_swipe;
            }

            @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
            @Override
            public void convert(VH holder, DragItem data, int position) {
                ImageView imageView = holder.getView(R.id.ivLogo);
                imageView.setImageResource(R.drawable.icon_dragger);
                TextView textView = holder.getView(R.id.tvTitle);
                textView.setText(data.title + data.index);

                // 设置触摸时拖拽的监听
                imageView.setOnTouchListener((v, event) -> {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        mListener.startDrag(holder);
                    }
                    return false;
                });
            }
        };

        mRecyclerView.setAdapter(mAdapter);

        // 添加分割线
        ItemDividerDecoration decoration = new ItemDividerDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(decoration);

        mHelper = new ItemTouchHelper(new BaseItemTouchCallback<>(mAdapter, mDragItemData));
        mHelper.attachToRecyclerView(mRecyclerView);
    }
}

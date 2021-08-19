package com.xpf.recyclerview.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.MultipleEntity;

import java.util.List;

/**
 * Created by xpf on 2018/12/12 :)
 * Function:分类型数据练习
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MultiItemActivity extends AppCompatActivity {

    private static final int SPAN_SIZE1 = 1;
    private static final int SPAN_SIZE3 = 3;
    private static final int SPAN_SIZE4 = 4;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_item);
        initViews();
        setAdapter();
    }

    private void setAdapter() {
        final List<MultipleEntity> data = DataServer.getData();
        MultipleItemAdapter multipleItemAdapter = new MultipleItemAdapter(data);
        // 设置加载动画，有 5 种动画效果可选（ALPHAIN、SCALEIN、SLIDEIN_BOTTOM、SLIDEIN_LEFT、SLIDEIN_RIGHT）
        multipleItemAdapter.setAnimationEnable(true);
        // 设置是否只有第一次加载时显示动画
        multipleItemAdapter.setAnimationFirstOnly(false);
        multipleItemAdapter.setGridSpanSizeLookup((gridLayoutManager, viewType, position) -> {
            int spanSize = 0;
            switch (data.get(position).getType()) {
                case MultipleEntity.NAME:
                    spanSize = SPAN_SIZE1;
                    break;
                case MultipleEntity.NAME_IMG:
                    spanSize = SPAN_SIZE3;
                    break;
                case MultipleEntity.NAME_CONTENT:
                    spanSize = SPAN_SIZE4;
                    break;
                default:
                    break;
            }

            return spanSize;
        });

        mRecyclerView.setAdapter(multipleItemAdapter);
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
    }

}

package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.SectionMultiItemAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.SectionMultiItem;
import com.xpf.recyclerview.utils.ToastUtils;

import java.util.List;

/**
 * Created by xpf on 2018/12/26 :)
 * Function:带分区块头的分类型的 Item 实现
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class SectionMultiItemActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<SectionMultiItem> mSectionMultiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_multiple_item);
        initView();
        initData();
        setAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        mSectionMultiData = DataServer.getSectionMultiData();
    }

    private void setAdapter() {
        SectionMultiItemAdapter sectionAdapter = new SectionMultiItemAdapter(R.layout.item_section_header, mSectionMultiData);
        // 设置 Item 的子 View 的点击事件
        sectionAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            SectionMultiItem item = (SectionMultiItem) adapter.getData().get(position);
            switch (view.getId()) {
                case R.id.card_view:
                    // 获取主体 item 相应数据给后期使用
                    if (item.getVideo() != null) {
                        ToastUtils.showShort(item.getVideo().getName());
                    }
                    break;
                default:
                    ToastUtils.showShort("OnItemChildClickListener position:" + position);
                    break;

            }
        });
        mRecyclerView.setAdapter(sectionAdapter);
    }
}

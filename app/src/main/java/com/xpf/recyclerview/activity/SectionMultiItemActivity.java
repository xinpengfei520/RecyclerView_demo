package com.xpf.recyclerview.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_multiple_item);
        mRecyclerView = findViewById(R.id.recyclerView);
        setAdapter();
    }

    private void setAdapter() {
        List<SectionMultiItem> data = DataServer.getSectionMultiData();
        SectionMultiItemAdapter sectionAdapter = new SectionMultiItemAdapter(data);
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
        sectionAdapter.setGridSpanSizeLookup((gridLayoutManager, viewType, position) ->
                data.get(position).getSpanSize()
        );

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

package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.SectionAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.decoration.GridSectionAverageGapItemDecoration;
import com.xpf.recyclerview.entity.MySection;

import java.util.List;

/**
 * Created by xpf on 2018/12/24 :)
 * Function:区块头效果练习
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class SectionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<MySection> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        initView();
        initData();
        setAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(50, 20, 20, 20));
    }

    private void initData() {
        mData = DataServer.getMySectionData();
    }

    private void setAdapter() {
        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.item_section_content, R.layout.def_section_head, mData);

        sectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MySection mySection = mData.get(position);
                if (mySection.isHeader) {
                    Toast.makeText(SectionActivity.this, mySection.header, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SectionActivity.this, mySection.t.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        sectionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(SectionActivity.this, "onItemChildClick:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(sectionAdapter);
    }

}

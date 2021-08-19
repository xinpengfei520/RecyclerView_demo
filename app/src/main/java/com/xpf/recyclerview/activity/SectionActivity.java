package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        GridSectionAverageGapItemDecoration decoration =
                new GridSectionAverageGapItemDecoration(50, 20, 20, 20);
        mRecyclerView.addItemDecoration(decoration);
    }

    private void initData() {
        mData = DataServer.getMySectionData();
    }

    private void setAdapter() {
        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.item_section_content, R.layout.item_section_header, mData);

        sectionAdapter.setOnItemClickListener((adapter, view, position) -> {
            MySection mySection = mData.get(position);
            if (mySection.isHeader()) {
                Toast.makeText(SectionActivity.this, mySection.getHeader(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SectionActivity.this, mySection.getMovie().getName(), Toast.LENGTH_SHORT).show();
            }
        });

        sectionAdapter.setOnItemChildClickListener((adapter, view, position) ->
                Toast.makeText(SectionActivity.this, "onItemChildClick:" + position, Toast.LENGTH_SHORT).show()
        );

        mRecyclerView.setAdapter(sectionAdapter);
    }

}

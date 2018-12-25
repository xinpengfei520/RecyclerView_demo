package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.DataBindingAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.Film;
import com.xpf.recyclerview.utils.ToastUtils;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:DataBinding 实现数据绑定
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class DataBindingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DataBindingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding);

        mRecyclerView = findViewById(R.id.recyclerView);
        List<Film> filmData = DataServer.getFilmData();

        mAdapter = new DataBindingAdapter(R.layout.item_movie, filmData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        initListener();
    }

    private void initListener() {
        mAdapter.setOnItemClickListener((adapter, view, position) -> ToastUtils.showShort("onItemClick"));
        mAdapter.setOnItemChildLongClickListener((adapter, view, position) -> {
            ToastUtils.showShort("onItemChildLongClick");
            return true;
        });
        mAdapter.setOnItemLongClickListener((adapter, view, position) -> {
            ToastUtils.showShort("onItemLongClick");
            return true;
        });
    }
}

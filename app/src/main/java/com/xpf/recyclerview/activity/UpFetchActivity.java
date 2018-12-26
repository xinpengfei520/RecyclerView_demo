package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.UpFetchAdapter;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.Film;

import java.util.List;

/**
 * Created by xpf on 2018/12/26 :)
 * Function:上拉加载更多数据，类似于微信消息向上滑查看更多历史的消息
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class UpFetchActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private UpFetchAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_fetch);

        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new UpFetchAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(genData());
        mAdapter.setUpFetchEnable(true);
        // start fetch when scroll to position 2, default is 1.
        mAdapter.setStartUpFetchPosition(2);
        mAdapter.setUpFetchListener(this::startUpFetch);
    }

    private int count;

    private void startUpFetch() {
        count++;
        // set fetching on when start network request.
        mAdapter.setUpFetching(true);
        // get data from internet.
        mRecyclerView.postDelayed(() -> {
            mAdapter.addData(0, genData());
            // set fetching off when network request ends.
            mAdapter.setUpFetching(false);
            // set fetch enable false when you don't need anymore.
            if (count > 5) {
                mAdapter.setUpFetchEnable(false);
            }
        }, 1000);
    }

    private List<Film> genData() {
        return DataServer.getFilmData();
    }
}

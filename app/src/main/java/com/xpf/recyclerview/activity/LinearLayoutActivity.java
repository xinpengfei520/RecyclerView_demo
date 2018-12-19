package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.LinearLayoutAdapter;
import com.xpf.recyclerview.data.DataServer;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:线性布局管理器练习(# {setEmptyView()} )
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class LinearLayoutActivity extends AppCompatActivity {

    private View notDataView;
    private View errorView;
    private RecyclerView recyclerView;
    private LinearLayoutAdapter linearLayoutAdapter;
    private boolean mError = true;
    private boolean mNoData = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) recyclerView.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        errorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) recyclerView.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });

        linearLayoutAdapter = new LinearLayoutAdapter(R.layout.item_linearlayout, DataServer.getLinearData(0));
        recyclerView.setAdapter(linearLayoutAdapter);

        onRefresh();
    }

    /**
     * 一进来页面，先显示模拟网络请求，显示 loading 并加载数据，然后显示网络错误，当再次点击时，显示为空，再次点击时显示出数据
     */
    private void onRefresh() {
        linearLayoutAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) recyclerView.getParent());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mError) {
                    linearLayoutAdapter.setEmptyView(errorView);
                    mError = false;
                } else {
                    if (mNoData) {
                        linearLayoutAdapter.setEmptyView(notDataView);
                        mNoData = false;
                    } else {
                        linearLayoutAdapter.setNewData(DataServer.getLinearData(50));
                    }
                }
            }
        }, 2000);
    }
}

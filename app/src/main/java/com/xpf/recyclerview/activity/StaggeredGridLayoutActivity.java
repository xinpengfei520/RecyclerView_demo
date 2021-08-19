package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.RvAdapter;
import com.xpf.recyclerview.decoration.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:瀑布流效果
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class StaggeredGridLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mData; // 集合数据
    private RvAdapter mAdapter;  // 适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_layout);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initData();

        // 设置布局管理器,控制其要显示的样式(瀑布流垂直方向为4列,如果是水平方向就是4行)
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        mAdapter = new RvAdapter(this, mData);

        mRecyclerView.setAdapter(mAdapter);

        // 设置RecyclerView的Item之间的分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        // 设置增加、移除item的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mData.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_action_add:
                mAdapter.addData(1);  // 在指定位置插入
//                mAdapter.addData(); // 在末尾位置插入一个随机产生的数字
                break;
            case R.id.id_action_delete:
                mAdapter.removeData(1);
                break;
        }
        return true;
    }
}

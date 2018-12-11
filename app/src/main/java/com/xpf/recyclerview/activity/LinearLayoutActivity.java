package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpf.recyclerview.R;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:线性布局管理器练习
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class LinearLayoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 设置线性布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置适配器
        recyclerView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 此方法中低层还是调用的LayoutInflater方法,二第三个参数为null时，即没有指定相应的rootView，所以其显示
            // 不会充满整个手机屏幕
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linearlayout, parent, false);
            // 此方法中指明了parent,参数三:的值为boolean类型，意思是是否要绑定到父视图上，显示会充满整个手机屏幕的宽度
            //View view = LayoutInflater.from(LinearLayoutActivity.this).inflate(R.layout.item_linearlayout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 50;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}

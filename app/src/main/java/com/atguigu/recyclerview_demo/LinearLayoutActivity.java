package com.atguigu.recyclerview_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

// 线性布局加头
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
            View view = View.inflate(LinearLayoutActivity.this, R.layout.item_linearlayout, null);

            // 此方法中指明了parent,参数三:的值为boolean类型，意思是是否要绑定到父视图上，显示会充满整个手机屏幕的宽度
//            View view = LayoutInflater.from(LinearLayoutActivity.this).inflate(R.layout.item_linearlayout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 20;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}

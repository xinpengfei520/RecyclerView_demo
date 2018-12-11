package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpf.recyclerview.R;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:RecyclerView 的 StaggeredGridLayoutManager 加头
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class onViewAttachedToWindow extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_head_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // 设置布局管理器
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        // 设置适配器
        recyclerView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(onViewAttachedToWindow.this).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 30;
        }

        /**
         * 当每个item将要显示的时候都会调用此方法
         *
         * @param holder
         */
        @Override
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            super.onViewAttachedToWindow(holder);

            // LayoutParams 里面放了我们的控件的属性
            ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
            if (params != null && params instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams sLp = (StaggeredGridLayoutManager.LayoutParams) params;
                // 当 position == 0 时设置当前 Item 布局的全屏显示,参数是一个布尔类型 意思就是是否全屏
                sLp.setFullSpan(holder.getLayoutPosition() == 0);
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}

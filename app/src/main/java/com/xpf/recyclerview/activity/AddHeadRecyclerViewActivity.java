package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xpf.recyclerview.R;

/**
 * Created by xpf on 2016/11/27 :)
 * Function:RecyclerView的GridLayoutManager加头(SpanSize 实现)
 * 这种情况适用于指定位置设置不同的 position SpanSize 值
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class AddHeadRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_head_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 设置网格布局的列数为3(即当前最大列数)
        GridLayoutManager manager = new GridLayoutManager(this, 3);

        // 用来设置每个Item所占的列数
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1) {
                    // 当position == 0或者position == 1时返回的每个Item占两列，因为最大列数为3，所以在显示第二
                    // 个Item的时候不够了,就会自动显示在第二行
                    return 2;
                } else if (position == 6) { // 第 6 个位置占 3 列
                    return 3;
                } else if (position > 0 && position % 10 == 0) { // 大于 0 且取余 10 的占 2 列
                    return 2;
                }

                // 此处返回的是每个Item所占的列数,最大不超过设置的最大的列数
                return 1;
            }
        });

        // 设置布局管理器
        recyclerView.setLayoutManager(manager);
        // 设置适配器
        recyclerView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(AddHeadRecyclerViewActivity.this).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}

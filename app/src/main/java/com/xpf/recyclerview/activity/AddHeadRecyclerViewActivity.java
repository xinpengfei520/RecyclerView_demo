package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpf.recyclerview.R;

// RecyclerView的GridLayoutManager加头
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
                    // 当position == 0或者position == 1时返回的每个Item占两列,之前设置的最大列数为3,所以在显示第二个Item的时候不够了,就会自动显示在第二行
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
            return 9;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}

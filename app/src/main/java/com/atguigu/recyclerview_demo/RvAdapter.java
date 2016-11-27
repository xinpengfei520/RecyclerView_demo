package com.atguigu.recyclerview_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by xpf on 2016/11/27 :)
 * Wechat:18091383534
 * Function:RecyclerView的适配器
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater mInflater;

    public RvAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    // 创建ViewHolder,加载对应的布局文件
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(mInflater.inflate(R.layout.item_view, parent, false));
        return holder;
    }

    // 将数据与ViewHolder绑定
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(mDatas.get(position));

        // 设置点击事件
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "position===" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    // 在指定position位置插入
    public void addData(int position) {
        mDatas.add(position, "Insert");
        notifyItemInserted(position);
    }

    // 在末尾添加
    public void addData() {
        mDatas.add((int) (100 + Math.random() * 300) + "");
        notifyDataSetChanged();
    }

    // 移除
    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}

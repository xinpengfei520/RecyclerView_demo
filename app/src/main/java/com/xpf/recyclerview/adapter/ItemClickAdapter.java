package com.xpf.recyclerview.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.ItemClickEntity;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:ItemClickAdapter
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class ItemClickAdapter extends BaseMultiItemQuickAdapter<ItemClickEntity, BaseViewHolder> implements BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {

    private static final String TAG = "ItemClickAdapter";
    private NestAdapter nestAdapter;

    public ItemClickAdapter(List<ItemClickEntity> data) {
        super(data);
        addItemType(ItemClickEntity.CLICK_ITEM_VIEW, R.layout.item_click_view);
        addItemType(ItemClickEntity.CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview);
        addItemType(ItemClickEntity.LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view);
        addItemType(ItemClickEntity.LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview);
        addItemType(ItemClickEntity.NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ItemClickEntity item) {
        switch (helper.getItemViewType()) {
            case ItemClickEntity.CLICK_ITEM_VIEW:
                helper.addOnClickListener(R.id.btn);
                break;
            case ItemClickEntity.CLICK_ITEM_CHILD_VIEW:
                helper.addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add)
                        .addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add);
                break;
            case ItemClickEntity.LONG_CLICK_ITEM_VIEW:
                helper.addOnLongClickListener(R.id.btn);
                break;
            case ItemClickEntity.LONG_CLICK_ITEM_CHILD_VIEW:
                helper.addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add)
                        .addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add);
                break;
            case ItemClickEntity.NEST_CLICK_ITEM_CHILD_VIEW:
                helper.setNestView(R.id.item_click);
                final RecyclerView recyclerView = helper.getView(R.id.nest_list);
                recyclerView.setLayoutManager(new LinearLayoutManager(helper.itemView.getContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.setHasFixedSize(true);

                nestAdapter = new NestAdapter();
                nestAdapter.setOnItemClickListener(this);
                nestAdapter.setOnItemChildClickListener(this);
                recyclerView.setAdapter(nestAdapter);
                break;
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(mContext, "childView click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Log.d(TAG, "嵌套RecycleView item 收到: " + "点击了position:" + position);
        Toast.makeText(mContext, "嵌套RecycleView item 收到: " + "点击了position:" + position, Toast.LENGTH_SHORT).show();
    }
}

package com.xpf.recyclerview.adapter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.ItemClickEntity;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:ItemClickAdapter
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class ItemClickAdapter extends BaseMultiItemQuickAdapter<ItemClickEntity, BaseViewHolder>
        implements OnItemClickListener, OnItemChildClickListener {

    private static final String TAG = "ItemClickAdapter";
    private NestAdapter nestAdapter;

    public ItemClickAdapter(List<ItemClickEntity> data) {
        super(data);
        addItemType(ItemClickEntity.CLICK_ITEM_VIEW, R.layout.item_click_view);
        addItemType(ItemClickEntity.CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview);
        addItemType(ItemClickEntity.LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view);
        addItemType(ItemClickEntity.LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview);
        addItemType(ItemClickEntity.NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click);

        addChildClickViewIds(R.id.btn, R.id.iv_num_reduce, R.id.iv_num_add, R.id.item_click);

        addChildLongClickViewIds(R.id.iv_num_reduce, R.id.iv_num_add, R.id.btn);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ItemClickEntity item) {
        switch (helper.getItemViewType()) {
            case ItemClickEntity.CLICK_ITEM_VIEW:
                break;
            case ItemClickEntity.CLICK_ITEM_CHILD_VIEW:
                break;
            case ItemClickEntity.LONG_CLICK_ITEM_VIEW:
                break;
            case ItemClickEntity.LONG_CLICK_ITEM_CHILD_VIEW:
                break;
            case ItemClickEntity.NEST_CLICK_ITEM_CHILD_VIEW:
                final RecyclerView recyclerView = helper.getView(R.id.nest_list);
                LinearLayoutManager manager =
                        new LinearLayoutManager(helper.itemView.getContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(manager);
                recyclerView.setHasFixedSize(true);

                if (recyclerView.getAdapter() == null) {
                    nestAdapter = new NestAdapter();
                    nestAdapter.setOnItemClickListener(this);
                    nestAdapter.setOnItemChildClickListener(this);
                    recyclerView.setAdapter(nestAdapter);
                }
                break;
        }
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(view.getContext(), "childView click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Log.d(TAG, "嵌套RecycleView item 收到: " + "点击了position:" + position);
        Toast.makeText(view.getContext(), "嵌套RecycleView item 收到: " + "点击了position:" + position, Toast.LENGTH_SHORT).show();
    }
}

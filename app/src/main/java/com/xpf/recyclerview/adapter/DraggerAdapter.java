package com.xpf.recyclerview.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpf.recyclerview.R;

import java.util.List;

/**
 * Created by x-sir on 2018/12/24 :)
 * Function:
 */
public class DraggerAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {

    public DraggerAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tvItem, item);
        helper.setImageResource(R.id.ivHead, R.drawable.icon_chart);
    }
}

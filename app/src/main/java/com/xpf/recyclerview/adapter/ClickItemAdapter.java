package com.xpf.recyclerview.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.ClickItem;

import java.util.List;

/**
 * Created by x-sir on 2018/12/11 :)
 * Function:
 */
public class ClickItemAdapter extends BaseQuickAdapter<ClickItem, BaseViewHolder> {

    public ClickItemAdapter(int layoutResId, @Nullable List<ClickItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClickItem item) {
        helper.setText(R.id.textView, item.getTitle());
    }
}

package com.xpf.recyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;

import java.util.List;

/**
 * Created by x-sir on 2018/12/19 :)
 * Function:
 */
public class LinearLayoutAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public LinearLayoutAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.textView, item);
    }
}

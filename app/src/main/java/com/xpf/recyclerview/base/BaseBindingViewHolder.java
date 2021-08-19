package com.xpf.recyclerview.base;

import android.view.View;

import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;


/**
 * Created by x-sir on 2018/12/26 :)
 * Function:
 */
public class BaseBindingViewHolder<Binding extends ViewDataBinding> extends BaseViewHolder {

    private Binding mBinding;

    public BaseBindingViewHolder(View view) {
        super(view);
    }

    public Binding getBinding() {
        return mBinding;
    }

    public void setBinding(Binding binding) {
        mBinding = binding;
    }
}

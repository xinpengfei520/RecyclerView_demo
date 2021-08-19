package com.xpf.recyclerview.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * Created by x-sir on 2018/12/26 :)
 * Function:
 */
public abstract class BaseDataBindingAdapter<T, Binding extends ViewDataBinding> extends
        BaseQuickAdapter<T, BaseBindingViewHolder<Binding>> {

    public BaseDataBindingAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public BaseDataBindingAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected BaseBindingViewHolder<Binding> createBaseViewHolder(View view) {
        return new BaseBindingViewHolder<>(view);
    }

    @Override
    protected BaseBindingViewHolder<Binding> createBaseViewHolder(ViewGroup parent, int layoutResId) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        Binding binding = DataBindingUtil.inflate(layoutInflater, layoutResId, parent, false);
        View view = null;
        if (binding == null) {
//            view = getItemView(layoutResId, parent);
        } else {
            view = binding.getRoot();
        }
        BaseBindingViewHolder<Binding> holder = new BaseBindingViewHolder<>(view);
        holder.setBinding(binding);
        return holder;
    }

    @Override
    protected void convert(BaseBindingViewHolder<Binding> helper, T item) {
        convert(helper.getBinding(), item);
        helper.getBinding().executePendingBindings();
    }

    protected abstract void convert(Binding binding, T item);
}

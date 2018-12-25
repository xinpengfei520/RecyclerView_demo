package com.xpf.recyclerview.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.BR;
import com.xpf.recyclerview.entity.Film;
import com.xpf.recyclerview.entity.FilmPresenter;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:DataBinding 实现数据绑定
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class DataBindingAdapter extends BaseQuickAdapter<Film, DataBindingAdapter.MovieViewHolder> {

    private FilmPresenter mPresenter;

    public DataBindingAdapter(int layoutResId, List<Film> data) {
        super(layoutResId, data);
        mPresenter = new FilmPresenter();
    }

    @Override
    protected void convert(MovieViewHolder helper, Film item) {
        ViewDataBinding binding = helper.getBinding();
        // BR 什么鬼？？？
        binding.setVariable(BR.movie, item);
        binding.setVariable(BR.presenter, mPresenter);
        binding.executePendingBindings();
        helper.setImageResource(R.id.iv, R.drawable.film_cover);
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    public static class MovieViewHolder extends BaseViewHolder {

        public MovieViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }
}

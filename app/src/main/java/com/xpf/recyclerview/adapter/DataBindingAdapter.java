package com.xpf.recyclerview.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.databinding.ItemMovieBinding;
import com.xpf.recyclerview.entity.Film;
import com.xpf.recyclerview.entity.FilmPresenter;

import java.util.List;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:DataBinding 实现数据绑定
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class DataBindingAdapter extends BaseQuickAdapter<Film, BaseDataBindingHolder<ItemMovieBinding>> {

    private FilmPresenter mPresenter;

    public DataBindingAdapter(int layoutResId, List<Film> data) {
        super(layoutResId, data);
        mPresenter = new FilmPresenter();
    }

    @Override
    protected void convert(BaseDataBindingHolder<ItemMovieBinding> holder, Film item) {
        // 获取 Binding
        ItemMovieBinding binding = holder.getDataBinding();
        if (binding != null) {
            binding.setMovie(item);
            binding.setPresenter(mPresenter);
            binding.executePendingBindings();
            binding.iv.setImageResource(R.drawable.film_cover);
            //holder.setImageResource(R.id.iv, R.drawable.film_cover);
        }
    }
}

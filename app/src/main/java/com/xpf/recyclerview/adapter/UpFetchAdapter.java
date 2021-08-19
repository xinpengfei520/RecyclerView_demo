package com.xpf.recyclerview.adapter;

import com.chad.library.adapter.base.module.UpFetchModule;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.base.BaseDataBindingAdapter;
import com.xpf.recyclerview.databinding.ItemMovieBinding;
import com.xpf.recyclerview.entity.Film;

/**
 * Created by x-sir on 2018/12/26 :)
 * Function:
 */
public class UpFetchAdapter extends BaseDataBindingAdapter<Film, ItemMovieBinding> implements UpFetchModule {

    public UpFetchAdapter() {
        super(R.layout.item_movie, null);
    }

    @Override
    protected void convert(ItemMovieBinding binding, Film item) {
        binding.setMovie(item);
    }
}

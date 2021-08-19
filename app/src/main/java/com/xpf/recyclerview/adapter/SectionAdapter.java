package com.xpf.recyclerview.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.Movie;
import com.xpf.recyclerview.entity.MySection;

import java.util.List;


/**
 * Created by x-sir on 2018/12/24 :)
 * Function:
 */
public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List<MySection> data) {
        super(sectionHeadResId, data);
        // 此处有个坑！！！super 方法传的是 header 的资源 id，setNormalLayout 传递的是内容 id，不要调用
        // 三个参数的父类构造方法，把三个参数都传过去，否则在 convert 方法中找不到控件的 id
        setNormalLayout(layoutResId);
        addChildClickViewIds(R.id.tvHeader);
    }

    @Override
    protected void convertHeader(BaseViewHolder holder, MySection item) {
        holder.setText(R.id.tvHeader, item.getHeader());
        holder.setVisible(R.id.tvMore, item.isMore());
    }

    @Override
    protected void convert(BaseViewHolder holder, MySection item) {
        Movie movie = item.getMovie();
        holder.setText(R.id.tv, movie.getName());

        RequestOptions options = new RequestOptions().placeholder(R.mipmap.ic_launcher);

        Glide.with(getContext())
                .load(movie.getCover())
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(options)
                .into((ImageView) holder.getView(R.id.iv));
    }
}

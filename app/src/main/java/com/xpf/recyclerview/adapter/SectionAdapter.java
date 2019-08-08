package com.xpf.recyclerview.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.Movie;
import com.xpf.recyclerview.entity.MySection;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

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
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MySection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        Movie movie = item.t;
        helper.setText(R.id.tv, movie.getName());
        RequestOptions options = new RequestOptions().placeholder(R.mipmap.ic_launcher);
        Glide.with(mContext).load(movie.getCover()).transition(withCrossFade()).apply(options)
                .into((ImageView) helper.getView(R.id.iv));
    }
}

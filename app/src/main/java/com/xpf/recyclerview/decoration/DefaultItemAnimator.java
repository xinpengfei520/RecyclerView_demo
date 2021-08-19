package com.xpf.recyclerview.decoration;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import jp.wasabeef.recyclerview.animators.BaseItemAnimator;

/**
 * Created by xpf on 2016/12/27 :)
 * Function:DefaultItemAnimator
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class DefaultItemAnimator extends BaseItemAnimator {

    @Override
    protected void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .alpha(0)
                .setDuration(getRemoveDuration())
                .setListener(new DefaultRemoveVpaListener(holder))
                .setStartDelay(getRemoveDelay(holder))
                .start();
    }

    @Override
    protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
        ViewCompat.setAlpha(holder.itemView, 0);
    }

    @Override
    protected void animateAddImpl(final RecyclerView.ViewHolder holder) {
        ViewCompat.animate(holder.itemView)
                .alpha(1)
                .setDuration(getAddDuration())
                .setListener(new DefaultAddVpaListener(holder))
                .setStartDelay(getAddDelay(holder))
                .start();
    }
}

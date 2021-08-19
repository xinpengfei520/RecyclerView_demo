package com.xpf.recyclerview.provider.tree;

import android.util.Log;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.Level1Item;

/**
 * The second provider.
 * @author x-sir :)
 * @date 2021/8/19
 */
public class SecondProvider extends BaseNodeProvider {

    private static final String TAG = "SecondProvider";

    @Override
    public int getItemViewType() {
        return 2;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_expandable_second;
    }

    @Override
    public void convert(BaseViewHolder holder, BaseNode item) {
        final Level1Item lv1 = (Level1Item) item;
        holder.setText(R.id.title, lv1.title)
                .setText(R.id.sub_title, lv1.subTitle)
                .setImageResource(R.id.iv, lv1.isExpanded() ? R.drawable.arrow_bottom : R.drawable.arrow_right);
        holder.itemView.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            Log.d(TAG, "Level 1 item pos: " + pos);
            if (lv1.isExpanded()) {
                getAdapter().collapse(pos, false);
            } else {
                getAdapter().expand(pos, false);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            int pos = holder.getAdapterPosition();
            getAdapter().removeAt(pos);
            return true;
        });
    }
}

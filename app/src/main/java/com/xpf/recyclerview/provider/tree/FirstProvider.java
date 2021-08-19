package com.xpf.recyclerview.provider.tree;

import android.util.Log;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.Level0Item;

/**
 * The first provider.
 * @author x-sir :)
 * @date 2021/8/19
 */
public class FirstProvider extends BaseNodeProvider {

    private static final String TAG = "FirstProvider";

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_expandable_first;
    }

    @Override
    public void convert(BaseViewHolder holder, BaseNode item) {
        holder.setImageResource(R.id.iv_head, R.drawable.icon_chart);
        final Level0Item lv0 = (Level0Item) item;
        holder.setText(R.id.title, lv0.title)
                .setText(R.id.sub_title, lv0.subTitle)
                .setImageResource(R.id.iv, lv0.isExpanded() ? R.drawable.arrow_bottom : R.drawable.arrow_right);
        holder.itemView.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            Log.d(TAG, "Level 0 item pos: " + pos);
            if (lv0.isExpanded()) {
                getAdapter().collapse(pos);
            } else {
                getAdapter().expand(pos);
            }
        });
    }
}

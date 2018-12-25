package com.xpf.recyclerview.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.Level0Item;
import com.xpf.recyclerview.entity.Level1Item;
import com.xpf.recyclerview.entity.Person;

import java.util.List;

/**
 * Created by x-sir on 2018/12/25 :)
 * Function:ExpandableItemAdapter
 */
public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private static final String TAG = "ExpandableItemAdapter";

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        addItemType(TYPE_PERSON, R.layout.item_expandable_lv2);
    }

    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                holder.setImageResource(R.id.iv_head, R.drawable.icon_chart);
                final Level0Item lv0 = (Level0Item) item;
                holder.setText(R.id.title, lv0.title)
                        .setText(R.id.sub_title, lv0.subTitle)
                        .setImageResource(R.id.iv, lv0.isExpanded() ? R.drawable.arrow_bottom : R.drawable.arrow_right);
                holder.itemView.setOnClickListener(v -> {
                    int pos = holder.getAdapterPosition();
                    Log.d(TAG, "Level 0 item pos: " + pos);
                    if (lv0.isExpanded()) {
                        collapse(pos);
                    } else {
                        expand(pos);
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                holder.setText(R.id.title, lv1.title)
                        .setText(R.id.sub_title, lv1.subTitle)
                        .setImageResource(R.id.iv, lv1.isExpanded() ? R.drawable.arrow_bottom : R.drawable.arrow_right);
                holder.itemView.setOnClickListener(v -> {
                    int pos = holder.getAdapterPosition();
                    Log.d(TAG, "Level 1 item pos: " + pos);
                    if (lv1.isExpanded()) {
                        collapse(pos, false);
                    } else {
                        expand(pos, false);
                    }
                });

                holder.itemView.setOnLongClickListener(v -> {
                    int pos = holder.getAdapterPosition();
                    remove(pos);
                    return true;
                });
                break;
            case TYPE_PERSON:
                final Person person = (Person) item;
                holder.setText(R.id.tv, person.name + " parent pos: " + getParentPosition(person));
                holder.itemView.setOnClickListener(view -> {
                    int pos = holder.getAdapterPosition();
                    remove(pos);
                });
                break;
        }
    }
}

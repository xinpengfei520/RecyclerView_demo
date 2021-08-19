package com.xpf.recyclerview.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.SectionMultiItem;

import java.util.List;

/**
 * Created by x-sir on 2018/12/24 :)
 * Function:SectionMultiItemAdapter
 */
public class SectionMultiItemAdapter extends BaseMultiItemQuickAdapter<SectionMultiItem, BaseViewHolder> {

    /**
     * init SectionMultiItemAdapter
     * 1. add your header resource layout
     * 2. add some kind of items
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public SectionMultiItemAdapter(List<SectionMultiItem> data) {
        super(data);
        addItemType(SectionMultiItem.HEAD, R.layout.item_section_header);
        addItemType(SectionMultiItem.TEXT, R.layout.item_text_view);
        addItemType(SectionMultiItem.IMG_TEXT, R.layout.item_img_text_view);
    }

    /**
     * 处理多类型 Item 的数据
     *
     * @param helper
     * @param item
     */
    @Override
    protected void convert(BaseViewHolder helper, SectionMultiItem item) {
        switch (helper.getItemViewType()) {
            case SectionMultiItem.HEAD:
                helper.setText(R.id.tvHeader, item.getHeader());
                helper.setVisible(R.id.tvMore, item.isMore());
                addChildClickViewIds(R.id.tvMore, R.id.card_view);
                break;
            case SectionMultiItem.TEXT:
                helper.setText(R.id.tv, item.getVideo().getName());
                break;
            case SectionMultiItem.IMG_TEXT:
                helper.setImageResource(R.id.iv, R.drawable.small_wawa);
                break;
        }
    }
}

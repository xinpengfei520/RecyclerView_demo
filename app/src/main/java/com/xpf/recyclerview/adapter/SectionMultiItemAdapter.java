package com.xpf.recyclerview.adapter;

import com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.SectionMultiItem;

import java.util.List;

/**
 * Created by x-sir on 2018/12/24 :)
 * Function:SectionMultiItemAdapter
 */
public class SectionMultiItemAdapter extends BaseSectionMultiItemQuickAdapter<SectionMultiItem, BaseViewHolder> {

    /**
     * init SectionMultiItemAdapter
     * 1. add your header resource layout
     * 2. add some kind of items
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionMultiItemAdapter(int sectionHeadResId, List data) {
        super(sectionHeadResId, data);
        addItemType(SectionMultiItem.TEXT, R.layout.item_text_view);
        addItemType(SectionMultiItem.IMG_TEXT, R.layout.item_img_text_view);
    }

    /**
     * 处理头部数据
     * @param helper
     * @param item
     */
    @Override
    protected void convertHead(BaseViewHolder helper, final SectionMultiItem item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    /**
     * 处理多类型 Item 的数据
     * @param helper
     * @param item
     */
    @Override
    protected void convert(BaseViewHolder helper, SectionMultiItem item) {
        helper.addOnClickListener(R.id.card_view);
        switch (helper.getItemViewType()) {
            case SectionMultiItem.TEXT:
                helper.setText(R.id.tv, item.getVideo().getName());
                break;
            case SectionMultiItem.IMG_TEXT:
                helper.setImageResource(R.id.iv, R.drawable.small_wawa);
                break;
        }
    }
}

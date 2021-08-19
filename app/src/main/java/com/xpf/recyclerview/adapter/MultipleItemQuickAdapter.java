package com.xpf.recyclerview.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.FirstTypeBean;
import com.xpf.recyclerview.entity.FourTypeBean;
import com.xpf.recyclerview.entity.MultipleQuickEntity;
import com.xpf.recyclerview.entity.SecondTypeBean;
import com.xpf.recyclerview.entity.ThirdTypeBean;

import java.util.List;

/**
 * Created by x-sir on 2018/12/19 :)
 * Function:
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleQuickEntity, BaseViewHolder> implements LoadMoreModule {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemQuickAdapter(List<MultipleQuickEntity> data) {
        super(data);
        addItemType(MultipleQuickEntity.NAME, R.layout.item_name);
        addItemType(MultipleQuickEntity.NAME_IMG, R.layout.item_name_image);
        addItemType(MultipleQuickEntity.NAME_CONTENT, R.layout.item_name_content);
        addItemType(MultipleQuickEntity.LOGO_CONTENT, R.layout.item_logo_content);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleQuickEntity item) {
        Object object = item.getT();
        switch (helper.getItemViewType()) {
            case MultipleQuickEntity.NAME:
                if (object instanceof FirstTypeBean) {
                    FirstTypeBean bean = (FirstTypeBean) object;
                    helper.setText(R.id.textView, bean.getName());
                }
                break;
            case MultipleQuickEntity.NAME_IMG:
                if (object instanceof SecondTypeBean) {
                    SecondTypeBean bean = (SecondTypeBean) object;
                    helper.setText(R.id.textView, bean.getName());
                    helper.setImageResource(R.id.imageView, bean.getImgId());
                }
                break;
            case MultipleQuickEntity.NAME_CONTENT:
                if (object instanceof ThirdTypeBean) {
                    ThirdTypeBean bean = (ThirdTypeBean) object;
                    helper.setText(R.id.tvName, bean.getName());
                    helper.setText(R.id.tvContent, bean.getContent());
                }
                break;
            case MultipleQuickEntity.LOGO_CONTENT:
                if (object instanceof FourTypeBean) {
                    FourTypeBean bean = (FourTypeBean) object;
                    helper.setImageResource(R.id.ivLogo, bean.getLogoId());
                    helper.setText(R.id.tvContent, bean.getContent());

                    switch (helper.getLayoutPosition() % 2) {
                        case 0:
                            helper.setImageResource(R.id.ivLogo, bean.getLogoId());
                            break;
                        case 1:
                            helper.setImageResource(R.id.ivLogo, R.mipmap.ic_launcher2);
                            break;
                    }
                }
                break;
        }
    }
}

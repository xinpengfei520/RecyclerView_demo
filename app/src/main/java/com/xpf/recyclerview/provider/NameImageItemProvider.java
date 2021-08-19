package com.xpf.recyclerview.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemAdapter;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.entity.SecondTypeBean;

/**
 * Created by x-sir on 2018/12/13 :)
 * Function:
 */
public class NameImageItemProvider extends BaseItemProvider<MultipleEntity> {

    @Override
    public int getItemViewType() {
        return MultipleItemAdapter.TYPE_NAME_IMG;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_name_image;
    }

    @Override
    public void convert(BaseViewHolder holder, MultipleEntity data) {
        Object object = data.getT();
        if (object instanceof SecondTypeBean) {
            SecondTypeBean bean = (SecondTypeBean) object;
            holder.setText(R.id.textView, bean.getName());
            holder.setImageResource(R.id.imageView, bean.getImgId());
        }
    }
}

package com.xpf.recyclerview.provider;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemAdapter;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.entity.ThirdTypeBean;

/**
 * Created by x-sir on 2018/12/13 :)
 * Function:
 */
public class NameContentItemProvider extends BaseItemProvider<MultipleEntity> {

    @Override
    public int getItemViewType() {
        return MultipleItemAdapter.TYPE_NAME_CONTENT;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_name_content;
    }

    @Override
    public void convert(BaseViewHolder holder, MultipleEntity data) {
        Object object = data.getT();
        if (object instanceof ThirdTypeBean) {
            ThirdTypeBean bean = (ThirdTypeBean) object;
            holder.setText(R.id.tvName, bean.getName());
            holder.setText(R.id.tvContent, bean.getContent());
        }
    }
}

package com.xpf.recyclerview.provider;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemAdapter;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.entity.ThirdTypeBean;

/**
 * Created by x-sir on 2018/12/13 :)
 * Function:
 */
public class NameContentItemProvider extends BaseItemProvider<MultipleEntity, BaseViewHolder> {

    @Override
    public int viewType() {
        return MultipleItemAdapter.TYPE_NAME_CONTENT;
    }

    @Override
    public int layout() {
        return R.layout.item_name_content;
    }

    @Override
    public void convert(BaseViewHolder helper, MultipleEntity data, int position) {
        Object object = data.getT();
        if (object instanceof ThirdTypeBean) {
            ThirdTypeBean bean = (ThirdTypeBean) object;
            helper.setText(R.id.tvName, bean.getName());
            helper.setText(R.id.tvContent, bean.getContent());
        }
    }
}

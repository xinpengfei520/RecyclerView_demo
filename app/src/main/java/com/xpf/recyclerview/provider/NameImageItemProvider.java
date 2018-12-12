package com.xpf.recyclerview.provider;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemAdapter;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.entity.SecondTypeBean;

/**
 * Created by x-sir on 2018/12/13 :)
 * Function:
 */
public class NameImageItemProvider extends BaseItemProvider<MultipleEntity, BaseViewHolder> {

    @Override
    public int viewType() {
        return MultipleItemAdapter.TYPE_NAME_IMG;
    }

    @Override
    public int layout() {
        return R.layout.item_name_image;
    }

    @Override
    public void convert(BaseViewHolder helper, MultipleEntity data, int position) {
        Object object = data.getT();
        if (data.getT() instanceof SecondTypeBean) {
            SecondTypeBean bean = (SecondTypeBean) object;
            helper.setText(R.id.textView, bean.getName());
            helper.setImageResource(R.id.imageView, bean.getImgId());
        }
    }
}

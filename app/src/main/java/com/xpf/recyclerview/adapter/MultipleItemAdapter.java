package com.xpf.recyclerview.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.provider.NameContentItemProvider;
import com.xpf.recyclerview.provider.NameImageItemProvider;
import com.xpf.recyclerview.provider.NameItemProvider;

import java.util.List;

/**
 * Created by x-sir on 2018/12/13 :)
 * Function:
 */
public class MultipleItemAdapter extends MultipleItemRvAdapter<MultipleEntity, BaseViewHolder> {

    public static final int TYPE_NAME = 1;
    public static final int TYPE_NAME_IMG = 2;
    public static final int TYPE_NAME_CONTENT = 3;

    public MultipleItemAdapter(@Nullable List<MultipleEntity> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(MultipleEntity multipleEntity) {
        int type = 0;

        switch (multipleEntity.getType()) {
            case MultipleEntity.NAME:
                type = TYPE_NAME;
                break;
            case MultipleEntity.NAME_IMG:
                type = TYPE_NAME_IMG;
                break;
            case MultipleEntity.NAME_CONTENT:
                type = TYPE_NAME_CONTENT;
                break;
            default:
                break;
        }

        return type;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new NameItemProvider());
        mProviderDelegate.registerProvider(new NameImageItemProvider());
        mProviderDelegate.registerProvider(new NameContentItemProvider());
    }
}

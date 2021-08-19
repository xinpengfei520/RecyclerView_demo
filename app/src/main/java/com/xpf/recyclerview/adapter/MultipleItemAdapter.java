package com.xpf.recyclerview.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.provider.NameContentItemProvider;
import com.xpf.recyclerview.provider.NameImageItemProvider;
import com.xpf.recyclerview.provider.NameItemProvider;

import java.util.List;

/**
 * Created by x-sir on 2018/12/13 :)
 * Function:
 */
public class MultipleItemAdapter extends BaseProviderMultiAdapter<MultipleEntity> {

    public static final int TYPE_NAME = 1;
    public static final int TYPE_NAME_IMG = 2;
    public static final int TYPE_NAME_CONTENT = 3;

    public MultipleItemAdapter(@Nullable List<MultipleEntity> data) {
        super(data);
        addItemProvider(new NameItemProvider());
        addItemProvider(new NameImageItemProvider());
        addItemProvider(new NameContentItemProvider());
    }

    @Override
    protected int getItemType(List<? extends MultipleEntity> list, int i) {
        int type = 0;

        switch (list.get(i).getType()) {
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
}

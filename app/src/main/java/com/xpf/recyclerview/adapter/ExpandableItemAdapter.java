package com.xpf.recyclerview.adapter;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.xpf.recyclerview.entity.Level0Item;
import com.xpf.recyclerview.entity.Level1Item;
import com.xpf.recyclerview.entity.Level2Item;
import com.xpf.recyclerview.provider.tree.FirstProvider;
import com.xpf.recyclerview.provider.tree.SecondProvider;
import com.xpf.recyclerview.provider.tree.ThirdProvider;

import java.util.List;

/**
 * Created by x-sir on 2018/12/25 :)
 * Function:ExpandableItemAdapter
 */
public class ExpandableItemAdapter extends BaseNodeAdapter {

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     */
    public ExpandableItemAdapter() {
        addNodeProvider(new FirstProvider());
        addNodeProvider(new SecondProvider());
        addNodeProvider(new ThirdProvider());
    }

    @Override
    protected int getItemType(List<? extends BaseNode> data, int position) {
        BaseNode node = data.get(position);
        if (node instanceof Level0Item) {
            return 1;
        } else if (node instanceof Level1Item) {
            return 2;
        } else if (node instanceof Level2Item) {
            return 3;
        }
        return -1;
    }
}

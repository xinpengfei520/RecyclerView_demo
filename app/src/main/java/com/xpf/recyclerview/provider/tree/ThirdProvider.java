package com.xpf.recyclerview.provider.tree;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.Person;

/**
 * The third provider.
 * @author x-sir :)
 * @date 2021/8/19
 */
public class ThirdProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 3;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_expandable_third;
    }

    @Override
    public void convert(BaseViewHolder holder, BaseNode item) {
        final Person person = (Person) item;
        holder.setText(R.id.tv, person.name);
        holder.itemView.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            getAdapter().removeAt(pos);
        });
    }
}

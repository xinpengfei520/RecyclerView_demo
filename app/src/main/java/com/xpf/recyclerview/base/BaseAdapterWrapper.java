package com.xpf.recyclerview.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by x-sir on 2018/12/27 :)
 * Function:BaseAdapterWrapper 是 Adapter 的包装类，包装了头布局和为布局的实现
 */
public class BaseAdapterWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    enum ITEM_TYPE {
        HEADER,
        FOOTER,
        NORMAL
    }

    private RecyclerView.Adapter mAdapter;
    private View mHeaderView;
    private View mFooterView;

    public BaseAdapterWrapper(RecyclerView.Adapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE.HEADER.ordinal();
        } else if (position == mAdapter.getItemCount() + 1) {
            return ITEM_TYPE.FOOTER.ordinal();
        } else {
            return ITEM_TYPE.NORMAL.ordinal();
        }
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount() + 2;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0 || position == (mAdapter.getItemCount() + 1)) {
            return;
        }
        mAdapter.onBindViewHolder((holder), position - 1);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.HEADER.ordinal()) {
            return new RecyclerView.ViewHolder(mHeaderView) {
            };
        } else if (viewType == ITEM_TYPE.FOOTER.ordinal()) {
            return new RecyclerView.ViewHolder(mFooterView) {
            };
        } else {
            return mAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    /**
     * add a header view.
     *
     * @param view
     */
    public void addHeaderView(View view) {
        this.mHeaderView = view;
    }

    /**
     * add a footer view.
     *
     * @param view
     */
    public void addFooterView(View view) {
        this.mFooterView = view;
    }
}

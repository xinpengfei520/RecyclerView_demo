package com.xpf.recyclerview.base;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.util.Collections;
import java.util.List;

/**
 * Created by x-sir on 2018/12/27 :)
 * Function:BaseItemTouchCallback
 */
public class BaseItemTouchCallback<T, K extends RecyclerView.ViewHolder> extends ItemTouchHelper.Callback {

    private static final String TAG = "BaseItemTouchCallback";
    private RecyclerView.Adapter<K> mAdapter;
    private List<T> mData;

    public BaseItemTouchCallback(RecyclerView.Adapter<K> adapter, List<T> data) {
        mAdapter = adapter;
        mData = data;
    }

    /**
     * 设置支持的拖拽、滑动的方向
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlag = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int from = viewHolder.getAdapterPosition();
        int to = target.getAdapterPosition();
        Collections.swap(mData, from, to);
        mAdapter.notifyItemMoved(from, to);
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int pos = viewHolder.getAdapterPosition();
        mData.remove(pos);
        mAdapter.notifyItemRemoved(pos);
    }

    /**
     * 状态改变时回调
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        Log.i(TAG, "onSelectedChanged():" + actionState);
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(0xffbcbcbc);
        }
    }

    /**
     * 拖拽或滑动完成之后调用，用来清除一些状态
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(0xffeeeeee);
    }

    public interface OnStartDragListener {
        void startDrag(RecyclerView.ViewHolder holder);
    }
}

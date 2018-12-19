package com.xpf.recyclerview.request;

import android.os.Handler;
import android.os.Looper;

import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.MultipleQuickEntity;

import java.util.List;

/**
 * Created by x-sir on 2018/12/19 :)
 * Function:模拟网络请求
 */
public class SimulateRequest extends Thread {

    /**
     * 每页的数量
     */
    private static final int PAGE_SIZE = 10;
    /**
     * 页数
     */
    private int mPage;
    private RequestCallBack mCallBack;
    private Handler mHandler;

    private static boolean mFirstPageNoMore;
    private static boolean mFirstError = true;

    public SimulateRequest(int page, RequestCallBack callBack) {
        mPage = page;
        mCallBack = callBack;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (mPage == 2 && mFirstError) {
            mFirstError = false;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallBack.fail(new RuntimeException("fail"));
                }
            });
        } else {
            int size = PAGE_SIZE;
            if (mPage == 1) {
                if (mFirstPageNoMore) {
                    size = 1;
                }
                mFirstPageNoMore = !mFirstPageNoMore;
                if (!mFirstError) {
                    mFirstError = true;
                }
            } else if (mPage == 4) {
                size = 1;
            }

            final int dataSize = size;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    // 此处除以 5 是因为每一组数据有 5 条，所以 10 条数据是 2 组
                    mCallBack.success(DataServer.getMultipleItemData(dataSize / 5));
                }
            });
        }
    }

    public interface RequestCallBack {
        void success(List<MultipleQuickEntity> data);

        void fail(Exception e);
    }
}

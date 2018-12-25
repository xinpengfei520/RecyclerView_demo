package com.xpf.recyclerview;

import android.app.Application;
import android.content.Context;

/**
 * Created by x-sir on 2018/12/25 :)
 * Function:
 */
public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}

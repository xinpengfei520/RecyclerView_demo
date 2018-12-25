package com.xpf.recyclerview.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.xpf.recyclerview.MyApplication;

/**
 * Created by x-sir on 2018/12/25 :)
 * Function:
 */
public class ToastUtils {

    public static void showShort(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(MyApplication.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showLong(String message) {
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(MyApplication.getContext(), message, Toast.LENGTH_LONG).show();
        }
    }
}

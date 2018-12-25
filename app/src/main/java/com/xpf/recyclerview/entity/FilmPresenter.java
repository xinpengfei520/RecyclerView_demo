package com.xpf.recyclerview.entity;

import android.view.View;

import com.xpf.recyclerview.utils.ToastUtils;

/**
 * Created by xpf on 2018/12/24 :)
 * Function:FilmPresenter
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class FilmPresenter {

    public void buyTicket(View view, Film film) {
        ToastUtils.showShort("buy ticket: " + film.name);
    }
}

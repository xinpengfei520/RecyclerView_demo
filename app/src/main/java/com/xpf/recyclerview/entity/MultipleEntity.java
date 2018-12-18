package com.xpf.recyclerview.entity;

/**
 * Created by x-sir on 2018/12/12 :)
 * Function:封装一个多类型的数据
 */
public class MultipleEntity<T> {

    public static final int NAME = 1;
    public static final int NAME_IMG = 2;
    public static final int NAME_CONTENT = 3;

    private int type;
    private T t;

    public MultipleEntity() {
    }

    public MultipleEntity(int type, T t) {
        this.type = type;
        this.t = t;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}

package com.xpf.recyclerview.data;

import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.FirstTypeBean;
import com.xpf.recyclerview.entity.FourTypeBean;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.entity.MultipleQuickEntity;
import com.xpf.recyclerview.entity.SecondTypeBean;
import com.xpf.recyclerview.entity.ThirdTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x-sir on 2018/12/18 :)
 * Function:模拟数据服务
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class DataServer {

    private static final String NAME = "「IT大飞说」";
    private static final String LOGO_NAME = "我是机器人";
    private static final int IMG_ID = R.drawable.myqrcode;
    private static final int LOGO_ID = R.mipmap.ic_launcher;
    private static final String CONTENT = "魔都某非著名互联网创业公司码农，一个狂热的技术人！";

    /**
     * 制造一些假数据，实际一般都是从网络获取
     */
    public static List<MultipleEntity> getData() {
        List<MultipleEntity> list = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            FirstTypeBean firstTypeBean = new FirstTypeBean(NAME);
            list.add(new MultipleEntity<>(MultipleEntity.NAME, firstTypeBean));

            SecondTypeBean secondTypeBean = new SecondTypeBean(NAME, IMG_ID);
            list.add(new MultipleEntity<>(MultipleEntity.NAME_IMG, secondTypeBean));

            ThirdTypeBean thirdTypeBean = new ThirdTypeBean(NAME, CONTENT);
            list.add(new MultipleEntity<>(MultipleEntity.NAME_CONTENT, thirdTypeBean));
        }

        return list;
    }

    public static List<MultipleQuickEntity> getMultipleItemData() {
        return getMultipleItemData(10);
    }

    public static List<MultipleQuickEntity> getMultipleItemData(int size) {
        List<MultipleQuickEntity> list = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            FirstTypeBean firstTypeBean = new FirstTypeBean(NAME);
            list.add(new MultipleQuickEntity<>(MultipleQuickEntity.NAME, firstTypeBean, MultipleQuickEntity.SPAN_SIZE1));

            SecondTypeBean secondTypeBean = new SecondTypeBean(NAME, IMG_ID);
            list.add(new MultipleQuickEntity<>(MultipleQuickEntity.NAME_IMG, secondTypeBean, MultipleQuickEntity.SPAN_SIZE3));

            ThirdTypeBean thirdTypeBean = new ThirdTypeBean(NAME, CONTENT);
            list.add(new MultipleQuickEntity<>(MultipleQuickEntity.NAME_CONTENT, thirdTypeBean, MultipleQuickEntity.SPAN_SIZE4));

            FourTypeBean fourTypeBean = new FourTypeBean(LOGO_NAME, LOGO_ID);
            list.add(new MultipleQuickEntity<>(MultipleQuickEntity.LOGO_CONTENT, fourTypeBean, MultipleQuickEntity.SPAN_SIZE2));

            FourTypeBean fourTypeBean2 = new FourTypeBean(LOGO_NAME, LOGO_ID);
            list.add(new MultipleQuickEntity<>(MultipleQuickEntity.LOGO_CONTENT, fourTypeBean2, MultipleQuickEntity.SPAN_SIZE2));
        }

        return list;
    }

    public static List<String> getLinearData(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("美好的一天从coding开始+" + i);
        }
        return list;
    }
}

package com.xpf.recyclerview.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.FirstTypeBean;
import com.xpf.recyclerview.entity.FourTypeBean;
import com.xpf.recyclerview.entity.ItemClickEntity;
import com.xpf.recyclerview.entity.Level0Item;
import com.xpf.recyclerview.entity.Level1Item;
import com.xpf.recyclerview.entity.Movie;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.entity.MultipleQuickEntity;
import com.xpf.recyclerview.entity.MySection;
import com.xpf.recyclerview.entity.Person;
import com.xpf.recyclerview.entity.SecondTypeBean;
import com.xpf.recyclerview.entity.StatusEntity;
import com.xpf.recyclerview.entity.ThirdTypeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private static final String COVER_URL = "https://avatars1.githubusercontent.com/u/7455269?s=400&u=34912fd062e08efa008267702ae860a0c88b1aee&v=4";

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

    public static List<MySection> getMySectionData() {
        List<MySection> list = new ArrayList<>();
        list.add(new MySection(true, "Section 1", true));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(true, "Section 2", false));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(true, "Section 3", false));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(true, "Section 4", false));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(true, "Section 5", false));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        list.add(new MySection(new Movie(COVER_URL, NAME)));
        return list;
    }

    public static List<ItemClickEntity> getItemClickData() {
        List<ItemClickEntity> data = new ArrayList<>();
        data.add(new ItemClickEntity(ItemClickEntity.CLICK_ITEM_VIEW));
        data.add(new ItemClickEntity(ItemClickEntity.CLICK_ITEM_CHILD_VIEW));
        data.add(new ItemClickEntity(ItemClickEntity.LONG_CLICK_ITEM_VIEW));
        data.add(new ItemClickEntity(ItemClickEntity.LONG_CLICK_ITEM_CHILD_VIEW));
        data.add(new ItemClickEntity(ItemClickEntity.NEST_CLICK_ITEM_CHILD_VIEW));
        return data;
    }

    public static List<StatusEntity> getStatusEntityData(int length) {
        List<StatusEntity> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            StatusEntity status = new StatusEntity();
            status.setUserName("x-sir" + i);
            status.setCreatedAt("18/25/" + i);
            status.setResend(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7455269?s=400&u=34912fd062e08efa008267702ae860a0c88b1aee&v=4");
            status.setText("BaseRecyclerViewAdapterHelper https://www.x-sir.com");
            list.add(status);
        }
        return list;
    }

    public static ArrayList<MultiItemEntity> getExpandableData() {
        int lv0Count = 9;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i);
            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item("Level 1 item: " + j, "(no animation)");
                for (int k = 0; k < personCount; k++) {
                    lv1.addSubItem(new Person(nameList[k], random.nextInt(40)));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        res.add(new Level0Item("This is " + lv0Count + "th item in Level 0", "subtitle of " + lv0Count));

        return res;
    }
}

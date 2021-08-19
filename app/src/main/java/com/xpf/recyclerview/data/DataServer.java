package com.xpf.recyclerview.data;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.xpf.recyclerview.MyApplication;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.entity.DragItem;
import com.xpf.recyclerview.entity.Film;
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
import com.xpf.recyclerview.entity.SectionMultiItem;
import com.xpf.recyclerview.entity.StatusEntity;
import com.xpf.recyclerview.entity.ThirdTypeBean;
import com.xpf.recyclerview.entity.Video;

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

    public static List<BaseNode> getExpandableData() {
        int lv0Count = 9;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();

        List<BaseNode> res = new ArrayList<>();

        for (int i = 0; i < lv0Count; i++) {

            List<BaseNode> secondNodeList = new ArrayList<>();
            for (int j = 0; j < lv1Count; j++) {

                List<BaseNode> thirdNodeList = new ArrayList<>();
                for (int k = 0; k < personCount; k++) {
                    thirdNodeList.add(new Person(nameList[k], random.nextInt(40)));
                }

                Level1Item lv1 = new Level1Item(thirdNodeList, "Level 1 item: " + j, "(no animation)");
                secondNodeList.add(lv1);
            }

            Level0Item lv0 = new Level0Item(secondNodeList, "This is " + i + "th item in Level 0", "subtitle of " + i);
            res.add(lv0);
        }

        return res;
    }

    public static List<Film> getFilmData() {
        ArrayList<Film> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "x-sir";
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Film film = new Film(name, len, price, "He was one of Australia's most distinguished artistes");
            list.add(film);
        }
        return list;
    }

    public static List<SectionMultiItem> getSectionMultiData() {
        List<SectionMultiItem> list = new ArrayList<>();
        Video video = new Video(COVER_URL, NAME);

        // add section data
        list.add(new SectionMultiItem(SectionMultiItem.HEAD, "Section 1", true));
        // add multiple type item data ---start---
        list.add(new SectionMultiItem(SectionMultiItem.TEXT, new Video(COVER_URL, "video_id_0")));
        list.add(new SectionMultiItem(SectionMultiItem.TEXT, new Video(COVER_URL, "video_id_1")));
        list.add(new SectionMultiItem(SectionMultiItem.IMG_TEXT, new Video(COVER_URL, "video_id_2")));
        // ---end---

        list.add(new SectionMultiItem(SectionMultiItem.HEAD, "Section 2", false));
        list.add(new SectionMultiItem(SectionMultiItem.IMG_TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.IMG_TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.HEAD, "Section 3", false));
        list.add(new SectionMultiItem(SectionMultiItem.IMG_TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.HEAD, "Section 4", false));
        list.add(new SectionMultiItem(SectionMultiItem.TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.HEAD, "Section 5", false));
        list.add(new SectionMultiItem(SectionMultiItem.IMG_TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.IMG_TEXT, video));
        list.add(new SectionMultiItem(SectionMultiItem.IMG_TEXT, video));

        return list;
    }

    public static ArrayList<DragItem> getDragItemData() {
        ArrayList<DragItem> list = new ArrayList<>();
        String[] titles = MyApplication.getContext().getResources().getStringArray(R.array.title_array);
        for (int i = 0; i < titles.length; i++) {
            DragItem item = new DragItem();
            item.index = i + 1;
            item.title = titles[i];
            list.add(item);
        }
        return list;
    }
}

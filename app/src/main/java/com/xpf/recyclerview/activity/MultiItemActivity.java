package com.xpf.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.adapter.MultipleItemAdapter;
import com.xpf.recyclerview.entity.FirstTypeBean;
import com.xpf.recyclerview.entity.MultipleEntity;
import com.xpf.recyclerview.entity.SecondTypeBean;
import com.xpf.recyclerview.entity.ThirdTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpf on 2018/12/12 :)
 * Function:分类型数据练习
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class MultiItemActivity extends AppCompatActivity {

    private static final String NAME = "「IT大飞说」";
    private static final int IMG_ID = R.drawable.myqrcode;
    private static final String CONTENT = "魔都某非著名互联网创业公司码农，一个狂热的技术人！";

    private static final int SPAN_SIZE1 = 1;
    private static final int SPAN_SIZE3 = 3;
    private static final int SPAN_SIZE4 = 4;

    private List<MultipleEntity> mList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_item);
        initViews();
        initData();
        setAdapter();
    }

    private void setAdapter() {
        MultipleItemAdapter multipleItemAdapter = new MultipleItemAdapter(mList);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int spanSize = 0;
                switch (mList.get(position).getType()) {
                    case MultipleEntity.NAME:
                        spanSize = SPAN_SIZE1;
                        break;
                    case MultipleEntity.NAME_IMG:
                        spanSize = SPAN_SIZE3;
                        break;
                    case MultipleEntity.NAME_CONTENT:
                        spanSize = SPAN_SIZE4;
                        break;
                    default:
                        break;
                }

                return spanSize;
            }
        });

        mRecyclerView.setAdapter(multipleItemAdapter);
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
    }

    /**
     * 制造一些假数据，实际一般都是从网络获取
     */
    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            FirstTypeBean firstTypeBean = new FirstTypeBean(NAME);
            mList.add(new MultipleEntity<>(MultipleEntity.NAME, firstTypeBean));

            SecondTypeBean secondTypeBean = new SecondTypeBean(NAME, IMG_ID);
            mList.add(new MultipleEntity<>(MultipleEntity.NAME_IMG, secondTypeBean));

            ThirdTypeBean thirdTypeBean = new ThirdTypeBean(NAME, CONTENT);
            mList.add(new MultipleEntity<>(MultipleEntity.NAME_CONTENT, thirdTypeBean));
        }
    }
}

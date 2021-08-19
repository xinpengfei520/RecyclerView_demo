package com.xpf.recyclerview.adapter;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xpf.recyclerview.R;
import com.xpf.recyclerview.data.DataServer;
import com.xpf.recyclerview.entity.StatusEntity;
import com.xpf.recyclerview.utils.SpannableUtils;

/**
 * Created by xpf on 2018/12/25 :)
 * Function:NestAdapter
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class NestAdapter extends BaseQuickAdapter<StatusEntity, BaseViewHolder> {

    public NestAdapter() {
        super(R.layout.layout_nest_item, DataServer.getStatusEntityData(20));
        addChildClickViewIds(R.id.tweetText);
    }

    @Override
    protected void convert(BaseViewHolder helper, StatusEntity item) {
        helper.setImageResource(R.id.img, R.drawable.small_wawa);
        helper.setText(R.id.tweetName, "x-sir in Rio de beautiful!");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableUtils.getBuilder(msg).append("landscapes and span").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            Toast.makeText(getContext(), "事件触发了clickableSpan 的 onClick()", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(getContext().getResources().getColor(R.color.span_color));
            ds.setUnderlineText(true);
        }
    };
}

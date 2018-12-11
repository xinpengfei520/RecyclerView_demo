package com.xpf.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.xpf.recyclerview.MainActivity;
import com.xpf.recyclerview.R;

/**
 * Created by xpf on 2018/12/11 :)
 * Function:欢迎页面
 * {# @link https://github.com/xinpengfei520/RecyclerView_demo}
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}

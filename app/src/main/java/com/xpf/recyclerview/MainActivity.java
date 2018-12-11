package com.xpf.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_staggered;
    private Button btn_addHead;
    private Button btn_linearLayout;
    private Button btn_onAttach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_staggered = (Button) findViewById(R.id.btn_staggered);
        btn_addHead = (Button) findViewById(R.id.btn_addHead);
        btn_linearLayout = (Button) findViewById(R.id.btn_linearLayout);
        btn_onAttach = (Button) findViewById(R.id.btn_onAttach);

        btn_staggered.setOnClickListener(this);
        btn_addHead.setOnClickListener(this);
        btn_linearLayout.setOnClickListener(this);
        btn_onAttach.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_staggered:
                startActivity(new Intent(MainActivity.this, StaggeredGridLayoutActivity.class));
                break;
            case R.id.btn_addHead:
                startActivity(new Intent(MainActivity.this, AddHeadRecyclerViewActivity.class));
                break;
            case R.id.btn_linearLayout:
                startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class));
                break;
            case R.id.btn_onAttach:
                startActivity(new Intent(MainActivity.this, onViewAttachedToWindow.class));
                break;
        }
    }
}

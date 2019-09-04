package com.zxp.chat.ui;

import android.os.Bundle;

import com.zxp.chat.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_main;
    }
}

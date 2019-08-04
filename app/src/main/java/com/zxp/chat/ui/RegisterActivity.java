package com.zxp.chat.ui;

import android.os.Bundle;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.zxp.chat.R;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_register;
    }

    void register(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //TODO 完善UI
                    EMClient.getInstance().createAccount("", "");//同步方法
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

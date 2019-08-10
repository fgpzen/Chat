package com.zxp.chat.ui;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.zxp.chat.R;
import com.zxp.chat.widget.InputItemView;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.iv_close)
    ImageView iv_close;
    @BindView(R.id.input_name)
    InputItemView input_name;
    @BindView(R.id.input_phone)
    InputItemView input_phone;
    @BindView(R.id.input_pw)
    InputItemView input_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        input_pw.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        input_name.setIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

package com.zxp.chat.ui;

import android.os.Bundle;
import android.widget.Button;

import com.zxp.chat.R;

import butterknife.BindView;
import butterknife.OnClick;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.btn_login)
    Button btnLogin;

    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btn_login)
    void login(){
        startActivity(LoginActivity.class);
    }

    @OnClick(R.id.btn_register)
    void register(){
        startActivity(RegisterActivity.class);
    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_welcome;
    }
}

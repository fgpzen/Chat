package com.zxp.chat.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zxp.chat.R;
import com.zxp.chat.widget.ButtonView;
import com.zxp.chat.widget.InputItemView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements InputItemView.Callback {

    @BindView(R.id.iv_close)
    ImageView iv_close;
    @BindView(R.id.input_phone)
    InputItemView input_phone;
    @BindView(R.id.input_pw)
    InputItemView input_pw;
    @BindView(R.id.btn_login)
    ButtonView btn_login;
    private boolean phoneNoEmpty, pwNoEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (EaseMobHelper.getInstance().isLoggedIn()) {
            startActivity(MainActivity.class);
            return;
        }*/
    }

    @Override
    protected void initData() {
        //input_phone.setInputType(InputItemView.NUMBER);
        input_pw.setInputType(InputItemView.TEXT_PASSWORD);
        input_phone.setCallback(this);
        input_pw.setCallback(this);
    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.iv_close)
    void close(){
        finish();
    }

    @OnClick(R.id.btn_login)
    void login(){
        String phone = input_phone.getInputText();
        String pw = input_pw.getInputText();
        startActivity(MainActivity.class);
        /*EMClient.getInstance().login(phone,pw,new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.d("main", "登录聊天服务器成功！");
                //TODO 跳转到主页
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登录聊天服务器失败！");
            }
        });*/
    }


    @Override
    public void onChangeText(View view, String s) {
        switch (view.getId()){
            case R.id.input_phone:
                phoneNoEmpty = !s.isEmpty();
                break;
            case R.id.input_pw:
                pwNoEmpty = !s.isEmpty();
                break;
        }
        btn_login.setEnabled(phoneNoEmpty && pwNoEmpty);
    }
}

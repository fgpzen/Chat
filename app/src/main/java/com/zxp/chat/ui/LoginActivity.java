package com.zxp.chat.ui;

import android.os.Bundle;
import android.util.Log;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.zxp.chat.EaseMobHelper;
import com.zxp.chat.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (EaseMobHelper.getInstance().isLoggedIn()) {
            startActivity(MainActivity.class);
            return;
        }
    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_login;
    }

    void onLogin(){
        EMClient.getInstance().login("","",new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.d("main", "登录聊天服务器成功！");
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登录聊天服务器失败！");
            }
        });
    }


}

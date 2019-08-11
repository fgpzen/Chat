package com.zxp.chat.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.zxp.chat.R;
import com.zxp.chat.widget.AgreementItemView;
import com.zxp.chat.widget.ButtonView;
import com.zxp.chat.widget.InputItemView;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements InputItemView.Callback {

    @BindView(R.id.iv_close)
    ImageView iv_close;
    @BindView(R.id.input_name)
    InputItemView input_name;
    @BindView(R.id.input_phone)
    InputItemView input_phone;
    @BindView(R.id.input_pw)
    InputItemView input_pw;
    @BindView(R.id.agreement)
    AgreementItemView agreement;
    @BindView(R.id.btn_register)
    ButtonView btn_register;
    private boolean nameNoEmpty, pwNoEmpty, phoneNoEmpty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        input_phone.setInputType(InputItemView.NUMBER);
        input_pw.setInputType(InputItemView.TEXT_PASSWORD);
        input_name.setIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 选择图片
            }
        });
        input_name.setCallback(this);
        input_phone.setCallback(this);
        input_pw.setCallback(this);

    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_register;
    }

    @OnClick(R.id.iv_close)
    void close(){
        finish();
    }

    @OnClick(R.id.btn_register)
    void register(){
        String name = input_name.getInputText();
        String pw = input_pw.getInputText();
        boolean agree = agreement.isAgree();
        if(!agree){
            showShortToast("请同意许可协议");
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(name, pw);//同步方法
                    //TODO 返回到首页或者跳转到主页
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onChangeText(View view, String s) {
        switch (view.getId()){
            case R.id.input_name:
                nameNoEmpty = !s.isEmpty();
                break;
            case R.id.input_phone:
                phoneNoEmpty = !s.isEmpty();
                break;
            case R.id.input_pw:
                pwNoEmpty = !s.isEmpty();
                break;
        }
        btn_register.setEnabled(nameNoEmpty && phoneNoEmpty && pwNoEmpty);
    }
}

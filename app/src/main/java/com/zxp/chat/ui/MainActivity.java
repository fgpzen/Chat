package com.zxp.chat.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.zxp.chat.R;
import com.zxp.chat.ui.fragment.ChatFragment;
import com.zxp.chat.widget.ButtonItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_chat)
    ButtonItemView btn_chat;
    @BindView(R.id.btn_contacts)
    ButtonItemView btn_contacts;
    @BindView(R.id.btn_discover)
    ButtonItemView btn_discover;
    @BindView(R.id.btn_me)
    ButtonItemView btn_me;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    List<Fragment> fragments;
    List<ButtonItemView> buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int provideContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        btn_chat.setButtonDrawable(
                ContextCompat.getDrawable(this, R.drawable.message_normal),
                ContextCompat.getDrawable(this, R.drawable.message_press));
        btn_contacts.setButtonDrawable(
                ContextCompat.getDrawable(this, R.drawable.contacts_normal),
                ContextCompat.getDrawable(this, R.drawable.contacts_press));
        btn_discover.setButtonDrawable(
                ContextCompat.getDrawable(this, R.drawable.discovery_normal),
                ContextCompat.getDrawable(this, R.drawable.discovery_press));
        btn_me.setButtonDrawable(
                ContextCompat.getDrawable(this, R.drawable.me_normal),
                ContextCompat.getDrawable(this, R.drawable.message_press));
        btn_chat.setTextColor(
                ContextCompat.getColor(this, R.color.gray7),
                ContextCompat.getColor(this, R.color.green0));
        btn_contacts.setTextColor(
                ContextCompat.getColor(this, R.color.gray7),
                ContextCompat.getColor(this, R.color.green0));
        btn_discover.setTextColor(
                ContextCompat.getColor(this, R.color.gray7),
                ContextCompat.getColor(this, R.color.green0));
        btn_me.setTextColor(
                ContextCompat.getColor(this, R.color.gray7),
                ContextCompat.getColor(this, R.color.green0));
        initializeFragment();
    }

    @OnClick({R.id.btn_chat, R.id.btn_contacts, R.id.btn_discover, R.id.btn_me})
    public void onButtonClick(View view){
        int index = 0;
        switch (view.getId()){
            case R.id.btn_chat:
                index = 0;
                break;
            case R.id.btn_contacts:
                index = 1;
                break;
            case R.id.btn_discover:
                index = 2;
                break;
            case R.id.btn_me:
                index = 3;
                break;
        }
        selectButton(index);
        selectPage(index);
        Log.d("TAG","111 : "+index);
    }

    private void initializeFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ChatFragment());
        fragments.add(new ChatFragment());
        fragments.add(new ChatFragment());
        fragments.add(new ChatFragment());

        buttonList = new ArrayList<>();
        buttonList.add(btn_chat);
        buttonList.add(btn_contacts);
        buttonList.add(btn_discover);
        buttonList.add(btn_me);

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //滑动中
            }

            @Override
            public void onPageSelected(int position) {
                //selectButton(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_IDLE://静止状态
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING://滑动状态
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING://滑翔状态
                        break;
                }
            }
        });
    }

    private void selectButton(int index){
        for(int i=0; i<buttonList.size(); i++){
            if(i==index){
                buttonList.get(index).setSelected(true);
            }else{
                buttonList.get(index).setSelected(false);
            }
        }
    }

    private void selectPage(int index){
        viewPager.setCurrentItem(index);
    }
}

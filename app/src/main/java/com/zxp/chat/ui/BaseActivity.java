package com.zxp.chat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zxp.chat.bean.Event;
import com.zxp.chat.util.ActivityCollector;
import com.zxp.chat.util.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = getClass().getName();
    protected Unbinder mUnbinder;
    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentView());
        ButterKnife.bind(this);
        mContext = this;
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        if (isRegisterEventBus()) {
            EventBusUtil.unregister(this);
        }
        ActivityCollector.removeActivity(this);
        super.onDestroy();
    }

    protected void initData(){}

    /**
     *
     * @return 返回ContentView的id
     */
    protected abstract int provideContentView();

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(Event event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(Event event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(Event event) {
    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(Event event) {
    }

    /**
     * 显示ShortToast
     * @param content
     */
    public void showShortToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示LongToast
     * @param content
     */
    protected void showLongToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    protected void startActivity(Class clz) {
        Intent intent = new Intent(mContext, clz);
        startActivity(intent);
    }
}

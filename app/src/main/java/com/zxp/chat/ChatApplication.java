package com.zxp.chat;

import android.app.Application;
import android.content.Context;

public class ChatApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        //EaseMobHelper.getInstance().init(context);
    }

    public static Context getContext() {
        return context;
    }
}

package com.zxp.chat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxp.chat.R;

public class ListItemView extends LinearLayout {
    TextView tvText;
    ImageView ivIcon;

    public ListItemView(Context context) {
        super(context);
        init(context, null);
    }

    public ListItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.widget_list_item, this);
        tvText = findViewById(R.id.tv_text);
        ivIcon = findViewById(R.id.iv_icon);

    }

    public void setText(String s){
        tvText.setText(s);
    }

    public void setIcon(int resId){
        ivIcon.setImageResource(resId);
    }
}

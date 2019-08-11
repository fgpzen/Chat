package com.zxp.chat.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.zxp.chat.widget.util.DrawableUtil;

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        GradientDrawable normalDrawable = new GradientDrawable();
        GradientDrawable pressDrawable = new GradientDrawable();
        pressDrawable.setColorFilter(Color.LTGRAY, PorterDuff.Mode.LIGHTEN);
        StateListDrawable pressedSelector = DrawableUtil.getPressedSelector(normalDrawable, pressDrawable);
        this.setBackground(pressedSelector);
    }

}

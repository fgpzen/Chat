package com.zxp.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.zxp.chat.R;
import com.zxp.chat.util.UnitConverter;
import com.zxp.chat.widget.util.DrawableUtil;

public class ButtonView extends AppCompatButton {

    public ButtonView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public ButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ButtonView);
        float radius = ta.getDimension(R.styleable.ButtonView_radius, 0);
        float lineWidth = ta.getDimension(R.styleable.ButtonView_lineWidth, 0);
        int lineColor = ta.getColor(R.styleable.ButtonView_lineColor, Color.WHITE);
        int nomalColor = ta.getColor(R.styleable.ButtonView_fillColorNormal, Color.BLACK);
        int pressColor = ta.getColor(R.styleable.ButtonView_fillColorPress, -1);
        boolean isOpenEnable = ta.getBoolean(R.styleable.ButtonView_isOpenEnable, false);
        int enableColor = ta.getColor(R.styleable.ButtonView_fillColorEnable, -1);
        ta.recycle();

        int radius_px = UnitConverter.dipToPx(context, radius);
        int lineWidth_px = UnitConverter.dipToPx(context, lineWidth);
        GradientDrawable normal = DrawableUtil.getDrawable(radius_px, nomalColor, lineWidth_px, lineColor);
        GradientDrawable press;
        if(pressColor>=0){
            press = DrawableUtil.getDrawable(radius_px, pressColor, lineWidth_px, lineColor);
        } else {
            press = DrawableUtil.getDrawable(radius_px, nomalColor, lineWidth_px, lineColor);
            press.setColorFilter(Color.LTGRAY, PorterDuff.Mode.DARKEN);
        }
        StateListDrawable pressedSelector = DrawableUtil.getPressedSelector(normal, press);
        this.setBackground(pressedSelector);
        if(isOpenEnable){
            GradientDrawable enable;
            if(enableColor>=0){
                enable = DrawableUtil.getDrawable(radius_px, enableColor, lineWidth_px, lineColor);
            } else {
                enable = DrawableUtil.getDrawable(radius_px, nomalColor, lineWidth_px, lineColor);
                enable.setColorFilter(Color.LTGRAY, PorterDuff.Mode.LIGHTEN);
            }
            StateListDrawable selector = DrawableUtil.getSelector(normal, enable, press);
            this.setBackground(selector);
        }
    }

}

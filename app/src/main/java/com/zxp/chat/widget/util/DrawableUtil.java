package com.zxp.chat.widget.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

public class DrawableUtil {
    /**
     * 创建Selector
     * @param normalDraw
     * @param pressedDraw
     * @return
     */
    public static StateListDrawable getSelector(Drawable normalDraw, Drawable pressedDraw) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        //先执行ture,在执行false; -state_selected表示false
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDraw);
        stateListDrawable.addState(new int[]{}, normalDraw);
        return stateListDrawable;
    }

    /**
     * 动态设置Shape
     * @param radius 圆角半径
     * @param fillColor 填充颜色
     * @param width 线宽度
     * @param strokeColor 边框颜色
     * @return
     */
    public static GradientDrawable getDrawable(int radius, int fillColor, int width, int strokeColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(radius);
        // gradientDrawable.setCornerRadii();  设置单个角度
        gradientDrawable.setColor(fillColor);
        if(width<=0||strokeColor<0){
            gradientDrawable.setStroke(width, strokeColor);
        }
        return gradientDrawable;
    }
}

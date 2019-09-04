package com.zxp.chat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxp.chat.R;

public class ButtonItemView extends RelativeLayout {
    Button button;
    TextView tvHint;

    public ButtonItemView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public ButtonItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ButtonItemView);
        String lable = ta.getString(R.styleable.ButtonItemView_lable);
        Drawable iconDraw = ta.getDrawable(R.styleable.ButtonItemView_iconSrc);
        ta.recycle();

        LayoutInflater.from(context).inflate(R.layout.widget_button_item, this);
        button = findViewById(R.id.button);
        tvHint = findViewById(R.id.tv_hint);
        button.setText(lable);
        //button.setCompoundDrawablesWithIntrinsicBounds(null, iconDraw, null, null);
    }

    public void setButtonDrawable(Drawable normalDraw, Drawable pressedDraw){
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R. attr.state_pressed}, pressedDraw);
        stateListDrawable.addState(new int[]{}, normalDraw);
        button.setCompoundDrawablesWithIntrinsicBounds(null, stateListDrawable, null, null);
    }

    public void setTextColor(int normalColor, int pressedColor){
        int[][] states = new int[][]{{android.R.attr.state_pressed}, {}};
        int[] colors = new int[]{normalColor, pressedColor};
        ColorStateList colorStateList = new ColorStateList(states, colors);
        button.setTextColor(colorStateList);
    }

    public void setText(String s){
        button.setText(s);
    }

    public static final int DOT = 1;
    public static final int OBROUND = 2;
    public void setHintType(int type){
        switch (type){
            case DOT:
                tvHint.setBackground(getResources().getDrawable(R.drawable.shape_circle));
                tvHint.setText("···");
                break;
            case OBROUND:
                tvHint.setBackground(getResources().getDrawable(R.drawable.shape_roundrect));
                tvHint.setText("");
                break;
        }
    }

    public void setHintText(String s){
        tvHint.setText(s);
    }

    public void setHintVisibility(int visibility){
        tvHint.setVisibility(visibility);
    }
}

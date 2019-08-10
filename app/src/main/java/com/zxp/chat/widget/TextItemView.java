package com.zxp.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxp.chat.R;

public class TextItemView extends LinearLayout {
    TextView tvLable;
    TextView tvText;

    public TextItemView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public TextItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextItemView);
        String lable = ta.getString(R.styleable.TextItemView_tvLable);
        ta.recycle();

        LayoutInflater.from(context).inflate(R.layout.widget_tv_item, this);
        tvLable = findViewById(R.id.tv_lable);
        tvLable.setText(lable);
        tvText = findViewById(R.id.tv_text);
    }

    public void setTvText(String s){
        tvText.setText(s);
    }

    public String getTvText(){
        return tvText.getText().toString();
    }

    public void setTextClickListener(OnClickListener listener){
        tvText.setOnClickListener(listener);
    }
}

package com.zxp.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxp.chat.R;

public class AgreementItemView extends LinearLayout {
    CheckBox cbAgree;
    TextView tvText;

    public AgreementItemView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public AgreementItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AgreementItemView);
        String agreeText = ta.getString(R.styleable.AgreementItemView_agreeText);
        String agreement = ta.getString(R.styleable.AgreementItemView_agreement);
        ta.recycle();

        LayoutInflater.from(context).inflate(R.layout.widget_agreement_item, this);
        cbAgree = findViewById(R.id.cb_agree);
        cbAgree.setText(agreeText);
        tvText = findViewById(R.id.tv_text);
        tvText.setText(agreement);
    }

    public boolean isAgree(){
        return cbAgree.isChecked();
    }

    public void setAgreed(boolean agree){
        cbAgree.setChecked(agree);
    }

    public void setTextClickListener(OnClickListener listener){
        tvText.setOnClickListener(listener);
    }
}

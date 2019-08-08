package com.zxp.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxp.chat.R;
import com.zxp.chat.ui.Constants;

public class InputItemView extends FrameLayout{
    TextView tvLable;
    EditText etText;
    ImageView ivIcon;
    View lineView;
    int lineOnColor = Constants.Colors.GREEN;
    int lineOffColor = Constants.Colors.GAINSBORN;

    public InputItemView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public InputItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.InputItemView);
        Boolean iconVisibility = ta.getBoolean(R.styleable.InputItemView_iconVisibility, false);
        //Drawable lineDraw = ta.getDrawable(R.styleable.InputItemView_inputItemBottomLineColor);
        String lable = ta.getString(R.styleable.InputItemView_lable);
        String hint = ta.getString(R.styleable.InputItemView_inputHint);
        ta.recycle();

        LayoutInflater.from(context).inflate(R.layout.widget_et_item, this);
        tvLable = findViewById(R.id.tv_lable);
        etText = findViewById(R.id.et_text);
        ivIcon = findViewById(R.id.iv_icon);
        lineView = findViewById(R.id.line);

        /*if(lineDraw != null){
            lineView.setBackground(lineDraw);
        }*/
        ivIcon.setVisibility(iconVisibility?View.VISIBLE:View.GONE);
        tvLable.setText(lable);
        etText.setHint(hint);
        etText.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        etText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                lineView.setBackgroundColor(b?lineOnColor:lineOffColor);
            }
        });

    }

    public void setInputHint(String s){
        etText.setHint(s);
    }

    public String getInputText(){
        return etText.getText().toString();
    }

    public void setIconImage(Bitmap bm){
        ivIcon.setImageBitmap(bm);
    }

    public void setInputType(int type){
        etText.setInputType(type);
    }
}

package com.zxp.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxp.chat.R;

public class InputItemView extends RelativeLayout {
    TextView tvLable;
    EditText etText;
    ImageView ivIcon;
    View lineView;
    int lineOnColor = Color.GREEN;
    int lineOffColor = Color.LTGRAY;
    InputTextWatcher inputTextWatcher;

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
        String lable = ta.getString(R.styleable.InputItemView_etLable);
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

    public void setIconClickListener(OnClickListener listener){
        ivIcon.setOnClickListener(listener);
    }

    public void addTextChangedListener(TextWatcher watcher){
        etText.addTextChangedListener(watcher);
    }

    public static final int TEXT_PASSWORD = EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_PASSWORD;
    public static final int TEXT_VISIBLE_PASSWORD = EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
    public static final int NUMBER = EditorInfo.TYPE_CLASS_NUMBER;
    public static final int TEXT = EditorInfo.TYPE_CLASS_TEXT | EditorInfo.TYPE_TEXT_VARIATION_NORMAL;
    public void setInputType(int type){
        etText.setInputType(type);
    }

    class InputTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(callback!=null){
                callback.onChangeText(InputItemView.this, s.toString());
            }
        }
    }

    private Callback callback;
    public void setCallback(Callback callback) {
        if(inputTextWatcher == null){
            inputTextWatcher = new InputTextWatcher();
            etText.addTextChangedListener(inputTextWatcher);
        }
        this.callback = callback;
    }

    public interface Callback{
        void onChangeText(View view, String s);
    }
}

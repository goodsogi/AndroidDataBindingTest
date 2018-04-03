package com.plusapps.androiddatabingtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by bagjeong-gyu on 2018. 4. 3..
 */

public class LoginModel extends BaseObservable {

    private boolean isEnabled = true;

    public final ObservableField<String> userInput =
            new ObservableField<>();


    @Bindable
    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled() {
        this.isEnabled = !isEnabled;
        //아래 코드를 사용해야 실시간으로 방영됨
        notifyPropertyChanged(com.plusapps.androiddatabingtest.BR.isEnabled);
    }

    public TextWatcher onTextChanged = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.d("LoginModel", "text: " + charSequence);

            userInput.set(charSequence.toString());

            isEnabled = charSequence.length() >0;
            notifyPropertyChanged(com.plusapps.androiddatabingtest.BR.isEnabled);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }

    };

    public void onFocusChanged(View v, boolean hasFocus) {
        if (!hasFocus) {
            Toast.makeText(v.getContext(), "Field blurred", Toast.LENGTH_SHORT).show();
        }
    }



}

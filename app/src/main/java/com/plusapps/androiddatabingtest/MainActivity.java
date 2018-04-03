package com.plusapps.androiddatabingtest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.plusapps.androiddatabingtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //onCreate에서 binding하는 것이 좋음
        //ActivityMainBinding 자동으로 생성되는 클래스인데 레이아웃 파일명의 단어들에 _를 제외하고 뒤에 Binding을 붙여 camel 표기법으로 표시
        //이름이 틀리면 생성되지 않음
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginModel loginModel = new LoginModel();
        //loginModel 객체를 생성하여 binding 클래스에 set해야 함
        //loginModel.setIsEnabled(false);
        binding.setLoginModel(loginModel);

        //findViewById대신 아래처럼 view 객체에 접근 가능
        //binding.userInputDisplay
    }
}

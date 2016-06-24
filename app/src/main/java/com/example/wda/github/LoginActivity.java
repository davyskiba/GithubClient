package com.example.wda.github;

import com.example.wda.github.databinding.LoginActivityBinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginActivityBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding=DataBindingUtil.setContentView(this, R.layout.login_activity);
        dataBinding.setPresenter(new LoginPresenter(this));
    }
}

package com.example.wda.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login_input)
    EditText loginEditText;

    @BindView(R.id.password_input)
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    public void loginButtonClicked(){
        Toast.makeText(this,loginEditText.getText()+" "+passwordEditText.getText(),Toast.LENGTH_LONG).show();
    }
}

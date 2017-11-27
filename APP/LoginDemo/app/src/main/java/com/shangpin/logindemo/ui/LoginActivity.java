package com.shangpin.logindemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.shangpin.logindemo.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    private TextView tvGoRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initView
        initView();

        //click
        initClick();
    }

    private void initClick() {
        tvGoRegist.setOnClickListener(this);
    }

    private void initView() {
        tvGoRegist = (TextView) findViewById(R.id.tv_go_regist);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_go_regist://注册入口
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                break;
        }
    }
}

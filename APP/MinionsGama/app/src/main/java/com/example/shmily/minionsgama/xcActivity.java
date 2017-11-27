package com.example.shmily.minionsgama;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class xcActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xc);
        initView();
        initClick();

    }
    public void initView(){
        btn=(Button) findViewById(R.id.btn_back);
    }
    public void initClick(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent();
                intent.setClass(xcActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}

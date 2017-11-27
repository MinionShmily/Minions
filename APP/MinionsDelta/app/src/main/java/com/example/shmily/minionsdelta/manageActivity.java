package com.example.shmily.minionsdelta;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class manageActivity extends AppCompatActivity {
    private ImageView back;
    private TextView black;
    private TextView black2;
    private int bckColor;
    private Button switch_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initClick();


    }
    private void initView(){
        bckColor=getResources().getColor(R.color.bckColor);
        back=(ImageView) findViewById(R.id.iv_back);
        black=(TextView) findViewById(R.id.black1);
        black.setBackgroundColor(bckColor);
        black=(TextView) findViewById(R.id.black2);
        black.setBackgroundColor(bckColor);
        switch_account=(Button) findViewById(R.id.switch_account);
    }
    private void initClick(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClass(manageActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
//        switch_account.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//
//
//                private boolean onKeyDown(int keyCode, KeyEvent event)
//                {
//                    if (keyCode == KeyEvent.KEYCODE_BACK )
//                    {
//                        // 创建退出对话框
//                        AlertDialog isExit = new AlertDialog.Builder(this).create();
//                        // 设置对话框标题
//                        isExit.setTitle("系统提示");
//                        // 设置对话框消息
//                        isExit.setMessage("确定要退出吗");
//                        // 添加选择按钮并注册监听
//                        isExit.setButton("确定", listener);
//                        isExit.setButton2("取消", listener);
//                        // 显示对话框
//                        isExit.show();
//
//                    }
//
//                    return false;
//
//                }
//                DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which){
//                            case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
//                                finish();
//                                break;
//                            case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
//                                break;
//                            default:
//                                break;
//
//                        }
//                    }
//                }
//
//
//            }
//        });




    }



}

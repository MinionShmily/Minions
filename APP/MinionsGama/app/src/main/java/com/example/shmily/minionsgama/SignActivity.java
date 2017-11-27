package com.example.shmily.minionsgama;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class SignActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView back;
    private Button sign;
    private EditText yzm;
    private EditText name;
    private EditText psw;
    private EditText confirm;
    private String s_users = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        initView();
        initClick();


    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        name = (EditText) findViewById(R.id.et_users);
        psw = (EditText) findViewById(R.id.et_password);
        confirm = (EditText) findViewById(R.id.et_password2);
        yzm=(EditText) findViewById(R.id.et_yzm);
        sign = (Button) findViewById(R.id.btn_sign);




    }

    private void initClick() {



        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SignActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(yzm.getText().toString().equals("123")){

                    if (name.getText().toString().equals("")){
                        Toast.makeText(SignActivity.this,"Empty name", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {


                        if (psw.getText().toString().toString().equals("")){
                            Toast.makeText(SignActivity.this,"Empty password", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            if (confirm.getText().toString().toString().equals(psw.getText().toString())){
                                Toast.makeText(SignActivity.this,"Successful", Toast.LENGTH_SHORT).show();
                                /**sp存储*/
                                SharedPreferences sharedPreferences = getSharedPreferences("Minions", Context.MODE_PRIVATE);//创建SharedPreferences对象
                                SharedPreferences.Editor editor = sharedPreferences.edit(); //需要获取SharedPreferences的编辑对象
                                editor.putString("username", name.getText().toString()); //向preferences写入数据：
                                editor.putString("Password", psw.getText().toString());
                                editor.commit();// 向preferences文件中提交数据：
                            }
                            else{
                                Toast.makeText(SignActivity.this,"Unconfirmed!!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    }
                }
                else {
                    Toast.makeText(SignActivity.this,"验证码错误!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign: {
                if (s_users == null)
                    Toast.makeText(this, "User Name is null", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Users", Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                break;


        }


    }
}
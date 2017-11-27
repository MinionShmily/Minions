package com.example.shmily.minionsgama;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
   private Button btn1;
    private Button btn2;
    private EditText et_name;
    private TextView tv_forget;
    private String tianchong1=null;
    private String tianchong2=null;
    private ImageView iv_telcent;
    private ImageView iv_weixin;
    private EditText et_password;
    private CheckBox rem;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        TextView et_users= (TextView) findViewById(R.id.tv_users);
        Drawable drawable1=getResources().getDrawable(R.drawable.users);
        drawable1.setBounds(0,0,70,70);
        et_users.setCompoundDrawables(drawable1,null,null,null);


        TextView et_password= (TextView) findViewById(R.id.tv_password);
        Drawable drawable2=getResources().getDrawable(R.drawable.password);
        drawable2.setBounds(0,0,70,70);
        et_password.setCompoundDrawables(drawable2,null,null,null);



        initView();
        initClick();
    }

    private void initView(){
        btn1=(Button) findViewById(R.id.login);
        btn2=(Button) findViewById(R.id.sign);
        et_name=(EditText) findViewById(R.id.et_users) ;
        et_password=(EditText) findViewById(R.id.et_password);
        rem=(CheckBox) findViewById(R.id.rem);
        tv_forget=(TextView) findViewById(R.id.forget);
        iv_telcent=(ImageView) findViewById(R.id.telcent);
        iv_weixin=(ImageView) findViewById(R.id.weixin);
    }

    private void initClick() {

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent=new Intent();

                    intent.setClass(MainActivity.this,SignActivity.class);
                    startActivity(intent);
                    finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (et_name.getText().toString().equals(tianchong1)){

                    if (et_password.getText().toString().equals(tianchong2)) {


                        Intent intent1 = new Intent();
                        intent1.setClass(MainActivity.this, xcActivity.class);
                        startActivity(intent1);
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Wrong Password!!Please Check",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"Empty name!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        iv_telcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Minions", Context.MODE_PRIVATE); //创建SharedPreferences对象
                String userName=sharedPreferences.getString("username","");//根据key获取对应的数据
                tianchong1=userName;
                String password=sharedPreferences.getString("Password","");
                tianchong2=password;
                et_name.setText(userName);//给TextView设置text的值
                et_password.setText(password);

            }
        });
        tv_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"忘记密码",Toast.LENGTH_SHORT).show();
            }
        });
        iv_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"weixin",Toast.LENGTH_SHORT).show();





            }
        });
        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}

package com.example.shmily.minionsbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_login;
    private Button btn_sign;

    public CharSequence s="Init";
  //  private EditText ev1=(EditText) findViewById(R.id.ev);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initClick();
    }

    public  void initView(){
         btn_login= (Button) findViewById(R.id.btn_login);
         btn_sign = (Button) findViewById(R.id.btn_sign);



    }

    public  void initClick(){
//        EditText ev=(EditText) findViewById(R.id.ev);
//        s=ev.getText().toString();

        btn_login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
            }
        });
//        btn_quit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Method1_quit",Toast.LENGTH_SHORT).show();
//            }
//        });
          btn_sign.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent1=new Intent();
                intent1.setClass(MainActivity.this,zhucheActivity.class);                      //切换界面
                startActivity(intent1);
            }
        });
    }

    //    public void initClick(){
//        btn_quit.setOnClickListener(listener);
//        btn_login.setOnClickListener(listener);
//    }

//    View.OnClickListener listener=new View.OnClickListener(){
//    public void onClick(View v){
//
//        switch (v.getId()){
//            case R.id.btn_login:
//                Toast.makeText(MainActivity.this,"Method2_Login",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.btn_quit:
//                Toast.makeText(MainActivity.this,"Method2_Quit",Toast.LENGTH_SHORT).show();
//
//                break;
//            default:
//                break;
//        }
//    }
//
//};



}

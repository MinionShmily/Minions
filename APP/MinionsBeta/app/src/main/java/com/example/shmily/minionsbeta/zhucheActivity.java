package com.example.shmily.minionsbeta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class zhucheActivity extends AppCompatActivity {
    Button btn_back2login ;
    Button btn_submit;
    EditText etContent;
    EditText users;
    EditText pass;
    EditText confirm;
    String content_users=null;
    String content_pass=null;
    String content_confirm=null;
    private SharedPreferences sp_users;
    private SharedPreferences sp_pass;
    private SharedPreferences sp_confirm;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuche);
        initView();
        initClick();

    }

    public void initView(){
        btn_back2login =(Button)findViewById(R.id.btn_back2login);
        btn_submit=(Button) findViewById(R.id.btn_submit);
        users=(EditText) findViewById(R.id.et_uesrs);
        pass=(EditText) findViewById(R.id.et_password);
        confirm=(EditText) findViewById(R.id.et_password);

    }


    public void initClick(){
        btn_back2login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent();
                intent1.setClass(zhucheActivity.this,MainActivity.class);
                startActivity(intent1);

            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content_users= users.getText().toString();
                content_confirm=confirm.getText().toString();
                content_pass=pass.getText().toString();




                sp_users=getSharedPreferences("Usr", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit_users = sp_users.edit();
                edit_users.putString("content", content_users);


                sp_pass=getSharedPreferences("Password",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit_pass=sp_pass.edit();
                edit_pass.putString("content",content_pass);


                boolean commit = edit_users.commit();
                if (commit) {
                    if (content_users!=null){
                        users.setText("");
                        Toast.makeText(zhucheActivity.this, content_users, Toast.LENGTH_SHORT).show();
                        if (content_pass!=null){
                            pass.setText("");
                            Toast.makeText(zhucheActivity.this, "password", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            pass.setText("");
                            Toast.makeText(zhucheActivity.this,"Password is null",Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        users.setText("");
                        Toast.makeText(zhucheActivity.this,"Usres Name is null",Toast.LENGTH_SHORT).show();
                    }

                    if (content_confirm.equals(content_pass)){
                        confirm.setText("");
                        Toast.makeText(zhucheActivity.this,"seem",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(zhucheActivity.this,"Not seem",Toast.LENGTH_SHORT).show();

                    }

                }
            }

        });

    }


}

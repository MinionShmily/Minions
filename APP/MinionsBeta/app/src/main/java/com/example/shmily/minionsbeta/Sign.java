package com.example.shmily.minionsbeta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.edit;

public class Sign extends AppCompatActivity {
    Button btn_back;
    Button btn_cunchu;
    Button btn_show;
    private SharedPreferences sp;
    EditText etContent;
    String content=null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        initView();
        initClick();

    }



    public void initView() {
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_cunchu = (Button) findViewById(R.id.btn_cunchu);
        etContent= (EditText) findViewById(R.id.ev_cunchu);
    }

    public void initClick() {

        btn_back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Sign.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_cunchu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                content = etContent.getText().toString();
                sp = getSharedPreferences("Usr_Init", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("content", content);
                boolean commit = edit.commit();
                    if (commit&&(content!=null)) {
                        etContent.setText("");
                        Toast.makeText(Sign.this, "Store Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Sign.this, "Store Fialed!!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        btn_show.setOnClickListener(new View.OnClickListener() {
            String content=etContent.getText().toString();
            public void onClick(View v) {
                if (sp != null) {
                    String content = sp.getString("content", "");
                    Toast.makeText(Sign.this, "Type in:" + content, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Sign.this, "Stroe Fialed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

package com.example.shmily.minionsdemo3;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.*;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private Button btn4;
     Button btn1,btn2,btn3;
    private static boolean exited = false;
    TextView tv_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
         btn3 =(Button ) findViewById(R.id.shoot);
        /*btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_01.setText("Puhahahage");
                Intent i = new Intent(MainActivity.this , page1.class);
                startActivity(i);
            }});
*/



       //tv_01=(TextView) findViewById(R.id.textView3);


        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText((getApplicationContext()),"Login",Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {


                public void onClick(View view) {


                    Toast.makeText((getApplicationContext()),"Quit",Toast.LENGTH_SHORT).show();
                }
            });
        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText((getApplicationContext()),"shoot",Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void midToast(String str, int showTime)
    {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.view_toast_custom,
                (ViewGroup) findViewById(R.id.lly_toast));
        ImageView img_logo = (ImageView) view.findViewById(R.id.img_logo);
        TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
        tv_msg.setText(str);
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
}
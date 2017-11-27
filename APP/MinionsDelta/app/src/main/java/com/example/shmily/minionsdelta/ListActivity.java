package com.example.shmily.minionsdelta;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Date> mData = null;
    private Context mContext;
    private DateAdapter mAdapter = null;
    private ListView list_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        mContext=ListActivity.this;
//        list_date=(ListView) findViewById(R.id.list_date);
//        mData.add(new Date("我是","Minions","event"));
//        mAdapter=new DateAdapter((LinkedList<Date>) mData,mContext);
//        list_date.setAdapter(mAdapter);





    }

}

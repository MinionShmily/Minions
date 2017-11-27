package com.example.shmily.minionsdelta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Shmily on 2017/11/25.
 */

public class DateAdapter extends BaseAdapter {
    private LinkedList<Date> mdata;
    private Context mContext;

    public DateAdapter(LinkedList<Date> mdata,Context mContext){
        this.mdata=mdata;
        this.mContext=mContext;
    }
    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(mContext).inflate(R.layout.activity_list,parent,false);
        TextView tv_title=(TextView) convertView.findViewById(R.id.tv_title);
        TextView tv_date=(TextView) convertView.findViewById(R.id.tv_title);
        TextView tv_event=(TextView) convertView.findViewById(R.id.tv_title);
        tv_title.setText(mdata.get(position).getdTitle());
        tv_date.setText(mdata.get(position).getdDate());
        tv_event.setText(mdata.get(position).getdEvent());

        return convertView;
    }
}

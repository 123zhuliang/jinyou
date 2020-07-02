package com.jinyou.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinyou.R;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends BaseAdapter {
    private List<Person> pdata = new ArrayList<Person>();
    private Context context;

    public PersonAdapter(List<Person> pdata, Context context) {
        this.pdata = pdata;
        this.context = context;
    }

    public List<Person> getPdata() {
        return pdata;
    }

    public void setPdata(List<Person> pdata) {
        this.pdata = pdata;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return pdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static  class ViewHolder{
        public ImageView myimg;
        public TextView myname;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            holder =new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listviewtop,parent,false);
            holder.myimg = convertView.findViewById(R.id.listviewtop_img);
            holder.myname = convertView.findViewById(R.id.listviewbuttom_name);
            convertView.setTag(holder);
        }else {
            holder =(ViewHolder) convertView.getTag();
        }
        holder.myimg.setImageResource(pdata.get(position).getImg());
        holder.myname.setText(pdata.get(position).getName());
        return convertView;
    }
}

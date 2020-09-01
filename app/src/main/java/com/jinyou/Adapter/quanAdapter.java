package com.jinyou.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinyou.R;
import com.jinyou.itemActivity;
import com.jinyou.mode.Cart;
import com.jinyou.mode.quan;

import java.util.ArrayList;
import java.util.List;

public class quanAdapter extends BaseAdapter  {
    private List<quan> pdata = new ArrayList<>();
    private Context context;

    public quanAdapter(List<quan> pdata, Context context) {
        this.pdata = pdata;
        this.context = context;
    }

    public List<quan> getPdata() {
        return pdata;
    }

    public void setPdata(List<quan> pdata) {
        this.pdata = pdata;
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
        public ImageView img;
        public TextView name;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            holder =new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.myquan,parent,false);
            holder.img = convertView.findViewById(R.id.quantouxiang);
            holder.name = convertView.findViewById(R.id.quanmingzi);
            convertView.setTag(holder);
        }else {
            holder =(ViewHolder) convertView.getTag();
        }
        holder.img.setImageResource(pdata.get(position).getImsa());
        holder.name.setText(pdata.get(position).getQuanname());
        return convertView;
    }
}

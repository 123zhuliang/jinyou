package com.jinyou.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinyou.R;
import com.jinyou.mode.Cart;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    private List<Cart> pdata = new ArrayList<>();
    private Context context;

    public FriendsAdapter(List<Cart> pdata, Context context) {
        this.pdata = pdata;
        this.context = context;
    }

    public List<Cart> getPdata() {
        return pdata;
    }

    public void setPdata(List<Cart> pdata) {
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
        public TextView myname;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView==null){
            holder =new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.frinends,parent,false);
            holder.myname = convertView.findViewById(R.id.friendsname);
            convertView.setTag(holder);
        }else {
            holder =(ViewHolder) convertView.getTag();
        }
        holder.myname.setText(pdata.get(position).getCartname());
        return convertView;
    }
}

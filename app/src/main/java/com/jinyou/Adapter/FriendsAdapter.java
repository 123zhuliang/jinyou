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
import com.jinyou.mode.Friends;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private List<Friends> pdata = new ArrayList<>();
    private Context context;

    public FriendsAdapter(List<Friends> pdata, Context context) {
        this.pdata = pdata;
        this.context = context;
    }

    /*public  void update(List<Friends> date){
        pdata = new ArrayList<>();
        pdata.clear();
        if (date!=null&&date.size()>0){
            pdata.addAll(date);
        }
        notifyDataSetChanged();

    }*/
    public List<Friends> getPdata() {
        return pdata;
    }

    public void setPdata(List<Friends> pdata) {
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
        holder.myname.setText(pdata.get(position).getName());
        return convertView;
    }
}

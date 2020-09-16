package com.jinyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jinyou.Adapter.FriendsAdapter;
import com.jinyou.Adapter.quanAdapter;
import com.jinyou.mode.Cart;
import com.jinyou.mode.quan;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class Fragment_2 extends Fragment {

    private ListView quan_listview;
    private quanAdapter quansAdapter;
    private List<quan> friendslist = new ArrayList<>();
    private String s;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view = inflater.inflate(R.layout.layout_2,container,false);
            initDate();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }



        quan_listview = view.findViewById(R.id.youquanlistview);





        return  view;
    }


    public  void initDate() {


        BmobQuery<quan> query = new BmobQuery<>();
        query.addWhereExists("quanname");

        query.findObjects(  new FindListener<quan>() {
            @Override
            public void done(List<quan> list, BmobException e) {
                if (e==null){
                    //Toast.makeText(getApplicationContext(),list.get(0).getCartname(),Toast.LENGTH_LONG).show();
                    for (int i =0; i<list.size(); i++){
                        quan quans = new quan();
                        quans.setImsa(R.drawable.group9);
                        quans.setQuanname(list.get(i).getQuanname());
                        friendslist.add(quans);
                        quansAdapter = new quanAdapter(friendslist,getContext());
                        //quansAdapter.update(friendslist);
                        quansAdapter.notifyDataSetChanged();
                        quan_listview.setAdapter(quansAdapter);
                    }
                }else{
                    Toast.makeText(getActivity(),"您还没有圈子",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button Newyouquan = getActivity().findViewById(R.id.newyouquan);
        Newyouquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),newyouquan.class);
                getActivity().startActivity(intent);
                //getActivity().finish();
            }
        });

        /*quan_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),"fdafsf",Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(view.getContext(),itemActivity.class);
                view.getContext().startActivity(intent);
            }
        });*/
    }

    //新建友圈

}

package com.jinyou;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jinyou.Adapter.Person;
import com.jinyou.Adapter.PersonAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_4 extends Fragment {
    private View view;
    private ListView mylistviewtop,mylistviewbottom;
    private PersonAdapter myadaptertop,myadapterbottom;
    private List<Person> bookstop = new ArrayList<Person>();
    private List<Person> booksbottom = new ArrayList<Person>();
    private String[] namestop={"王晓宇"};
    private  int[] imgstop = {R.mipmap.tx2};
    private String[] namesbottom={"我的关注","我的活动","历史记录","反馈"};
    private int[] imgsbottom = {R.mipmap.tx2,R.mipmap.tx2,R.mipmap.tx2,R.mipmap.tx2};
    private Button denglu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.layout_4,container,false);
        mylistviewtop = view.findViewById(R.id.list_top);
        initdatabookstop();
        myadaptertop = new PersonAdapter(bookstop,getContext());
        mylistviewtop.setAdapter(myadaptertop);
        mylistviewbottom = view.findViewById(R.id.list_bottom);

        mylistviewbottom = view.findViewById(R.id.list_bottom);
        initdatabooksbottom();
        myadapterbottom = new PersonAdapter(booksbottom,getContext());
        mylistviewbottom.setAdapter(myadapterbottom);
        denglu = view.findViewById(R.id.dneglu);
        return  view;
    }

    private  void initdatabookstop() {
        for (int i = 0; i < imgstop.length; i++) {
            Person person = new Person(imgstop[i], namestop[i]);
            bookstop.add(person);
        }
    }
    private  void initdatabooksbottom(){
        for (int i = 0; i < imgsbottom.length; i++) {
            Person person = new Person(imgsbottom[i], namesbottom[i]);
            booksbottom.add(person);
        }
    }

}

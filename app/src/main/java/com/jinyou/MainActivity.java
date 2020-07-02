package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jinyou.Adapter.Person;
import com.jinyou.Adapter.PersonAdapter;
import  com.jinyou.Adapter.myfragmentview;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private TextView tb_1,tb_2,tb_3,tb_4;
    private ViewPager myViewPager;
    private List<Fragment> fragmentList;//Fragment列表
    private myfragmentview myfragmentviewadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initTab();




    }

    //初始化控件
    public void initUI(){
        tb_1 = findViewById(R.id.map);
        tb_2 = findViewById(R.id.sousuo);
        tb_3 = findViewById(R.id.xinxi);
        tb_4 = findViewById(R.id.myziliao);
        myViewPager = findViewById(R.id.myviewppager);
        tb_1.setOnClickListener(this);
        tb_2.setOnClickListener(this);
        tb_3.setOnClickListener(this);
        tb_4.setOnClickListener(this);
    }

    private  void initTab(){
        //新建Fragment
        Fragment_1  fragment_1 = new Fragment_1();
        Fragment_2  fragment_2 = new Fragment_2();
        Fragment_3  fragment_3 = new Fragment_3();
        Fragment_4  fragment_4 = new Fragment_4();
        //新建列表
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment_1);
        fragmentList.add(fragment_2);
        fragmentList.add(fragment_3);
        fragmentList.add(fragment_4);

        //新建适配器
        myfragmentviewadapter = new myfragmentview(getSupportFragmentManager(),fragmentList);
        //设置适配器
        myViewPager.setAdapter(myfragmentviewadapter);
        //设置滑动监听
       myViewPager.addOnPageChangeListener(new MyPageChangListener());

        //显示第一个界面
        showFragment(0);

    }
    private  void showFragment(int num){
        myViewPager.setCurrentItem(num);
        if (num==0){
            tb_1.setBackgroundColor(Color.RED);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.WHITE);
        }else if (num==1){
            tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.RED);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.WHITE);
        }else if (num==2){
            tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.RED);
            tb_4.setBackgroundColor(Color.WHITE);
        }else if (num==3){
            tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.RED);
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.map){
            showFragment(0);
        }else if ((v.getId()==R.id.sousuo)){
            showFragment(1);
        }else if (v.getId()==R.id.xinxi){
            showFragment(2);
        }else if (v.getId()==R.id.myziliao){
            showFragment(3);
        }
    }

    public void denglu(View view) {
        Toast.makeText(this,"ok" ,Toast.LENGTH_LONG).show();
    }


    public class MyPageChangListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //页面选中是调用
        @Override
        public void onPageSelected(int position) {

            if (position==0){
                tb_1.setBackgroundColor(Color.RED);
                tb_2.setBackgroundColor(Color.WHITE);
                tb_3.setBackgroundColor(Color.WHITE);
                tb_4.setBackgroundColor(Color.WHITE);

            }else if(position==1){
                tb_1.setBackgroundColor(Color.WHITE);
                tb_2.setBackgroundColor(Color.RED);
                tb_3.setBackgroundColor(Color.WHITE);
                tb_4.setBackgroundColor(Color.WHITE);
            }else if(position==2){
                tb_1.setBackgroundColor(Color.WHITE);
                tb_2.setBackgroundColor(Color.WHITE);
                tb_3.setBackgroundColor(Color.RED);
                tb_4.setBackgroundColor(Color.WHITE);
            }else if (position==3){
                tb_1.setBackgroundColor(Color.WHITE);
                tb_2.setBackgroundColor(Color.WHITE);
                tb_3.setBackgroundColor(Color.WHITE);
                tb_4.setBackgroundColor(Color.RED);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }



}
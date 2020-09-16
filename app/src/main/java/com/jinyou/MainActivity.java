package com.jinyou;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import  com.jinyou.Adapter.myfragmentview;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public String name;
    public String gongsi;
    private static final int REUEST_ZHUCE_CODE=1;

    private TextView tb_1,tb_2,tb_3,tb_4;
    private ViewPager myViewPager;
    //private List<Fragment> fragmentList;//Fragment列表
    private myfragmentview myfragmentviewadapter;
    /*private Fragment_1  fragment_1;
    private Fragment_2  fragment_2;
    private Fragment_3  fragment_3;
    private Fragment_4  fragment_4;*/
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewPager = findViewById(R.id.myviewppager);
        myViewPager.setOffscreenPageLimit(4);


        initUI();
        //initTab();
        myfragmentviewadapter = new myfragmentview(getSupportFragmentManager());
        myfragmentviewadapter.notifyDataSetChanged();
        //设置适配器
        myViewPager.setAdapter(myfragmentviewadapter);

        //设置滑动监听
        myViewPager.addOnPageChangeListener(new MyPageChangListener());

        //显示第一个界面
        showFragment(0);



    }


    //初始化控件
    public void initUI(){
        tb_1 = findViewById(R.id.map);
        tb_2 = findViewById(R.id.sousuo);
        tb_3 = findViewById(R.id.xinxi);
        tb_4 = findViewById(R.id.myziliao);

        tb_1.setOnClickListener(this);
        tb_2.setOnClickListener(this);
        tb_3.setOnClickListener(this);
        tb_4.setOnClickListener(this);
    }

    /*private  void initTab(){
        //新建Fragment
        fragment_1 = new Fragment_1();
        fragment_2 = new Fragment_2();
        fragment_3 = new Fragment_3();
        fragment_4 = new Fragment_4();
        //新建列表
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment_1);
        fragmentList.add(fragment_2);
        fragmentList.add(fragment_3);
        fragmentList.add(fragment_4);

        //新建适配器
        //myfragmentviewadapter = new myfragmentview(getSupportFragmentManager(),fragmentList);




    }*/
    private  void showFragment(int num){
        myViewPager.setCurrentItem(num);
        if (num==PAGE_ONE){

            /*tb_1.setBackgroundColor(Color.RED);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.WHITE);*/
        }else if (num==PAGE_TWO){

            /*tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.RED);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.WHITE);*/
        }else if (num==PAGE_THREE){

            /*tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.RED);
            tb_4.setBackgroundColor(Color.WHITE);*/
        }else if (num==PAGE_FOUR){

            /*tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.RED);*/
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.map){
            showFragment(PAGE_ONE);
        }else if ((v.getId()==R.id.sousuo)){
            showFragment(PAGE_TWO);
        }else if (v.getId()==R.id.xinxi){
            showFragment(PAGE_THREE);
        }else if (v.getId()==R.id.myziliao){
            showFragment(PAGE_FOUR);
        }
    }


    //添加名片
    public void addCart(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Edit_CartActivity.class);
        this.startActivity(intent);
        finish();
        //MainActivity.this.startActivityForResult(intent,REUEST_ZHUCE_CODE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(intent==null){
            return;
        }
        switch (requestCode){
            case  REUEST_ZHUCE_CODE:

                break;

            default:

        }
    }


    public class MyPageChangListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //页面选中是调用
        @Override
        public void onPageSelected(int position) {

            if (position==0){

            /*tb_1.setBackgroundColor(Color.RED);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.WHITE);*/
            }else if (position==1){

            /*tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.RED);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.WHITE);*/
            }else if (position==2){

            /*tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.RED);
            tb_4.setBackgroundColor(Color.WHITE);*/
            }else if (position==3){

            /*tb_1.setBackgroundColor(Color.WHITE);
            tb_2.setBackgroundColor(Color.WHITE);
            tb_3.setBackgroundColor(Color.WHITE);
            tb_4.setBackgroundColor(Color.RED);*/
            }
           /* if (position==0){
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
            }*/
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }



}

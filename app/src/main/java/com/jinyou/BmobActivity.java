package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jinyou.dao.databaseUtil;
import com.jinyou.mode.Cart;


import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.a.a.This;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class BmobActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmob);
        databaseUtil database = new databaseUtil();
        database.database(this);
    }

    public void show(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
    public void insert(View view){
        Cart cart = new Cart();
        cart.setCartname("汤");
        cart.setMobile("13778452966");
        cart.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e==null){
                    show("插入成功");
                }
            }
        });
    }

    //注册时，判断手机号是否注册过
    public void findByMobile(String mobile){
        BmobQuery<Cart> query = new BmobQuery<>();
        query.addWhereEqualTo("mobile",mobile);
        query.findObjects(new FindListener<Cart>() {
            @Override
            public void done(List<Cart> list, BmobException e) {
                if(e==null){
                    show("用户已存在"+list.size());
                }else{
                    show("注册成功");

                }
            }
        });
    }
}

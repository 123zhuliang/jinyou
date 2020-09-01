package com.jinyou.dao;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.jinyou.loginActivity;
import com.jinyou.mode.Cart;
import com.jinyou.regActivity;

import java.util.Arrays;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.a.a.This;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class databaseUtil {
    public void database(Context context){
        Bmob.initialize(context,"c56cc0b5e86ad7fb3ccf6edc58192d03");
    }


    //注册检验
    public void findMobile(String phone,Context context,String password,String repassword){
        BmobQuery<Cart> query = new BmobQuery<>();
        query.addWhereContainedIn("mobile",Arrays.asList(new String[]{phone}));
        query.findObjects(new FindListener<Cart>() {
            @Override
            public void done(List<Cart> list, BmobException e) {
                if (e==null){
                    //找到了，用户存咋
                    Toast.makeText(context,list.get(0).getMobile().toString(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setClass(context,regActivity.class);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context,list.size(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //添加数据

}

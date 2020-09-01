package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jinyou.dao.databaseUtil;
import com.jinyou.mode.Cart;

import java.util.Arrays;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class regActivity extends AppCompatActivity {

    private EditText phone;
    private EditText password;
    private  EditText repassword;
    private Button button;
    private int tag=0;
    private databaseUtil dataDao;

    private int s=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        init();
        Bmob.initialize(this,"c56cc0b5e86ad7fb3ccf6edc58192d03");
    }



    //初始化控件
    public void init(){
        phone = findViewById(R.id.phone);
        password  = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        button = findViewById(R.id.bnt_reg_reg);
    }

    public void btn_reg_reg(View view) {
        String mobile = phone.getText().toString().trim();
        String passwd = password.getText().toString().trim();
        String repasswd = repassword.getText().toString().trim();
        if (mobile.equals("")){
            //Toast.makeText(getApplicationContext(),"请输入手机号",Toast.LENGTH_LONG).show();
            phone.requestFocus();
        }else{
            BmobQuery<Cart> query = new BmobQuery<>();
            query.addWhereExists("mobile");
            query.findObjects(new FindListener<Cart>() {
                @Override
                public void done(List<Cart> list, BmobException e) {
                    if (e==null){
                        for (int i = 0 ;i < list.size(); i++){
                            if (list.get(i).getMobile().equals(mobile)){
                                tag=1;
                            }
                        }
                        if (tag==1){//用户已存在
                            Toast.makeText(getApplicationContext(),"用户已存在",Toast.LENGTH_LONG).show();

                        }else {
                            if (passwd.equals(repasswd)){
                                //用户不存在，将数据添加到表中
                                Cart cart = new Cart();
                                cart.setMobile(mobile);
                                cart.setPassword(passwd);
                                cart.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        if (e==null){
                                            Toast.makeText(getApplicationContext(),"成功",Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent();
                                            intent.setClass(regActivity.this,loginActivity.class);
                                            regActivity.this.startActivity(intent);
                                            phone.setText("");
                                            password.setText("");
                                            repassword.setText("");
                                        }

                                    }
                                });

                            }else{
                                Toast.makeText(getApplicationContext(),"密码不一致",Toast.LENGTH_LONG).show();
                            }
                        }
                    }else{Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show(); }
                }
            });
        }


    }




}

package com.jinyou;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jinyou.mode.Cart;

import java.util.Arrays;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 登录界面
 */
public class loginActivity extends AppCompatActivity {

    private EditText myphone;
    private EditText mypassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        Bmob.initialize(this,"c56cc0b5e86ad7fb3ccf6edc58192d03");
    }
//初始化控件
    public void init(){
        myphone = findViewById(R.id.login_phone);
        mypassword = findViewById(R.id.login_password);
    }
    public void denglu(View view) {
        String phone = myphone.getText().toString();
        String password = mypassword.getText().toString();
        BmobQuery<Cart> query = new BmobQuery<>();
        query.addWhereEqualTo("mobile",phone);
        //query.addWhereExists("mobile");
        query.findObjects(new FindListener<Cart>() {
            @Override
            public void done(List<Cart> list, BmobException e) {
                if (e==null){

                        if (list.get(0).getMobile().equals(phone)){
                            //Toast.makeText(loginActivity.this,"找到",Toast.LENGTH_LONG).show();
                            if (list.get(0).getPassword().equals(password)){
                                //密码正确
                                //跳转到功能模块
                                Intent intent = new Intent();
                                intent.setClass(loginActivity.this,MainActivity.class);
                                loginActivity.this.startActivity(intent);
                                finish();

                            }else {
                                Toast.makeText(loginActivity.this,"密码错误",Toast.LENGTH_LONG).show();
                                mypassword.setText("");
                                mypassword.setHint("密码错误");
                            }
                        }else{
                            //没找到，跳转到注册界面，
                            Toast.makeText(loginActivity.this,"用户不存在",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent();
                            intent.setClass(loginActivity.this,regActivity.class);
                            loginActivity.this.startActivity(intent);
                            finish();
                        }


                }else{
                    //Toast.makeText(getApplicationContext(),"请输入手机号",Toast.LENGTH_LONG).show();
                    myphone.requestFocus();

                }

            }
        });
    }

    public void chuce(View view) {
        Intent intent = new Intent();
        intent.setClass(this,regActivity.class);
        this.startActivity(intent);
    }

    public void setpassword(View view) {
        Intent intent = new Intent();
        intent.setClass(this,setpasswordActivity.class);
        this.startActivity(intent);

    }
}

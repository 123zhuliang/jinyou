package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 登录or注册页面
 */
public class login_regActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);
    }

    public void btn_login(View view){
        Intent intent = new Intent();
        intent.setClass(this,loginActivity.class);
        this.startActivity(intent);
        finish();
    }

    public void btn_reg(View view){
        Intent intent = new Intent();
        intent.setClass(this,regActivity.class);
        this.startActivity(intent);
        finish();
    }
}

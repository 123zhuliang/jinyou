package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import cn.bmob.v3.Bmob;

/**
 * 启动页面
 */
public class startActivity extends AppCompatActivity  {
    private boolean isFirstUse;
    private Button btn_start;
    private static int SPLASH_DISPLAY_LENGHT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);//去掉标题
        setContentView(R.layout.activity_start);
        btn_start = findViewById(R.id.btn_start);
        Bmob.initialize(this,"c56cc0b5e86ad7fb3ccf6edc58192d03");
        //new Thread(this).start();
        /*new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(startActivity.this,login_regActivity.class);	//第二个参数即为执行完跳转后的Activity
                startActivity(intent);
                startActivity.this.finish();   //关闭splashActivity，将其回收，否则按返回键会返回此界面
            }
        }, SPLASH_DISPLAY_LENGHT);*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Boolean isFirst = SharePreUtil.getBoolean(getApplicationContext(), ConstantValue.ISFIRST, true);
                if(isFirst){
                    //进入包含了viewpager那个导航界面
                    Intent intent = new Intent(getApplicationContext(),login_regActivity.class);
                    startActivity(intent);
                    //将isFirst改为false,并且在本地持久化
                    SharePreUtil.saveBoolean(getApplicationContext(), ConstantValue.ISFIRST, false);
                    finish();
                }else{
                    //进入应用程序主界面
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, SPLASH_DISPLAY_LENGHT);

    }

    public void btn_start(View view) {
        Intent intent = new Intent(getApplicationContext(),login_regActivity.class);
        startActivity(intent);
        finish();
    }

   /* public void run() {
        try {

            Thread.sleep(SPLASH_DISPLAY_LENGHT);

            //SharedPreferences存储
            SharedPreferences preferences = getSharedPreferences("isFirstUse", MODE_PRIVATE);

            isFirstUse = preferences.getBoolean("isFirstUse", true);


            if (isFirstUse) {
                startActivity(new Intent(this, login_regActivity.class));
            } else {
                startActivity(new Intent(this, MainActivity.class));
            }
            finish();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstUse", false);
            editor.commit();
        } catch (InterruptedException e) {

        }

    }*/


}
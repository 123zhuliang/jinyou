package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jinyou.mode.quan;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class newyouquan extends AppCompatActivity {

    private EditText namequan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newyouquan);

    }




    public void youquanfanhui(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        this.startActivity(intent);
        finish();
    }

    public void youquanwancheng(View view) {

        quan quans = new quan();
        namequan = findViewById(R.id.quanname);
        if (namequan.getText().toString()==""){
            Toast.makeText(newyouquan.this,"信息不能为空",Toast.LENGTH_LONG).show();
        }else{
            quans.setQuanname(namequan.getText().toString());
            quans.setImsa(R.drawable.group9);
            quans.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e==null){

                        Intent intent = new Intent();
                        intent.setClass(newyouquan.this,myyouquan.class);
                        newyouquan.this.startActivity(intent);
                        finish();

                    }else Toast.makeText(getApplicationContext(),"e",Toast.LENGTH_SHORT).show();
                }



            });
        }


    }
}

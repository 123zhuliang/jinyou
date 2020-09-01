package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jinyou.mode.Cart;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Edit_CartActivity extends AppCompatActivity {

    private EditText name,gongsi,bumen,zhiwei,shouji,youjian,chuanzhen,wangzhi,dizhi,jiaohuan;
    public  Cart cart;
    public String sid;
    public Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cart);
        init();
    }
    public void fanhui(View view){
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        this.startActivity(intent);
        finish();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void save(View view){
        String cname = name.getText().toString().trim();
        String cgongsi = gongsi.getText().toString().trim();
        String cbumen = bumen.getText().toString().trim();
        String czhiwei = zhiwei.getText().toString().trim();
        String cshouji = shouji.getText().toString().trim();
        String cyoujian = youjian.getText().toString().trim();
        String cchuanzhen = chuanzhen.getText().toString().trim();
        String cwangzhi = wangzhi.getText().toString().trim();
        String cdizhi = dizhi.getText().toString().trim();

        cart = new Cart(cname,cgongsi,cbumen,czhiwei,cshouji,cyoujian,cchuanzhen,cwangzhi,cdizhi);
        cart.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                Intent intent = new Intent();
                intent.setClass(Edit_CartActivity.this,MainActivity.class);
                Edit_CartActivity.this.startActivity(intent);
                finish();
            }
        });
    }
    //初始化控件
    private void init(){
        name = findViewById(R.id.edt_name);
        gongsi = findViewById(R.id.edt_gongsi);
        bumen = findViewById(R.id.edt_bumen);
        zhiwei = findViewById(R.id.edt_zhiwei);
        shouji = findViewById(R.id.edt_shouji);
        youjian = findViewById(R.id.edt_zhiwei);
        chuanzhen = findViewById(R.id.edt_chuanzhen);
        wangzhi = findViewById(R.id.edt_wangzhi);
        dizhi = findViewById(R.id.edt_dizhi);

    }
}

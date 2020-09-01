package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * 启动页面
 */
public class startActivity extends AppCompatActivity {

    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btn_start = findViewById(R.id.btn_start);
    }

    public void btn_start(View view) {
        Intent intent = new Intent();
        intent.setClass(this, login_regActivity.class);
        this.startActivity(intent);
        finish();

    }
}
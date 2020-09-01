package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class setActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
    }

    public void fanhuilog_reg(View view) {
        Intent intent = new Intent();
        intent.setClass(this,login_regActivity.class);
        this.startActivity(intent);
        finish();
    }
}

package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditInfo_ctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info_ctivity);
    }

    public void infofanhui(View view) {
        Intent intent = new Intent();
        intent.setClass(this,Fragment_4.class);
        this.startActivity(intent);
    }

    public void infowanchen(View view){
        Intent intent = new Intent();
        intent.setClass(this,Fragment_4.class);
        this.startActivity(intent);
    }
}

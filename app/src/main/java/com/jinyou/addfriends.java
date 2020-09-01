package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addfriends extends AppCompatActivity {

    private EditText sousuoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfriends);
        sousuoText = findViewById(R.id.sousuofriends);
    }

    public void addfriend(View view) {
        Intent intent = new Intent();
        intent.putExtra("name",sousuoText.getText().toString());
        intent.setClass(this,myyouquan.class);
        setResult(0,intent);

        finish();

    }

    public void fan(View view) {
        Intent intent = new Intent();
        intent.setClass(this,myyouquan.class);
        startActivity(intent);
    }
}

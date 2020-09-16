package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jinyou.Adapter.Cart_ReAdapter;
import com.jinyou.Adapter.FriendsAdapter;
import com.jinyou.mode.Cart;
import com.jinyou.mode.Friends;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class addfriends extends AppCompatActivity {

    private EditText search;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfriends);
        search = findViewById(R.id.sousuofriends);
        search.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        search.setInputType(EditorInfo.TYPE_CLASS_TEXT);

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId==EditorInfo.IME_ACTION_SEND ||(event!=null&&event.getKeyCode()== KeyEvent.KEYCODE_ENTER)) {
//do something;
                    Log.d("sss", "onEditorAction: "+"jinlai");

                    s = search.getText().toString();
                    BmobQuery<Cart> query = new BmobQuery<>();
                    query.addWhereEqualTo("mobile",s);
                    query.findObjects(new FindListener<Cart>() {
                        @Override
                        public void done(List<Cart> list, BmobException e) {
                            if (e==null){
                                Friends friends = new Friends();
                                friends.setName(list.get(0).getCartname());
                                friends.save(new SaveListener<String>() {
                                    @Override
                                    public void done(String s, BmobException e) {
                                        Log.d("zxc", "done: "+e);
                                        if (e==null){
                                            Intent intent = new Intent();
                                            intent.setClass(addfriends.this,myyouquan.class);
                                            addfriends.this.startActivity(intent);
                                            finish();
                                        }else{
                                            Toast.makeText(addfriends.this,"添加失败",Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                            }else Toast.makeText(addfriends.this,"查无此人",Toast.LENGTH_SHORT).show();
                        }
                    });

                    //return true;
                }

                return false;
            }
        });

        //sousuoText = findViewById(R.id.sousuofriends);

    }

   /* public void addfriend(View view) {
        s = sousuoText.getText().toString();
        Log.d("zxc", "s= " + s);
        BmobQuery<Cart> query = new BmobQuery<>();
        query.addWhereEqualTo("mobile",s);
        query.findObjects(new FindListener<Cart>() {
            @Override
            public void done(List<Cart> list, BmobException e) {
                if (e==null){
                    Friends friends = new Friends();
                    friends.setName(list.get(0).getCartname());
                    friends.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            Log.d("zxc", "done: "+e);
                            if (e==null){
                                Intent intent = new Intent();
                                intent.setClass(addfriends.this,myyouquan.class);
                                addfriends.this.startActivity(intent);
                            }else{
                                Toast.makeText(addfriends.this,"添加失败",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }else{
                    Toast.makeText(addfriends.this,"查无此人",Toast.LENGTH_SHORT).show();
                    sousuoText.setText("");
                }
            }
        });


    }*/

    public void fan(View view) {
        Intent intent = new Intent();
        intent.setClass(this,myyouquan.class);
        startActivity(intent);
        finish();
    }
}

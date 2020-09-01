package com.jinyou;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.jinyou.Adapter.FriendsAdapter;
import com.jinyou.mode.Cart;

import java.util.ArrayList;
import java.util.List;

public class myyouquan extends AppCompatActivity {
    private ListView friend_listview;
    private FriendsAdapter friendsAdapter;
    private List<Cart> friendslist = new ArrayList<>();
    private String s;
    String names[] = {"张三","李四","王五","赵六"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myyouquan);

        initDate();
        friend_listview = findViewById(R.id.friendsitem);

        friendsAdapter = new FriendsAdapter(friendslist,this);
        friend_listview.setAdapter(friendsAdapter);
    }

    public void initDate(){

        for (int i = 0; i<names.length; i++){
            Cart cart = new Cart();
            cart.setCartname(names[i]);
            friendslist.add(cart);
        }
    }

    public void myyouquanfanhui(View view) {
        Intent intent = new Intent(this,newyouquan.class);
        startActivity(intent);
    }

    public void myyouquanok(View view) {
        Intent intent = new Intent(this,addfriends.class);
        startActivity(intent);
    }
}

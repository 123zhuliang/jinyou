package com.jinyou;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jinyou.Adapter.FriendsAdapter;
import com.jinyou.mode.Friends;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class myyouquan extends AppCompatActivity {
    private ListView friend_listview;
    private FriendsAdapter friendsAdapter;
    private List<Friends> friendslist = new ArrayList<>();
    private String s;
    String names[] = {"张三","李四","王五","赵六"};

    private View view;
    private ViewGroup viewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myyouquan);

        friend_listview = findViewById(R.id.friendsitem);
        initDate();

    }




    public void initDate(){

        BmobQuery<Friends> query = new BmobQuery<>();
        query.addWhereExists("name");
        query.findObjects(new FindListener<Friends>() {
            @Override
            public void done(List<Friends> list, BmobException e) {
                if (e==null){
                    for (int i = 0; i<list.size(); i++){
                        Friends friends = new Friends();
                        friends.setName(list.get(i).getName());
                        friendslist.add(friends);

                        friendsAdapter = new FriendsAdapter(friendslist,myyouquan.this);
                        //Log.d("123", "getContext " + getContext());
                        //friendsAdapter.update(friendslist);
                        friend_listview.setAdapter(friendsAdapter);



                    }
                }else{
                    Toast.makeText(myyouquan.this,"您还没有好友",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void myyouquanfanhui(View view) {
        Intent intent = new Intent(this,newyouquan.class);
        startActivity(intent);
    }

    public void myyouquanok(View view) {
        Intent intent = new Intent(this,addfriends.class);
        startActivity(intent);
        finish();
    }
}

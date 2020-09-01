package com.jinyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jinyou.Adapter.Cart_ReAdapter;
import com.jinyou.mode.Cart;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class searchActivity extends AppCompatActivity {
    private RecyclerView recyclerViewsearch;
    //定义一个适配器
    private Cart_ReAdapter searchreAdapter;
    //定义搜索列表
    public List<Cart> searList = new ArrayList<>();
    private EditText searchedit;
    private Button search;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerViewsearch = findViewById(R.id.serchReview);
        Button search = findViewById(R.id.searchbutton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDate();

                //2.设置RecyclerView布局管理器
                recyclerViewsearch.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                //3.初始化适配器
                searchreAdapter = new Cart_ReAdapter(searList,getApplicationContext());
                //4.设置动画，采用默认动画效果
                recyclerViewsearch.setItemAnimator(new DefaultItemAnimator());
                //4.设置适配器

                recyclerViewsearch.setAdapter(searchreAdapter);
            }
        });
    }

    public void initDate(){
        searchedit = findViewById(R.id.searchedit);
        s = searchedit.getText().toString();
        BmobQuery<Cart> query = new BmobQuery<>();
        query.addWhereEqualTo("mobile",s);
        query.findObjects(new FindListener<Cart>() {
            @Override
            public void done(List<Cart> list, BmobException e) {
                if (e==null){
                    Cart cart = new Cart();
                    cart.setImg(R.drawable.businesscard1);
                    cart.setCartname(list.get(0).getCartname());
                    cart.setMobile(list.get(0).getMobile());
                    cart.setCompany(list.get(0).getCompany());
                    cart.setPosition(list.get(0).getPosition());
                    searList.add(cart);
                }
            }
        });


    }
}

package com.jinyou;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jinyou.Adapter.Cart_ReAdapter;
import com.jinyou.mode.Cart;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class Fragment_3 extends Fragment {

    private RecyclerView recyclerViewsearch;
    //定义一个适配器
    private Cart_ReAdapter searchreAdapter;
    //定义搜索列表
    public List<Cart> searList = new ArrayList<>();
    private EditText searchedit;
    private Button search;
    private String s;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view= inflater.inflate(R.layout.layout_3,container,false);

        }
        ViewGroup parent =(ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }

//1.初始化控件



        return  view;
    }
    /*public void initDate(){
        searchedit = getActivity().findViewById(R.id.searchedit);
        searchedit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        searchedit.setInputType(EditorInfo.TYPE_CLASS_TEXT);
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


    }*/
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        recyclerViewsearch = getActivity().findViewById(R.id.serchReviews);
        searchedit = getActivity().findViewById(R.id.searchedits);
        searchedit.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        searchedit.setInputType(EditorInfo.TYPE_CLASS_TEXT);

        searchedit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId==EditorInfo.IME_ACTION_SEND ||(event!=null&&event.getKeyCode()== KeyEvent.KEYCODE_ENTER)) {
//do something;
                    Log.d("sss", "onEditorAction: "+"jinlai");

                    s = searchedit.getText().toString();

                    //Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
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
                                //2.设置RecyclerView布局管理器
                                recyclerViewsearch.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                                //3.初始化适配器
                                searchreAdapter = new Cart_ReAdapter(searList,getActivity());
                                //4.设置动画，采用默认动画效果
                                recyclerViewsearch.setItemAnimator(new DefaultItemAnimator());
                                //4.设置适配器

                                recyclerViewsearch.setAdapter(searchreAdapter);


                            }
                        }
                    });

                    //return true;
                }

                return false;
            }
        });



    }

}

package com.jinyou;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jinyou.Adapter.Cart_ReAdapter;

import com.jinyou.Adapter.SpacesItemDecoration;
import com.jinyou.dao.deleteItem;
import com.jinyou.mode.Cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class Fragment_1 extends Fragment {

    //创建RecyclerView控件
    private RecyclerView  cart_Review;
    //定义一个适配器
    private Cart_ReAdapter cart_reAdapter;
    //定义名片列表
    public  List<Cart> cartList = new ArrayList<>();
    //定义头像
    private int[] imgs ={R.drawable.businesscard1,R.drawable.businesscard2,R.drawable.businesscard3};
    private String[] names = {"张三","李四","王五"};


    private deleteItem deleteitem = new deleteItem();
    //private int[] imgs;
    //private String[] names;
    private String id;
    private View view;
    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (view==null){
            view= inflater.inflate(R.layout.layout_1,container,false);
            initData();
        }
        ViewGroup parent =(ViewGroup) view.getParent();
        if (parent!=null){
            parent.removeView(view);
        }





        //1.初始化控件
        cart_Review = view.findViewById(R.id.cart_review);

        return  view;
    }

    //初始化数据
    private void initData(){


        Log.d("fff", "initData: ");
        BmobQuery<Cart> query = new BmobQuery<>();

        query.addWhereExists("mobile");
        query.findObjects(new FindListener<Cart>() {
            @Override
            public void done(List<Cart> list, BmobException e) {
                if (e==null){
                    for (int i =0; i<list.size(); i++){
                        Cart cart = new Cart();
                        cart.setImg(imgs[i%3]);
                        cart.setCartname(list.get(i).getCartname());
                        cart.setCompany(list.get(i).getCompany());
                        cart.setMobile(list.get(i).getMobile());
                        cart.setPosition(list.get(i).getPosition());
                        cartList.add(cart);
                        //2.设置RecyclerView布局管理器
                        cart_Review.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                        //3.初始化适配器
                        cart_reAdapter = new Cart_ReAdapter(cartList,getContext());
                        //4.设置动画，采用默认动画效果
                        cart_Review.setItemAnimator(new DefaultItemAnimator());
                        //4.设置适配器
                        //cart_reAdapter.replaceAll(cartList);
                        cart_Review.setAdapter(cart_reAdapter);

                        cart_reAdapter.setOnRecyItemClickList(new Cart_ReAdapter.OnRecyItemClickList() {
                            @Override
                            public void onClick(View view, int posion) {
                                Toast.makeText(getActivity(),"你点击了第"+(posion+1)+"个名片",Toast.LENGTH_SHORT).show();
                            }
                        });

                        cart_reAdapter.setOnRecyItemLongClickList(new Cart_ReAdapter.OnRecyItemLongClickList() {
                            @Override
                            public void onClick(View view, int posion) {
                                deleteitem.showdeleteItem(getContext(),posion,cart_reAdapter,cartList);
                                //cart_reAdapter.notifyDataSetChanged();
                                Toast.makeText(getActivity(),"你长按了fsgslkjflskjg",Toast.LENGTH_LONG).show();
                            }
                        });

                        Log.d("aaa", "done: "+list.size());
                    }
                }else {

                    //Toast.makeText(getActivity(),list.get(0).getMobile(),Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(),"无",Toast.LENGTH_LONG).show();
                }

            }
        });



    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        TextView sousuo = getActivity().findViewById(R.id.searchcard);
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(),searchActivity.class);
                    getActivity().startActivity(intent);
            }
        });

    }


}

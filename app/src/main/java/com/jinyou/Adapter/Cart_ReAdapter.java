package com.jinyou.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jinyou.R;
import com.jinyou.dao.showBottomDialog;
import com.jinyou.mode.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * 名片模块RecyclerView的自定义适配器
 */
public class Cart_ReAdapter extends RecyclerView.Adapter<Cart_ReAdapter.MyViewHolder> {
    private List<Cart> cdata = new ArrayList<>();
    private Context context;
    private showBottomDialog showBottomDialog = new showBottomDialog();
    private String s;

    //构造方法

    public Cart_ReAdapter(List<Cart> cdata, Context context) {
        this.cdata = cdata;
        this.context = context;
    }

    @NonNull
    @Override
    //返回一个自定义的ViewHolder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //填充布局获取列表项布局
        View itemView = LayoutInflater.from(context).inflate(R.layout.cartview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        myViewHolder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomDialog.BottomDialog(context);

            }
        });
        return myViewHolder;
    }

    @Override
    //填充onCreateView返回的控件
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //获取数据
        Cart cart = cdata.get(position);
        holder.myimg.setImageResource(cart.getImg());
        holder.gongsi.setText(cart.getCompany());
        holder.name.setText(cart.getCartname());
        //holder.phone.setText(cart.getMobile());
         s = cart.getMobile();





    }

    //返回名片数据个数
    @Override
    public int getItemCount() {
        return cdata.size();
    }


    //定义内部类ViewHoler
    class MyViewHolder extends RecyclerView.ViewHolder{
        //定义对应的列表项

        private ImageView myimg;
        private TextView gongsi;
        private TextView name;
        private ImageButton phone;
        private TextView posion;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //获取对应的列表项
            myimg = itemView.findViewById(R.id.imageView);
            gongsi = itemView.findViewById(R.id.gongsi);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
            posion = itemView.findViewById(R.id.posion);

        }
    }

}

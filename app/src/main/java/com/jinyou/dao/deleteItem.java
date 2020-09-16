package com.jinyou.dao;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.jinyou.Adapter.Cart_ReAdapter;
import com.jinyou.MainActivity;
import com.jinyou.R;
import com.jinyou.mode.Cart;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class deleteItem {
    private View view;

    Cart_ReAdapter reAdapter;
    public  void showdeleteItem(Context context, int i, Cart_ReAdapter reAdapter, List<Cart> list) {
            view = View.inflate(context, R.layout.deletedialog,null);
            final Dialog dialogs = new Dialog(context);
            dialogs.setContentView(view);
        Window window = dialogs.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialogs.show();
        dialogs.findViewById(R.id.delete_queding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = list.get(i).getMobile();
                Log.d("bbb", "list:"+s);
                BmobQuery<Cart> query = new BmobQuery<>();
                query.addWhereEqualTo("mobile",s);
                query.findObjects(new FindListener<Cart>() {
                    @Override
                    public void done(List<Cart> list, BmobException e) {
                        Log.d("asd", "list.get(0).getname: "+list.get(0).getCartname());
                        list.get(0).delete(new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if (e==null){

                                    Log.d("aaa", "done: 删除成功");
                                }else Log.d("bbb", "done: 删除失败");
                            }
                        });
                    }
                });
                list.remove(i);
                Log.d("sss", "onClick: "+i);
                reAdapter.notifyItemRemoved(i);
                reAdapter.notifyDataSetChanged();
                dialogs.dismiss();
            }
        });
        dialogs.findViewById(R.id.delete_quxiao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs.dismiss();
            }
        });
    }
}

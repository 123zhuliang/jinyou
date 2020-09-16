package com.jinyou.dao;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.jinyou.R;
import com.jinyou.mode.Cart;

import java.util.List;

public class showBottomDialog {
    private View view;
    private TextView phonetake;
    public void SendSMSTo(String phoneNumber,String message,Context context){
        //判断输入的phoneNumber是否为合法电话号码
        if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){
            //Uri.parse("smsto") 这里是转换为指定Uri,固定写法
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phoneNumber));
            intent.putExtra("sms_body", message);
            context.startActivity(intent);
        }
    }
    public void BottomDialog(Context context, String s) {


        //1、使用Dialog、设置style
        final Dialog dialog = new Dialog(context, R.style.DialogTheme);
        //2、设置布局
        view = View.inflate(context, R.layout.dialog, null);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        dialog.findViewById(R.id.tv_take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendSMSTo(s,"",context);
                dialog.dismiss();
            }
        });

        phonetake = dialog.findViewById(R.id.tv_take_pic);
        phonetake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri=Uri.parse("tel:"+s);
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                context.startActivity(intent);
                Log.d("qw", "onClick: "+phonetake.getText());

            }
        });
        phonetake.setText(s);
        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}

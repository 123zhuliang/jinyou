package com.jinyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_4 extends Fragment {
    private View view;
   private ImageButton write;
   private ImageButton addcart;
   private ImageButton shezhi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_4,container,false);

        return  view;
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

       write = getActivity().findViewById(R.id.writeziliao);
       write.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),EditInfo_ctivity.class);
                getActivity().startActivity(intent);
           }
       });

       addcart = getActivity().findViewById(R.id.addcart);
       addcart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.setClass(getActivity(),Edit_CartActivity.class);
               getActivity().startActivity(intent);
           }
       });

       shezhi = getActivity().findViewById(R.id.shezhi);
       shezhi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent();
               intent.setClass(getActivity(),setActivity.class);
               getActivity().startActivity(intent);
           }
       });
    }


}

package com.jinyou.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jinyou.Fragment_1;
import com.jinyou.Fragment_2;
import com.jinyou.Fragment_3;
import com.jinyou.Fragment_4;
import com.jinyou.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class myfragmentview extends FragmentPagerAdapter {
    //private List<Fragment> fragmentList;

    private Fragment_1 fragment_1 = null;
    private Fragment_2 fragment_2 = null;
    private Fragment_3 fragment_3 = null;
    private Fragment_4 fragment_4 = null;
    /*public myfragmentview(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }*/

    public myfragmentview(@NonNull FragmentManager fm) {
        super(fm);
        fragment_1 = new Fragment_1();
        fragment_2 = new Fragment_2();
        fragment_3 = new Fragment_3();
        fragment_4 = new Fragment_4();

    }



    @NonNull


    @Override
    //显示哪个界面
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = fragment_1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = fragment_2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = fragment_3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = fragment_4;
                break;
        }
        return  fragment;
        //return fragmentList.get(position);
    }

    //获得界面个数
    @Override
    public int getCount() {
        //return fragmentList.size();
        return 4;
    }
    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

}

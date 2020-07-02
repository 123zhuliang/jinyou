package com.jinyou.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class myfragmentview extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    public myfragmentview(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public myfragmentview(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    //显示哪个界面
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    //获得界面个数
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

package com.example.matheus.maiaplayground;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

/**
 * Created by Matheus on 16/06/2016.
 */
public class MyTabListener implements ActionBar.TabListener {
    private ViewPager viewPager;
    private int id;
    public MyTabListener(ViewPager viewPager, int idx){
        this.id = idx;
        this.viewPager = viewPager;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(id);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

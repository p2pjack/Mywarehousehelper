package com.uk.umf_solutions.warehousehelper.common;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.uk.umf_solutions.warehousehelper.ui.mainUI.MainFragment_UI;
import com.uk.umf_solutions.warehousehelper.ui.whereMyStockFunction.WhereMyStockFragment_UI;

/**
 * Created by Eaun-Ballinger on 25/02/2017.
 *
 *
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int MAX_PAGES = 2;
    private Context mContext;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;
        switch (position) {
            case 0:
                selectedFragment = new MainFragment_UI();
                break;
            case 1:
                selectedFragment = new WhereMyStockFragment_UI();
                break;
            default:
                selectedFragment = new MainFragment_UI();
                break;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return MAX_PAGES;
    }
}

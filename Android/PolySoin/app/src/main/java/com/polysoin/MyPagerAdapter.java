package com.polysoin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.polysoin.enums.TabEnum;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private TabFragment1 tabFragment1;
    private TabFragment1 tabFragment2;
    private TabHistoryFragment tabFragment3;

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                tabFragment1 = new TabFragment1();
                return tabFragment1;
            case 1:
                tabFragment2 = new TabFragment1();
                return tabFragment2;
            case 2:
                tabFragment3 = new TabHistoryFragment();
                return tabFragment3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return TabEnum.Today + "";
            case 1:
                return TabEnum.All + "";
            case 2:
                return TabEnum.History + "";
            default:
                return null;
        }
    }

    public void addUpdate() {
        if (tabFragment1 != null) {
            tabFragment1.update();
        }
        if (tabFragment2 != null) {
            tabFragment2.update();
        }
    }

    public void removeUpdate() {
        if (tabFragment1 != null) {
            tabFragment1.update();
        }
        if (tabFragment2 != null) {
            tabFragment2.update();
        }
        if (tabFragment3 != null) {
            tabFragment3.update();
        }
    }
}

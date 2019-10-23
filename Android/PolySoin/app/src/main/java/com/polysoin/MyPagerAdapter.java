package com.polysoin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.polysoin.TabFragment.TabFragment1;
import com.polysoin.TabFragment.TabHistoryFragment;
import com.polysoin.dummy.DummyItem;
import com.polysoin.dummy.MedicineDummyContent;
import com.polysoin.dummy.MedicineHistoryDummyContent;
import com.polysoin.enums.TabEnum;

public class MyPagerAdapter extends FragmentPagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment1();
            case 2:
                return new TabHistoryFragment();
        }
        return null;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
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

    public void removeAt(DummyItem item) {
        MedicineHistoryDummyContent.addItem(item);
        MedicineDummyContent.ITEMS.remove(item);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}

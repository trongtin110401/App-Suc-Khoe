package com.example.doancoso.fragment.Homnay;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapTer extends FragmentStatePagerAdapter {
    public ViewPagerAdapTer(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentSang();
            case 1:
                return new FragmentTrua();
            case 2:
                return new FragmentChieu();
            case 3:
                return new FragmentToi();
            default:
                return new FragmentSang();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String tittle = "";
        switch (position) {
            case 0:
                tittle = "Sáng";
                break;
            case 1:
                tittle = "trưa";
                break;
            case 2:
                tittle = "chiều";
                break;
            case 3:
                tittle = "bữa ăn nhẹ";
                break;
        }
        return tittle;
    }
}

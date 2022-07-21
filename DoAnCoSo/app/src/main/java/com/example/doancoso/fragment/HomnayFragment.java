package com.example.doancoso.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.doancoso.R;
import com.example.doancoso.fragment.Homnay.ViewPagerAdapTer;
import com.google.android.material.tabs.TabLayout;

public class HomnayFragment extends Fragment {
    @Nullable
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmenthomnay,container,false);
        tabLayout= view.findViewById(R.id.tablayout);
        viewPager = view.findViewById(R.id.viewpager);
        ViewPagerAdapTer viewPagerAdapTer = new ViewPagerAdapTer(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapTer);
        tabLayout.setupWithViewPager(viewPager);
        return view;

    }

}

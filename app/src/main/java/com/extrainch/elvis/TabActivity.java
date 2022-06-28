package com.extrainch.elvis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.extrainch.elvis.Adapter.TabAdapter;
import com.extrainch.elvis.Fragments.CallFragment;
import com.extrainch.elvis.Fragments.ChatFragment;
import com.extrainch.elvis.Fragments.StatusFragment;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabAdapter.addFragment(new ChatFragment(), "Chats");
        tabAdapter.addFragment(new StatusFragment(), "Status");
        tabAdapter.addFragment(new CallFragment(), "Calls");
        viewPager.setAdapter(tabAdapter);
    }
}
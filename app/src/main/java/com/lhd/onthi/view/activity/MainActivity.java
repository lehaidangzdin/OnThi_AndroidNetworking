package com.lhd.onthi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.tabs.TabLayoutMediator;
import com.lhd.onthi.R;
import com.lhd.onthi.adapter.TabAdapter;
import com.lhd.onthi.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // TODO: 8/14/2022 databinding: thêm phần sau vào buile.gradle(project) trước rồi thêm tag <layout></layout> bọc file xml thì mới dùng đc databinding
    //******************
    //  dataBinding {
    //        enabled = true
    //    }
    //******************

    // TODO: 8/14/2022 thêm thư viện retrofit
    //  implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    //  implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    private ActivityMainBinding binding;
    private TabAdapter tabAdapter;
    private final List<String> ltTitle = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        tabAdapter = new TabAdapter(getSupportFragmentManager(), getLifecycle());
        binding.viewpager.setAdapter(tabAdapter);
        addTitleTabLayout();

        new TabLayoutMediator(binding.tabLayout, binding.viewpager, (tab, position) -> {
            tab.setText(ltTitle.get(position));
        }).attach();
    }

    private void addTitleTabLayout() {
        ltTitle.add("Fragment 1");
        ltTitle.add("Fragment 2");
    }


}
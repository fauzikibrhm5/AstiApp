package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroScreen extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPageAdaptor introViewPageAdaptor ;
    TabLayout tabIndicator;
    Button btnGetStarted;
    int position = 0;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make the activity on full screen

        setContentView(R.layout.activity_intro_screen);


        // ini views
        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);

        // list
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Hello!", "Selamat datang di aplikasi pertama saya.", R.drawable.emoticons));
        mList.add(new ScreenItem("Search People", "Mencari orang dengan mudah.", R.drawable.people));
        mList.add(new ScreenItem("Get Contact", "Dapatkan kontak orang yang dicari secara cepat.", R.drawable.phone));


        // setup
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPageAdaptor = new IntroViewPageAdaptor(this, mList);
        screenPager.setAdapter(introViewPageAdaptor);

        //setup table layout
        tabIndicator.setupWithViewPager(screenPager);

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() - 1) {
                    loadLastScreen();
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //get started listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open main activity

                Intent mainActivity = new Intent(getApplicationContext(), Menu.class);
                startActivity(mainActivity);
            }
        }); }

        //menampilkan tombol get started
                private void loadLastScreen() {
                    btnGetStarted.setVisibility(View.VISIBLE);
                    tabIndicator.setVisibility(View.INVISIBLE);
                    btnGetStarted.setAnimation(btnAnim);
                }


    }
/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.zzh.activity;

import com.support.android.designlibdemo.R;
import com.support.android.zzh.CheeseDetailActivity;
import com.support.android.zzh.activity.right.WeatherActivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * TODO
 */
public class MainActivity extends BaseActivity {

    /**
     * 侧边栏
     */
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton fab;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private ActionBar ab;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    boolean status = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerToggle = new ActionBarDrawerToggle(
//                MainActivity.this,
//                mDrawerLayout,
//                R.string.drawer_open,
//                R.string.drawer_close
//        ) {
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//            }
//        };
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status == false) {
                    mDrawerToggle.onDrawerOpened(navigationView);
                    status = true;
                } else if (status == true) {
                    mDrawerToggle.onDrawerClosed(navigationView);
                    status = false;
                }


            }
        });


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_one:
                Toast.makeText(MainActivity.this, "第一个 item", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mcontext, CheeseDetailActivity.class);
                intent.putExtra(CheeseDetailActivity.EXTRA_NAME, "test");
                mcontext.startActivity(intent);
                startActivity(new Intent(MainActivity.this, WeatherActivity.class));
                break;
            case R.id.action_two:
                Toast.makeText(MainActivity.this, "第2个 item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_three:
                Toast.makeText(MainActivity.this, "第3个 item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_four:
                Toast.makeText(MainActivity.this, "第4个 item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_five:
                Toast.makeText(MainActivity.this, "第5个 item", Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 添加头部 viewpage
     *
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new com.support.android.zzh.activity.home.HomeFragment(), "首页");
        adapter.addFragment(new com.support.android.zzh.activity.home.JokeFragment(), "笑话");
        adapter.addFragment(new com.support.android.zzh.activity.home.NewsFragment(), "段子");
        adapter.addFragment(new com.support.android.zzh.activity.home.VideoFragment(), "视频");
        viewPager.setAdapter(adapter);
    }

    /**
     * 打开 menu 菜单
     *
     * @param navigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            //首页
                            case R.id.nav_home:
                                Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                                break;
                            //消息
                            case R.id.nav_messages:
                                Toast.makeText(MainActivity.this, "消息", Toast.LENGTH_SHORT).show();
                                break;
                            //动态
                            case R.id.nav_friends:
                                Toast.makeText(MainActivity.this, "动态", Toast.LENGTH_SHORT).show();
                                break;
                            //其他
                            case R.id.nav_a:
                                Toast.makeText(MainActivity.this, "其他", Toast.LENGTH_SHORT).show();
                                break;
                            //设置
                            case R.id.nav_discussion:
                                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return true;
                    }
                });
    }

    /**
     * 首页 Tab
     */
    class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}

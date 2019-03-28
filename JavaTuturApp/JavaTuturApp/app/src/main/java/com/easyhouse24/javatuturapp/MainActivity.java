package com.easyhouse24.javatuturapp;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mFrameLayout;

    private HomeFragment mHomeFragment;

    private QuestionFragment mQuestionFragment;

    private SettingFragment mSettingFragment;

    private BasicFragment mBasicFragment;

    private AdvancedFragment mAdvancedFragment;

    private CardView mCardView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameLayout = (FrameLayout) findViewById(R.id.frame);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.main_nav);


        //initializing fragments

        mHomeFragment = new HomeFragment();
        mSettingFragment = new SettingFragment();

        mQuestionFragment = new QuestionFragment();


        setFragment(mHomeFragment);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        mBottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(mHomeFragment);
                        return true;

                    case R.id.nav_questions:
                        mBottomNavigationView.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(mQuestionFragment);
                        return true;
                    case R.id.nav_settings:
                        mBottomNavigationView.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(mSettingFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });

        //Implementing onBackPressed in a Fragment and calling it from MainActivity
        FragmentManager fm = getSupportFragmentManager();
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(getFragmentManager().getBackStackEntryCount() == 0) {

                    mBottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                    setFragment(mHomeFragment);
                }
            }
        });


    }


    //Creating a method to call fragments in frame layout
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }

    public void cardViewBasic(View v) {
        mFrameLayout = (FrameLayout) findViewById(R.id.frame);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.main_nav);

        mBasicFragment = new BasicFragment();
        setFragment(mBasicFragment);
        mBottomNavigationView.setVisibility(View.VISIBLE);
        mBottomNavigationView.setItemBackgroundResource(R.color.materialGreen);
    }


    public void cardViewAdvanced(View v) {
        mFrameLayout = (FrameLayout) findViewById(R.id.frame);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.main_nav);
        mAdvancedFragment = new AdvancedFragment();
        setFragment(mAdvancedFragment);
        mBottomNavigationView.setVisibility(View.VISIBLE);
        mBottomNavigationView.setItemBackgroundResource(R.color.materialGreen);

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
   if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);




    }
}

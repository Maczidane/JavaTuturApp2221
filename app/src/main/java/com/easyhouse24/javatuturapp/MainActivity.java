package com.easyhouse24.javatuturapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mFrameLayout;

    private HomeFragment mHomeFragment;

    private QuestionFragment mQuestionFragment;

    private SettingFragment mSettingFragment;

    private BasicFragment mBasicFragment;

    private MainPageFragment mainPageFragment;

    private AdvancedFragment mAdvancedFragment;

    private CardView mCardView1;

    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // TODO: Add member variables here
    private int mClock;
    private int mDSoundId;
    private int mESoundId;
    private int mFSoundId;
    private int mGSoundId;
    private int mASoundId;
    private int mBSoundId;

    private long backPressedTime;



    private SoundPool mSoundPool;

    private MediaPlayer player;


    private BasicFragment basicFragment;

    private AdvancedFragment advancedFragment;

    private SetSelectFragment setSelectFragment;







    //Static variables creation to use in another activity
    static SoundPool mpool;
    static int mclock2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameLayout = (FrameLayout) findViewById(R.id.frame);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.main_nav);

        mHomeFragment = new HomeFragment();
        mSettingFragment = new SettingFragment();

        mQuestionFragment = new QuestionFragment();

        mainPageFragment = new MainPageFragment();

        basicFragment = new BasicFragment();

        advancedFragment = new AdvancedFragment();

        setSelectFragment = new SetSelectFragment();



        Bundle s = getIntent().getExtras();
        if (s != null) {
            String frag = s.getString("Fragment");

            if (frag.equals("Questions")) {
                //Toast.makeText(getApplicationContext(),frag,Toast.LENGTH_LONG).show();

                setFragment(setSelectFragment);

                mBottomNavigationView.inflateMenu(R.menu.qustions_menu);
                mBottomNavigationView.setSelectedItemId(R.id.nav_questions);
                mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId())
                        {
                            case R.id.nav_back:
                                onBackPressed();
                                return true;
                            case R.id.nav_programs:
                                PopupMenu popupMenu = new PopupMenu(MainActivity.this, mBottomNavigationView);

                                MenuInflater menuInflater = popupMenu.getMenuInflater();

                                menuInflater.inflate(R.menu.popup_menu, popupMenu.getMenu());

                                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem item) {

                                        switch (item.getItemId())
                                        {
                                            case R.id.nav_loops:

                                                Intent v = new Intent(getApplicationContext(),Program_1_Activity.class);
                                                startActivity(v);
                                               // Toast.makeText(getApplicationContext(),"Loops Clicked",Toast.LENGTH_SHORT).show();
                                                return true;

                                            case R.id.nav_strings:

                                                Intent s = new Intent(getApplicationContext(),Program_2_Activity.class);
                                                startActivity(s);
                                                return true;

                                            case R.id.nav_binary:

                                                Intent w = new Intent(getApplicationContext(),Program_3_Activity.class);
                                                startActivity(w);
                                                return true;

                                            case R.id.nav_write:

                                                Intent y = new Intent(getApplicationContext(),Program_4_Activity.class);
                                                startActivity(y);
                                                return true;

                                            case R.id.nav_prime:

                                                Intent f = new Intent(getApplicationContext(),Program_5_Activity.class);
                                                startActivity(f);
                                                return true;

                                            case R.id.nav_world:

                                                Intent z = new Intent(getApplicationContext(),Program_6_Activity.class);
                                                startActivity(z);
                                                return true;
                                        }

                                        return false;
                                    }
                                });

                                popupMenu.show();





                        }
                        return false;
                    }
                });

            }
            else if (frag.equals("Tutorials")){
                Toast.makeText(getApplicationContext(),frag,Toast.LENGTH_LONG).show();
            }
            else if (frag.equals("Basic")){

                setFragment(basicFragment);
                mBottomNavigationView.inflateMenu(R.menu.nav_items);
                mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId())
                        {
                            case R.id.nav_back:
                                onBackPressed();
                                return true;

                            case R.id.nav_questions:
                                setFragment(setSelectFragment);
                                return true;



                        }
                        return false;
                    }
                });
            }
            else if (frag.equals("Advanced")){
                setFragment(advancedFragment);
                mBottomNavigationView.inflateMenu(R.menu.nav_items);
                mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId())
                        {
                            case R.id.nav_back:
                                onBackPressed();
                                return true;

                            case R.id.nav_questions:
                                setFragment(setSelectFragment);
                                return true;



                        }
                        return false;
                    }
                });
            }

            else {

                    Toast.makeText(getApplicationContext(),"Something",Toast.LENGTH_LONG).show();

            }
        }
        else{

            Toast.makeText(getApplicationContext(),"No Intent Put extra",Toast.LENGTH_LONG).show();


        }


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_loops:
                Toast.makeText(getApplicationContext(),"Loops Clicked",Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    public void questionsClick(View v){
        mFrameLayout = (FrameLayout) findViewById(R.id.frame);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.main_nav);
        mQuestionFragment = new QuestionFragment();
        setFragment(mQuestionFragment);
        mBottomNavigationView.setVisibility(View.VISIBLE);
        mBottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);

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






    @Override
    public void onBackPressed() {

            super.onBackPressed();





    }

    // creating a class from which i can use or call in another activity ie sound pool class
    public static class otherClass{
        public void otherMethod(){
            mpool.play(mclock2,1.0f,1.0f,0,0,1.0f);
        }

    }

}

package com.easyhouse24.javatuturapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import static com.easyhouse24.javatuturapp.MainActivity.mpool;

public class StartActivity extends AppCompatActivity {

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

    private Toolbar toolbar;
    private long backPressedTime;


    private SoundPool mSoundPool;


    //Static variables creation to use in another activity
    static SoundPool mpool;
    static int mclock2;

    private MediaPlayer player;

    private CardView cardViewOrdinary;

    private CardView cardViewAdvanced;
    private CardView cardViewHelp;
    private CardView cardViewShare;

    private CardView cardViewQuestions;

    private CardView cardViewPrograms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        cardViewAdvanced = (CardView) findViewById(R.id.advanced_level);
        cardViewOrdinary = (CardView) findViewById(R.id.ordinary_level);
        cardViewHelp = (CardView) findViewById(R.id.help);
        cardViewPrograms = (CardView) findViewById(R.id.seeSample);
        cardViewShare = (CardView) findViewById(R.id.share);
        cardViewQuestions = (CardView) findViewById(R.id.questions);

        cardViewQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Fragment", "Questions");
                startActivity(i);
            }
        });

        cardViewOrdinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Fragment", "Basic");
                startActivity(i);
            }
        });
        cardViewAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Fragment", "Advanced");
                startActivity(i);
            }
        });
        cardViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);

                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "http://play.google.com/store/apps/details?id=com.easyhouse24.javatuturapp");
                    i.putExtra(Intent.EXTRA_TEXT, "http://www.url.com");
                    startActivity(Intent.createChooser(i, "Share App Using"));




            }
        });


        // creating an object of soundPool
        mSoundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);

        mpool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);

        // TODO: Load and get the IDs to identify the sounds

        mClock = mSoundPool.load(getApplicationContext(), R.raw.clicky, 1);

        //making a static variable to use in another class or activity
        mclock2 = mpool.load(getApplicationContext(), R.raw.clicky, 1);

        //Play the click
        //mSoundPool.play(mClock,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            askQuit();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);


    }

    // creating a class from which i can use or call in another activity ie sound pool class
    public static class otherClass {
        public void otherMethod() {
            mpool.play(mclock2, 1.0f, 1.0f, 0, 0, 1.0f);
        }

    }

    public void progressBar(){
        final  ProgressDialog progressDialog = new ProgressDialog(StartActivity.this);
        progressDialog.setMessage("Checking.....");
        progressDialog.setCancelable(false);

        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                progressDialog.show();
            }
        };
        handler.postDelayed(r, 3000);

    }

    public void askQuit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit Java Tutor App?");
        builder.setPositiveButton("STAY HERE", null);
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).show();
    }


    //Creating a method to call fragments in frame layout
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();

    }


}

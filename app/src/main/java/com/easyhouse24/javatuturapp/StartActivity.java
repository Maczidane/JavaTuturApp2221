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

                String prefAdvanced = getSharedPreferences("IS_ACCEPTED",MODE_PRIVATE).getString("X_NUMBER",null);


                if (prefAdvanced != null)
                {
                    int pref = Integer.valueOf(prefAdvanced);
                    if (pref >= 4)
                    {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("Fragment", "Advanced");
                        startActivity(i);
                    }
                    else{

                      if (pref == 1)
                        {
                            setAlertAdvancedUnlock("You have completed only the Introduction of Java tutorials. You're present knowledge is not enough to go to the Advanced section. Please read more tutorials under Basic to unlock this section ");
                        }
                        else if (pref == 2)
                        {
                            setAlertAdvancedUnlock("You have completed only the Basic Syntax and below of Java tutorials . You're present knowledge is not enough to go to the Advanced section. Please read more tutorials under Basic to unlock this section ");

                        }
                        else if (pref == 3)
                        {
                            setAlertAdvancedUnlock("You have completed only the Variable Types and below of Java tutorials. You're present knowledge is not enough to go to the Advanced section. Please read more tutorials under Basic to unlock this section ");

                        }
                        else{
                            setAlertAdvancedUnlock("You have completed only the Basic Data Types and below of Java tutorials. You're present knowledge is not enough to go to the Advanced section. Please read more tutorials under Basic to unlock this section ");

                        }

                    }
                }

                else{
                    setAlertAdvancedUnlock("This section is locked because you have not read any of the tutorials under basic thus can't go to advanced section since it is the continuation of the Basic section and may lead to confusion. Please read the Basic section to unlock advanced section.");
                }

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

        cardViewPrograms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p =  new Intent(getApplicationContext(),ProgramsActivity.class);
                startActivity(p);
            }
        });


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


    public void setAlertAdvancedUnlock(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton("Goto Basic Tutorials", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("Fragment", "Basic");

                startActivity(i);
            }
        });
        builder.setNegativeButton("Goto Main Menu",null);

        builder.setIcon(R.drawable.ic_error_outline_black_24dp);
        builder.show();
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

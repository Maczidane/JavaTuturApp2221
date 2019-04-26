package com.easyhouse24.javatuturapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {


    private static final String FILE_NAME_GOLD = "gold.txt";

    private static final String FILE_NAME_SILVER = "silver.txt";
    private static final String FILE_NAME_BRONZE = "bronze.txt";

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREF_SILVER = "sharedPrefsSilver";
    public static final String SHARED_PREF_GOLD = "sharedPrefsGold";
    public static final String SHARED_PREF_Bronze = "sharedPrefsBronze";

    public static final String KEY_HIGHSCORE = "keyHighscore";
    private static final String SHARED_PREF_Bronze1 = "sharedPrefsBronze1";
    private static final String SHARED_PREF_GOLD1 = "sharedPrefsGold1";
    private static final String SHARED_PREF_SILVER1 = "sharedPrefsSilver1";
    private static final String KEY_GOLD = "keyHighscore1";
    private static final String KEY_SILVER = "keyHighscore2";
    private static final String KEY_BRONZE = "keyHighscore3";

    private int highscore;

    private Button mButton;

    private TextView textViewbronze;

    private TextView textViewSilver;

    private TextView textViewGold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewbronze = (TextView) findViewById(R.id.textViewBronze);

        textViewSilver = (TextView) findViewById(R.id.textViewSilver);
        textViewGold = (TextView) findViewById(R.id.textViewGold);

        SharedPreferences prefBronze = getApplicationContext().getSharedPreferences(SHARED_PREF_Bronze, MODE_PRIVATE);
        if (prefBronze != null)
        {
            loadHighscore();
        }






        mButton = (Button) findViewById(R.id.btn_start_quiz);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });



    }

    public void startQuiz() {
        Intent i = new Intent(getApplicationContext(), QuizActivity.class);
        //startActivity(i);
        startActivityForResult(i, REQUEST_CODE_QUIZ);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);


                updateHighscore(score);

            }
        }
    }

    private void loadHighscore() {
        //Retrieving the bronze score

        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME_BRONZE);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

           while ((text = br.readLine()) != null){
                sb.append(text).append("");
            }
            textViewbronze.setText(sb.toString());


        } catch (FileNotFoundException e) {
           // Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }catch (IOException e) {
           // Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }
        finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        }

        //Retrieving silver Score

        FileInputStream fisSilver = null;

        try {
            fisSilver = openFileInput(FILE_NAME_SILVER);
            InputStreamReader isr = new InputStreamReader(fisSilver);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null){
                sb.append(text).append("");
            }
            textViewSilver.setText(sb.toString());


        } catch (FileNotFoundException e) {
            //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }catch (IOException e) {
            //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }
        finally {
            if (fisSilver != null){
                try {
                    fisSilver.close();
                } catch (IOException e) {
                   // Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        }


        //Retrieving the gold score

        FileInputStream fisGold = null;

        try {
            fisGold = openFileInput(FILE_NAME_GOLD);
            InputStreamReader isr = new InputStreamReader(fisGold);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null){
                sb.append(text).append("");
            }
            textViewGold.setText(sb.toString());

            Log.e("Error", sb.toString());
        } catch (FileNotFoundException e) {
            //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }catch (IOException e) {
            //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }
        finally {
            if (fisGold != null){
                try {
                    fisGold.close();
                } catch (IOException e) {
                   // Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        }


        String silver = textViewSilver.getText().toString();
        String bronze = textViewbronze.getText().toString();
        String gold = textViewGold.getText().toString();


        int highscoreGold = Integer.parseInt(gold);
        int highscoreSilver = Integer.parseInt(silver);
        int highscoreBronze = Integer.parseInt(bronze);



        if (highscoreSilver >= 3 && highscoreGold >= 2 && highscoreBronze >= 3) {
            SuccessAlert();
        }

        else if(highscoreGold >= 3)
        {         SuccessAlert();

        }





    }

    private void updateHighscore(int highscoreNew) {

        highscore = highscoreNew;

        String gold = textViewGold.getText().toString();
        String silver = textViewSilver.getText().toString();
        String bronze = textViewbronze.getText().toString();

        final int bronze1 = Integer.parseInt(bronze);

        int gold1 = Integer.valueOf(gold);

        int silver1 = Integer.valueOf(silver);
        //int bronze1 = Integer.valueOf(bronze);

        if (highscore >= 7 && highscore < 9) {


            int silver2 = silver1 + 1;


            String silver3 = String.valueOf(silver2);
            textViewSilver.setText(silver3);



        } else if (highscoreNew >= 9) {




            int gold2 = gold1 + 1;



            String gold3 = String.valueOf(gold2);
            textViewGold.setText(gold3);




        } else if (highscore >= 5 && highscore < 7) {



            int bronze2 = bronze1 + 1;

            String bronze3 = String.valueOf(bronze2);
            textViewbronze.setText(bronze3);



        }


      store();

    }

    //Making the score system for the trophies

    public void store(){


        String gold11 = textViewGold.getText().toString();
        String silver11 = textViewSilver.getText().toString();
        String bronze11 = textViewbronze.getText().toString();

        // Save  the bronze score

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME_BRONZE,MODE_PRIVATE);
            try {


                fos.write(bronze11.getBytes());
                //Toast.makeText(getApplicationContext(),"Bronze Stored to " + getFilesDir() + "/" + FILE_NAME_BRONZE, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }
        finally {
            if ( fos!= null)
            {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // Save Silver score



        FileOutputStream fosSilver = null;

        try {
            fosSilver = openFileOutput(FILE_NAME_SILVER,MODE_PRIVATE);
            try {


                fosSilver.write(silver11.getBytes());
               // Toast.makeText(getApplicationContext(),"Bronze Stored to " + getFilesDir() + "/" + FILE_NAME_SILVER, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }
        finally {
            if ( fosSilver!= null)
            {
                try {
                    fosSilver.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // Saving the Goal Score

        FileOutputStream fosGold = null;

        try {
            fosGold = openFileOutput(FILE_NAME_GOLD,MODE_PRIVATE);
            try {


                fosGold.write(gold11.getBytes());
                //Toast.makeText(getApplicationContext(),"Bronze Stored to " + getFilesDir() + "/" + FILE_NAME_GOLD, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            //Toast.makeText(this, e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

        }
        finally {
            if ( fosGold!= null)
            {
                try {
                    fosGold.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void SuccessAlert() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setIcon(R.drawable.ic_stars_black_24dp);
        alert.setMessage("Congratulations , you have unlocked a new app!");

        alert.setPositiveButton("Get App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callShare();
            }
        });

        alert.setNegativeButton("Leave It", null);
        alert.show();
    }


    public void callShare() {
        Intent i = new Intent(Intent.ACTION_SEND);

        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "http://play.google.com/store/apps/details?id=com.easyhouse24.javatuturapp");
        i.putExtra(Intent.EXTRA_TEXT, "http://play.google.com/store/apps/details?id=com.easyhouse24.javatuturapp");
        startActivity(Intent.createChooser(i, "Get App Using"));
    }

    @Override
    public void onBackPressed() {
       super.onBackPressed();
    }





}

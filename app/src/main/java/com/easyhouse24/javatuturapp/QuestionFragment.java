package com.easyhouse24.javatuturapp;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private static final int REQUEST_CODE_QUIZ = 1;

    public static final String SHARED_PREF_SILVER = "sharedPrefsSilver";
    public static final String SHARED_PREF_GOLD = "sharedPrefsGold";
    public static final String SHARED_PREF_Bronze = "sharedPrefsBronze";

    public static final String KEY_HIGHSCORE = "keyHighscore";
    private static final String SHARED_PREF_Bronze1 = "sharedPrefsBronze1";
    private static final String SHARED_PREF_GOLD1 = "sharedPrefsGold1";
    private static final String SHARED_PREF_SILVER1 = "sharedPrefsSilver1";
    private static final String KEY_HIGHSCORE1 = "keyHighscore1";
    private static final String KEY_HIGHSCORE2 = "keyHighscore2";
    private static final String KEY_HIGHSCORE3 = "keyHighscore3";
    private static final String FILE_NAME_GOLD = "gold.txt";

    private static final String FILE_NAME_SILVER = "silver.txt";
    private static final String FILE_NAME_BRONZE = "bronze.txt";
    private int highscore;

    private TextView textViewbronse;

    private TextView textViewSilver;

    private TextView textViewGold;

    private Button mButton;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question, container, false);


        textViewbronse = (TextView) v.findViewById(R.id.textViewBronze);

        textViewSilver = (TextView) v.findViewById(R.id.textViewSilver);
        textViewGold = (TextView) v.findViewById(R.id.textViewGold);

        String gold = textViewGold.getText().toString();
        int gold1 = Integer.valueOf(gold);
        if (gold1 >= 3) {
            SuccessAlert();
        }

        loadHighscore();


        mButton = (Button) v.findViewById(R.id.btn_start_quiz);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });


        return v;
    }

    public void startQuiz() {
        Intent i = new Intent(getContext(), QuizActivity.class);
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


        FileInputStream fis = null;

        try {
            fis = getContext().openFileInput(FILE_NAME_GOLD);

            InputStreamReader isr = new InputStreamReader(fis);

            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine() ) != null){
                sb.append(text).append("");
                textViewGold.setText(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



        FileInputStream fisSilver = null;

        try {
            fisSilver = getContext().openFileInput(FILE_NAME_SILVER);

            InputStreamReader isr = new InputStreamReader(fisSilver);

            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine() ) != null){
                sb.append(text).append("");
                textViewSilver.setText(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (fisSilver != null){
                try {
                    fisSilver.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        FileInputStream fisBronze = null;

        try {
            fisBronze = getContext().openFileInput(FILE_NAME_BRONZE);

            InputStreamReader isr = new InputStreamReader(fisBronze);

            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine() ) != null){
                sb.append(text).append("");
                textViewbronse.setText(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (fisBronze != null){
                try {
                    fisBronze.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        String gold = textViewGold.getText().toString();
        int gold1 = Integer.valueOf(gold);
        if (gold1 >= 3) {
            SuccessAlert();
        }



    }

    private void updateHighscore(int highscoreNew) {

        highscore = highscoreNew;

        String gold = textViewGold.getText().toString();
        String silver = textViewSilver.getText().toString();
        String bronze = textViewbronse.getText().toString();

        int gold1 = Integer.valueOf(gold);

        int silver1 = Integer.valueOf(silver);
        int bronze1 = Integer.valueOf(bronze);

        if (highscore >= 7 && highscore < 9) {


            int silver2 = silver1 + 1;


            String silver3 = String.valueOf(silver2);
            textViewSilver.setText(silver3);



        } else if (highscoreNew >= 9) {


            int gold2 = gold1 + 1;





            if (gold1 >= 3) {
                SuccessAlert();
            }

            String gold3 = String.valueOf(gold2);
            textViewGold.setText(gold3);




        } else if (highscore >= 5 && highscore < 7) {


            int bronze2 = bronze1 + 1;

            String bronze3 = String.valueOf(bronze2);
            textViewbronse.setText(bronze3);
            store();


        }


        store();

    }

    public void store() {


        String gold11 = textViewGold.getText().toString();
        String silver11 = textViewSilver.getText().toString();
        String bronze11 = textViewbronse.getText().toString();

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = getContext().openFileOutput(FILE_NAME_GOLD,MODE_PRIVATE);
            try {
                fileOutputStream.write(gold11.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        FileOutputStream fileOutputStreamSilver = null;

        try {
            fileOutputStreamSilver = getContext().openFileOutput(FILE_NAME_SILVER,MODE_PRIVATE);
            try {
                fileOutputStreamSilver.write(silver11.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (fileOutputStreamSilver != null){
                try {
                    fileOutputStreamSilver.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        FileOutputStream fileOutputStreamBronze = null;

        try {
            fileOutputStreamBronze = getContext().openFileOutput(FILE_NAME_BRONZE,MODE_PRIVATE);
            try {
                fileOutputStreamBronze.write(bronze11.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (fileOutputStreamBronze != null){
                try {
                    fileOutputStreamBronze.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public void SuccessAlert() {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
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
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);


        //Copy App URL from Google Play Store.
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.duy.compiler.javanide"));

        startActivity(intent);

    }


    @Override
    public void onStart() {
        super.onStart();
        loadHighscore();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadHighscore();
    }


}


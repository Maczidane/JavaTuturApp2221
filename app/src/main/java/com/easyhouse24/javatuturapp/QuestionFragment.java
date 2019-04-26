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
        SharedPreferences prefSilver = getActivity().getSharedPreferences(SHARED_PREF_SILVER, MODE_PRIVATE);

        int highscoreSilver = prefSilver.getInt(KEY_HIGHSCORE2, 0);


        SharedPreferences prefGold = getActivity().getSharedPreferences(SHARED_PREF_GOLD, MODE_PRIVATE);

        int highscoreGold = prefGold.getInt(KEY_HIGHSCORE1, 0);

        SharedPreferences prefBronze = getActivity().getSharedPreferences(SHARED_PREF_Bronze, MODE_PRIVATE);
        int highscoreBronze = prefBronze.getInt(KEY_HIGHSCORE3, 0);



        if (highscoreSilver >= 3 && highscoreGold >= 2 && highscoreBronze >= 5) {
            SuccessAlert();
        }

        else if(highscoreGold >= 3)
        {         SuccessAlert();

        }




        int silver20 =  highscoreSilver;

        String silver3 = String.valueOf(silver20);
        textViewSilver.setText(silver3);

        int gold20 =  highscoreGold;

        String gold3 = String.valueOf(gold20);
        textViewSilver.setText(gold3);

        int bronze20 = highscoreBronze;


        String bronze3 = String.valueOf(bronze20);
        textViewSilver.setText(bronze3);



    }

    private void updateHighscore(int highscoreNew) {
        store();
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
            store();


        } else if (highscoreNew >= 9) {




            int gold2 = gold1 + 1;

            if (gold2 >= 3)
            {
                SuccessAlert();
            }

            String gold3 = String.valueOf(gold2);
            textViewGold.setText(gold3);

            store();


        } else if (highscore >= 5 && highscore < 7) {


            int bronze2 = bronze1 + 1;

            String bronze3 = String.valueOf(bronze2);
            textViewbronse.setText(bronze3);
            store();


        }


        store();

    }

    public void store(){

        AlertDialog.Builder sha = new AlertDialog.Builder(getContext());

        sha.setMessage("Hey");

        sha.setCancelable(true);
        sha.show();


        String gold11 = textViewGold.getText().toString();
        String silver11 = textViewSilver.getText().toString();
        String bronze11 = textViewbronse.getText().toString();


        int gold21 = Integer.parseInt(gold11);
        int silver21 = Integer.parseInt(silver11);
        int bronze21 = Integer.parseInt(bronze11);

        SharedPreferences prefBronze1 = getActivity().getSharedPreferences(SHARED_PREF_Bronze, MODE_PRIVATE);
        SharedPreferences.Editor editor2 = prefBronze1.edit();
        editor2.putInt(KEY_HIGHSCORE3, bronze21).apply();

        SharedPreferences prefGold1 = getActivity().getSharedPreferences(SHARED_PREF_GOLD, MODE_PRIVATE);
        SharedPreferences.Editor editor1 = prefGold1.edit();
        editor1.putInt(KEY_HIGHSCORE1, gold21).apply();


        SharedPreferences prefSilver1 = getActivity().getSharedPreferences(SHARED_PREF_SILVER, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefSilver1.edit();
        editor.putInt(KEY_HIGHSCORE2, silver21).apply();

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


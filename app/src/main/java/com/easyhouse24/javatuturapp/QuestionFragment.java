package com.easyhouse24.javatuturapp;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

        //loadHighscore();

        SharedPreferences pref = getActivity().getSharedPreferences("IC_GOLD", Context.MODE_PRIVATE);
        SharedPreferences pref1 = getActivity().getSharedPreferences("IC_SILVER", Context.MODE_PRIVATE);
        SharedPreferences pref2 = getActivity().getSharedPreferences("IC_BRONZE", Context.MODE_PRIVATE);


        String prefGold = pref.getString("Gold", null);
        String prefSilver = pref1.getString("Silver", null);
        String prefBronze = pref2.getString("Bronze", null);


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
        int highscoreSilver = prefSilver.getInt(KEY_HIGHSCORE, 0);

        SharedPreferences prefGold = getActivity().getSharedPreferences(SHARED_PREF_GOLD, MODE_PRIVATE);
        int highscoreGold = prefSilver.getInt(KEY_HIGHSCORE, 0);

        SharedPreferences prefBronze = getActivity().getSharedPreferences(SHARED_PREF_Bronze, MODE_PRIVATE);
        int highscoreBronze = prefSilver.getInt(KEY_HIGHSCORE, 0);


        String gold = textViewGold.getText().toString();
        String silver = textViewSilver.getText().toString();
        String bronze = textViewbronse.getText().toString();


        int gold1 = Integer.parseInt(gold);
        int silver1 = Integer.parseInt(silver);
        int bronze1 = Integer.parseInt(bronze);

        if (silver1 >= 3 && gold1 >= 2 && bronze1 >= 5) {
            SuccessAlert();
        }


        int silver2 = silver1 + highscoreSilver;

        String silver3 = String.valueOf(silver2);
        textViewSilver.setText(silver3);

        int gold2 = gold1 + highscoreGold;

        String gold3 = String.valueOf(gold2);
        textViewSilver.setText(gold3);

        int bronze2 = bronze1 + highscoreBronze;

        String bronze3 = String.valueOf(bronze2);
        textViewSilver.setText(bronze3);

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
            SharedPreferences prefSilver = getActivity().getSharedPreferences(SHARED_PREF_SILVER, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefSilver.edit();
            editor.putInt(KEY_HIGHSCORE, silver2).apply();
        } else if (highscoreNew >= 9) {
            int gold2 = gold1 + 1;

            String gold3 = String.valueOf(gold2);
            textViewSilver.setText(gold3);
            SharedPreferences prefGold = getActivity().getSharedPreferences(SHARED_PREF_GOLD, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefGold.edit();
            editor.putInt(KEY_HIGHSCORE, gold2).apply();
        } else if (highscore >= 5 && highscore < 7) {
            int bronze2 = bronze1 + 1;

            String bronze3 = String.valueOf(bronze2);
            textViewSilver.setText(bronze3);
            SharedPreferences prefBronze = getActivity().getSharedPreferences(SHARED_PREF_Bronze, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefBronze.edit();
            editor.putInt(KEY_HIGHSCORE, bronze2).apply();
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
        Intent i = new Intent(Intent.ACTION_SEND);

        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "http://play.google.com/store/apps/details?id=com.easyhouse24.javatuturapp");
        i.putExtra(Intent.EXTRA_TEXT, "http://www.url.com");
        startActivity(Intent.createChooser(i, "Get App Using"));
    }
}

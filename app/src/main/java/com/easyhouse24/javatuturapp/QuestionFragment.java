package com.easyhouse24.javatuturapp;


import android.content.Context;
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

        public static final String SHARED_PREF = "sharedPrefs";

        public static final String KEY_HIGHSCORE ="keyHighscore";

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
            View v =  inflater.inflate(R.layout.fragment_question, container, false);

            textViewbronse = (TextView) v.findViewById(R.id.textViewBronze);

            textViewSilver = (TextView) v.findViewById(R.id.textViewSilver);
            textViewGold = (TextView) v.findViewById(R.id.textViewGold);

            //loadHighscore();

            SharedPreferences pref = getActivity().getSharedPreferences("IC_GOLD", Context.MODE_PRIVATE);
            SharedPreferences pref1 = getActivity().getSharedPreferences("IC_SILVER", Context.MODE_PRIVATE);
            SharedPreferences pref2 = getActivity().getSharedPreferences("IC_BRONZE", Context.MODE_PRIVATE);


            String prefGold = pref.getString("Gold",null);
            String prefSilver = pref1.getString("Silver",null);
            String prefBronze = pref2.getString("Bronze",null);

  /*          if (prefGold == null)
            {
                textViewGold.setText("0");
            }
            else{
                textViewGold.setText(prefGold);
            }

            if (prefSilver == null)
            {
                textViewSilver.setText("0");
            }
            else{
                textViewSilver.setText(prefSilver);
            }


            if (prefBronze == null)
            {
                textViewbronse.setText("0");
            }
            else{
                textViewbronse.setText(prefBronze);
            }*/



            mButton = (Button) v.findViewById(R.id.btn_start_quiz);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   startQuiz();
                }
            });


            return  v;
        }

        public  void startQuiz()
        {
            Intent i = new Intent(getContext(), QuizActivity.class);
            startActivity(i);
            //startActivityForResult(i,REQUEST_CODE_QUIZ);
        }

   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ)
        {
            if (resultCode == RESULT_OK)
            {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE,0);


                    updateHighscore(score);

            }
        }
    }

    private void loadHighscore(){
            SharedPreferences preferences = getActivity().getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
            highscore = preferences.getInt(KEY_HIGHSCORE,0);




        String gold = textViewGold.getText().toString();
        String silver = textViewSilver.getText().toString();
        String bronze = textViewbronse.getText().toString();

        int  gold1 = Integer.parseInt(gold);
        int  silver1 = Integer.parseInt(silver);
        int  bronze1 = Integer.parseInt(bronze);

        if (highscore <= 3 && highscore > 2)
        {
            int silver2 = silver1 + highscore;

            String silver3 = String.valueOf(silver2);
            textViewSilver.setText(silver3);
        }

        else if(highscore >=4 && highscore != 5 )
        {
            int gold2 = gold1 + highscore;

            String gold3 = String.valueOf(gold2);
            textViewSilver.setText(gold3);
        }

        else if (highscore == 2 ){
            int bronze2 = bronze1 + highscore;

            String bronze3 = String.valueOf(bronze2);
            textViewSilver.setText(bronze3);
        }

    }
    private void updateHighscore(int highscoreNew)
    {
        highscore = highscoreNew;

        String gold = textViewGold.getText().toString();
        String silver = textViewSilver.getText().toString();
        String bronze = textViewbronse.getText().toString();

        int  gold1 = Integer.valueOf(gold);
        int  silver1 = Integer.valueOf(silver);
        int  bronze1 = Integer.valueOf(bronze);

        if (highscore <= 3 && highscore > 2)
        {
            int silver2 = silver1 + highscore;

            String silver3 = String.valueOf(silver2);
            textViewSilver.setText(silver3);
        }

        else if(highscoreNew >=4 && highscoreNew != 5 )
        {
            int gold2 = gold1 + highscore;

            String gold3 = String.valueOf(gold2);
            textViewSilver.setText(gold3);
        }

        else if (highscore == 2 ){
            int bronze2 = bronze1 + highscore;

            String bronze3 = String.valueOf(bronze2);
            textViewSilver.setText(bronze3);
        }

        SharedPreferences pref = getActivity().getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(KEY_HIGHSCORE,highscore).apply();

    }*/
}

package com.easyhouse24.javatuturapp;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    private TextView textViewQuestion;

    private RadioGroup mRadioGroup;

    private int PROGRESS_BAR_INCREMENT = 8;

    ProgressBar mProgressBar;

    private TextView textViewScore;

    private static final long COUNT_DOWN_MILLIS = 30000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MINUTES_LEFT = "keyMinutesLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";
    private TextView textViewCountDown;
    private TextView textViewQuestionCount;

    private TextView textViewTime;

    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;

    private Button btn;

    private ArrayList<Question> mQuestionList;

    private ColorStateList textColorDefaultRb;

    private ColorStateList textColordefaultCd;

    private CountDownTimer mCountDownTimer;

    private long timeLeftInMillis;

    private int questionCounter;

    private int questionCountTotal;

    private Question currentQuestion;

    private int score;

    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

       mToolbar = (Toolbar) findViewById(R.id.toolbar_questions);

        textViewCountDown = findViewById(R.id.textView_count);
        //
        textViewQuestion = findViewById(R.id.textView_questionaire);
        textViewScore = findViewById(R.id.text_view_score);

        textViewQuestionCount = findViewById(R.id.textView4);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Making progressBar visible
        mProgressBar.setVisibility(View.VISIBLE);

        //Setting the initial state of the progressBar
        mProgressBar.setProgress(0);
        mProgressBar.setMax(100);





        //
        btn = findViewById(R.id.buttonNext);

        mRadioButton1 = findViewById(R.id.radioButton);

        mRadioButton2 = findViewById(R.id.radioButton2);

        mRadioButton3 = findViewById(R.id.radioButton3);

        mRadioButton4 = findViewById(R.id.radioButton4);

        mRadioGroup = findViewById(R.id.radioGroup2);

        textColorDefaultRb = mRadioButton1.getTextColors();

        textColordefaultCd = textViewCountDown.getTextColors();

        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               askQuit();
            }
        });


        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);

            mQuestionList = dbHelper.getAllQuestion();

            questionCountTotal = mQuestionList.size();

            Collections.shuffle(mQuestionList);

            showNextQuestion();
        }
        else{
            mQuestionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);

            if (mQuestionList == null)
            {
                finish();
            }
            questionCountTotal = mQuestionList.size();

            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);

            currentQuestion = mQuestionList.get(questionCounter - 1);

            score = savedInstanceState.getInt(KEY_SCORE);

            timeLeftInMillis = savedInstanceState.getLong(KEY_MINUTES_LEFT);

            answered = savedInstanceState.getBoolean(KEY_ANSWERED);

            if (!answered)
            {
                startCountDown();
            }
            else {
                updateCountDownText();
                showSolution();
            }
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered)
                {
                    if (mRadioButton1.isChecked() || mRadioButton2.isChecked() || mRadioButton3.isChecked() || mRadioButton4.isChecked()){
                        checkAnswer();
                    }
                    else{
                        Toast.makeText(QuizActivity.this,"Please select an answer",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion(){

        mRadioButton1.setTextColor(textColorDefaultRb);
        mRadioButton2.setTextColor(textColorDefaultRb);
        mRadioButton3.setTextColor(textColorDefaultRb);
        mRadioButton4.setTextColor(textColorDefaultRb);

        mRadioGroup.clearCheck();

        //implementing a progress bar

        int questionCounter1 = mQuestionList.size();


        PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / questionCounter1);
        final int PROGRESS_BAR_INCREMENT1 = (int) Math.ceil(120.0 / questionCounter1);

        Log.d("Size", "Increment is : " + PROGRESS_BAR_INCREMENT);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mProgressBar.setSecondaryProgress(PROGRESS_BAR_INCREMENT1);

        if (questionCounter < questionCountTotal)
        {
            currentQuestion = mQuestionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());

            mRadioButton1.setText(currentQuestion.getOption1());
            mRadioButton2.setText(currentQuestion.getOption2());
            mRadioButton3.setText(currentQuestion.getOption3());
            mRadioButton4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);

            answered = false;

            btn.setText("Confirm");

            timeLeftInMillis = COUNT_DOWN_MILLIS;
            startCountDown();

        }
        else{
            finishQuiz();
        }


    }

    public  void askQuit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit Quiz? All unsaved progress will be lost.");
        builder.setPositiveButton("STAY HERE", null);
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).show();
    }

    @Override
    public void onBackPressed() {
        askQuit();
    }

    private void startCountDown(){
        mCountDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis /1000) /60;
        int seconds = (int)(timeLeftInMillis / 1000) % 60;

        String timeFormated = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        textViewCountDown.setText(timeFormated);

        if (timeLeftInMillis < 10000)
        {
            textViewCountDown.setTextColor(Color.RED);
        }
        else{
            textViewCountDown.setTextColor(textColordefaultCd);
        }
    }

    private void checkAnswer(){
        answered = true;

        mCountDownTimer.cancel();

        RadioButton rbSelected = findViewById(mRadioGroup.getCheckedRadioButtonId());

        int answerNr = mRadioGroup.indexOfChild(rbSelected)+1;

        if (answerNr == currentQuestion.getAnswerNr())
        {
            score++;
            textViewScore.setText("Score : " + score);
        }

        showSolution();
    }



    private void showSolution(){
        mRadioButton1.setTextColor(Color.RED);
        mRadioButton2.setTextColor(Color.RED);
        mRadioButton3.setTextColor(Color.RED);
        mRadioButton4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()){
            case 1:
                mRadioButton1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                mRadioButton2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                mRadioButton3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;
            case 4:
                mRadioButton4.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 4 is correct");
                break;
        }

        if (questionCounter < questionCountTotal)
        {
            btn.setText("Next");
        }
        else{
            btn.setText("Finish");
        }
    }
    public void finishQuiz(){
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null)
        {
            mCountDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE,score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MINUTES_LEFT,timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST,mQuestionList);
    }
}

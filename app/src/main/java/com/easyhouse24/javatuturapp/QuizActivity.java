package com.easyhouse24.javatuturapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import static com.easyhouse24.javatuturapp.QuestionFragment.KEY_HIGHSCORE;
import static com.easyhouse24.javatuturapp.QuestionFragment.SHARED_PREF_Bronze;
import static com.easyhouse24.javatuturapp.QuestionFragment.SHARED_PREF_GOLD;
import static com.easyhouse24.javatuturapp.QuestionFragment.SHARED_PREF_SILVER;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extraScore";
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

    private CoordinatorLayout coordinatorLayout;

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

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        // We load a drawable and create a location to show a tap target here
        // We need the display to get the width and height at this point in time
        final Display display = getWindowManager().getDefaultDisplay();


        // Load our little check sign
        final Drawable droid = ContextCompat.getDrawable(this, R.drawable.ic_check_black_24dp);
        // Tell our droid buddy where we want him to appear
        final Rect droidTarget = new Rect(0, 0, droid.getIntrinsicWidth() * 2, droid.getIntrinsicHeight() * 2);
        // Using deprecated methods makes you look way cool
        droidTarget.offset(display.getWidth() / 2, display.getHeight() / 2);



        // Run the makeUSerGuide if app is run for the first time

        Boolean QuizFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("QuizFirstRun", true);

        if (QuizFirstRun) {


            //////////////////////////////////////////////

            // all this code is for the makeUser Guide


            final SpannableString spannedDesc2 = new SpannableString("Select a correct answer");
            spannedDesc2.setSpan(new UnderlineSpan(), spannedDesc2.length() - " from below".length(), spannedDesc2.length(), 0);


            // You don't always need a sequence, and for that there's a single time tap target
            //This will start the above sequence
            final SpannableString spannedDesc1 = new SpannableString("The total number of  answered ");
            spannedDesc1.setSpan(new UnderlineSpan(), spannedDesc1.length() - "over total question".length(), spannedDesc1.length(), 0);

            final SpannableString spannedDesc3 = new SpannableString("Here is the Time left to ");
            spannedDesc3.setSpan(new UnderlineSpan(), spannedDesc3.length() - "answer all question".length(), spannedDesc3.length(), 0);


            //For the scores
            final SpannableString spannedDesc4 = new SpannableString("Here See your ");
            spannedDesc4.setSpan(new UnderlineSpan(), spannedDesc4.length() - "current score".length(), spannedDesc4.length(), 0);

            //for the questionare
            //final SpannableString spannedDesc5 = new SpannableString("Here you will see the questions");
            //spannedDesc5.setSpan(new StyleSpan(Typeface.ITALIC), spannedDesc5.length() - "always remember to scroll down by touching the question and moving down to see complete question".length(), spannedDesc5.length(), 0);


            final TapTargetSequence sequence = new TapTargetSequence(this)
                    .targets(


                            //Likewise, this tap target will target the search button
//                        TapTarget.forToolbarMenuItem(toolbar, R.id.searchx, "This is a music icon", "Use is to turn background music On / Off")
//                                .dimColor(android.R.color.black)
//                                .outerCircleColor(R.color.colorAccent)
//                                .targetCircleColor(android.R.color.black)
//                                .transparentTarget(true)
//                                .textColor(android.R.color.black)
//                                .id(1),
                            // You can also target the overflow button in your toolbar
                            TapTarget.forToolbarOverflow(mToolbar, "This will show more options. ", "Save progress, help etc")
                                    .outerCircleColor(R.color.red)
                                    .textColor(R.color.white)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .id(1),
                            // This tap target will target our droid buddy at the given target rect
                            TapTarget.forBounds(droidTarget, "Tutorial Completed", "Now you are ready to get to the real part")
                                    .cancelable(true)
                                    .outerCircleColor(R.color.green)
                                    .icon(droid)
                                    .tintTarget(true)
                                    .textColor(R.color.white)
                                    .id(2)
                    )
                    .listener(new TapTargetSequence.Listener() {
                        // This listener will tell us when interesting(tm) events happen in regards
                        // to the sequence
                        @Override
                        public void onSequenceFinish() {

                            // Handle count down timer
                            if (mCountDownTimer == null) {
                                mCountDownTimer.start();
                            } else {
                                mCountDownTimer.cancel();
                                mCountDownTimer.start();
                            }
                        }

                        @Override
                        public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
                            Log.d("TapTargetView", "Clicked on " + lastTarget.id());
                        }

                        @Override
                        public void onSequenceCanceled(TapTarget lastTarget) {
                            final AlertDialog dialog = new AlertDialog.Builder(QuizActivity.this)
                                    .setTitle("Uh oh")
                                    .setMessage("You canceled the sequence")
                                    .setPositiveButton("Oops", null).show();
                            TapTargetView.showFor(dialog,
                                    TapTarget.forView(dialog.getButton(DialogInterface.BUTTON_POSITIVE), "Uh oh!", "You canceled the sequence at step " + lastTarget.id())
                                            .cancelable(false)
                                            .tintTarget(true)
                                            .descriptionTextColor(R.color.white)
                                            .outerCircleColor(R.color.s2)
                                            .textColor(R.color.color_Text_Hint)
                                            .tintTarget(false), new TapTargetView.Listener() {
                                        @Override
                                        public void onTargetClick(TapTargetView view) {
                                            super.onTargetClick(view);
                                            dialog.dismiss();
                                        }
                                    });

                            // Handle count down timer
                            if (mCountDownTimer == null) {
                                mCountDownTimer.start();
                            } else {
                                mCountDownTimer.cancel();
                            }
                        }
                    });

            //another sequence


            final TapTargetSequence sequence2 = new TapTargetSequence(this)
                    .targets(
                            TapTarget.forView(findViewById(R.id.textView_questionaire), "Questions", "always remember to scroll down by touching the question and moving down to see complete question")
                                    .outerCircleColor(R.color.s1)
                                    .cancelable(false)
                                    .tintTarget(true)
                                    .targetCircleColor(R.color.white)
                                    .descriptionTextColor(R.color.black)
                                    .dimColor(R.color.black),
                            TapTarget.forView(findViewById(R.id.text_view_score), "Score", spannedDesc4)
                                    .outerCircleColor(R.color.grey)      // Specify a color for the outer circle
                                    .outerCircleAlpha(0.96f)
                                    .tintTarget(true),

                            TapTarget.forView(findViewById(R.id.textView_count), "Chronometer", spannedDesc3)
                                    .tintTarget(true)
                                    .outerCircleColor(R.color.colorPrimaryDark)      // Specify a color for the outer circle
                                    .outerCircleAlpha(0.96f),
                            TapTarget.forView(findViewById(R.id.textView4), "Number of Questions", spannedDesc1)
                                    .dimColor(android.R.color.black)
                                    .outerCircleColor(R.color.colorPrimary)
                                    .cancelable(false)
                    )

                    .listener(new TapTargetSequence.Listener() {
                        // This listener will tell us when interesting(tm) events happen in regards
                        // to the sequence
                        @Override
                        public void onSequenceFinish() {
                            startServiceOne();
                            makeSnackBar(R.string.snackbar, R.string.turnOff1, R.string.background);

                            // Handle count down timer
                            if (mCountDownTimer == null) {
                                mCountDownTimer.start();
                            } else {
                                mCountDownTimer.cancel();
                                mCountDownTimer.start();
                            }
                            sequence.start();
                        }

                        @Override
                        public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                        }


                        @Override
                        public void onSequenceCanceled(TapTarget lastTarget) {
                            // Boo
                            final AlertDialog dialog = new AlertDialog.Builder(QuizActivity.this)
                                    .setTitle("Uh oh")
                                    .setMessage("You canceled the sequence")
                                    .setPositiveButton("Oops", null).show();
                            TapTargetView.showFor(dialog,
                                    TapTarget.forView(dialog.getButton(DialogInterface.BUTTON_POSITIVE), "Uh oh!", "You canceled the sequence at step " + lastTarget.id())
                                            .cancelable(false)
                                            .tintTarget(false), new TapTargetView.Listener() {
                                        @Override
                                        public void onTargetClick(TapTargetView view) {
                                            super.onTargetClick(view);
                                            dialog.dismiss();
                                        }
                                    });
                        }
                    });


            // You don't always need a sequence, and for that there's a single time tap target

            TapTargetView.showFor(this, TapTarget.forView(findViewById(R.id.radioGroup2), "Answers", spannedDesc2)
                    .cancelable(false)
                    .drawShadow(true)
                    .outerCircleColor(R.color.colorAccent)

                    .tintTarget(false), new TapTargetView.Listener() {
                @Override
                public void onTargetClick(TapTargetView view) {
                    super.onTargetClick(view);
                    // .. which evidently starts the sequence we defined earlier
                    sequence2.start();


                }

                @Override
                public void onOuterCircleClick(TapTargetView view) {
                    super.onOuterCircleClick(view);
                    Toast.makeText(view.getContext(), "You clicked the outer circle!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
                    Log.d("TapTargetViewSample", "You dismissed me :(");
                }
            });



            //////////////////////// End of code to build user guide


            //Since app was running for first time, register app as already run to prevent dialogue again
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("QuizFirstRun", false).apply();
        }




        if (savedInstanceState == null) {
            QuizDbHelper dbHelper = new QuizDbHelper(this);

            String prefDifficulty = getSharedPreferences("IS_DIFFICULTY",MODE_PRIVATE).getString("X_DIFFICULTY",null);
            if (prefDifficulty != null) {

                mQuestionList = dbHelper.getQuestion(prefDifficulty);

                questionCountTotal = mQuestionList.size();

                Collections.shuffle(mQuestionList);

                NotifyUser();
            }
            else{
                Toast.makeText(getApplicationContext(),"No questions yet. Still to put questions",Toast.LENGTH_LONG).show();
                finishQuiz();
            }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.searchx) {
            //handling button for turn music On / Off
            final Boolean On_Off = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("On_Off", false);


            if (!On_Off) {
                stopServiceOne();
                makeSnackbar1(R.string.background);
                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("On_Off", true).commit();
            } else {
                startServiceOne();
                makeSnackbar2(R.string.snackbar);
                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("On_Off", false).commit();
            }

        }

        //handling when back button pressed on toolbar.
        // using android.R.id.home because this button was inserted using
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (id == android.R.id.home) {
            //closing current activity
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void NotifyUser() {
       Boolean QuizFirst = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("QuizFirst", true);

        if(QuizFirst)
        {
            new AlertDialog.Builder(this)
                    .setMessage("Welcome. Here you will be confronted with 10 Random Java standard MCQ\\'s under the selected question set. Time allowed will be 30 seconds per question. Good Luck")
                    .setCancelable(false)
                    .setIcon(R.drawable.ic_timer_black_24dp)
                    .setTitle("MCQs")
                    .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showNextQuestion();
                            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("QuizFirst", false).apply();
                        }
                    }).show();
       }
        else{
            showNextQuestion();
        }
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
            showScoreAlert(score);
        }


    }

    public  void askQuit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit Quiz? All unsaved progress will be lost.");
        builder.setPositiveButton("STAY HERE", null);
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                stopServiceOne();
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
                textViewQuestion.setText(currentQuestion.getSolution());
                break;
            case 2:
                mRadioButton2.setTextColor(Color.GREEN);
                textViewQuestion.setText(currentQuestion.getSolution());
                break;
            case 3:
                mRadioButton3.setTextColor(Color.GREEN);
                textViewQuestion.setText(currentQuestion.getSolution());
                break;
            case 4:
                mRadioButton4.setTextColor(Color.GREEN);
                textViewQuestion.setText(currentQuestion.getSolution());
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
        if (score >= 7 && score < 9) {

            SharedPreferences prefSilver = getSharedPreferences(SHARED_PREF_SILVER, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefSilver.edit();
            editor.putInt(KEY_HIGHSCORE, 1).apply();
        }
        else if(score >= 9){
            SharedPreferences prefGold =getSharedPreferences(SHARED_PREF_GOLD, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefGold.edit();
            editor.putInt(KEY_HIGHSCORE, 1).apply();

        }
        else if (score >= 5 && score < 7){
            SharedPreferences prefBronze = getSharedPreferences(SHARED_PREF_Bronze, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefBronze.edit();
            editor.putInt(KEY_HIGHSCORE, 1).apply();
        }
        Intent resultIntent = new Intent();

        resultIntent.putExtra(EXTRA_SCORE,score);
        setResult(RESULT_OK,resultIntent);
        finish();
    }

    public void showScoreAlert(int scores){

        String x = String.valueOf(scores);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishQuiz();
            }

        });

        builder.setMessage("You've answered " + x +" correct questions out of 10. Your score is " + x +" /10");
        builder.show();

    }

    public void makeSnackBar(int message, int turnOff, final int message2) {
        startServiceOne();
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
                .setAction(turnOff, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        stopServiceOne();

                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, message2, Snackbar.LENGTH_SHORT);

                        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("On_Off", true).commit();

                        //changing the collor of the text inside snack bar 1
                        View sbView = snackbar1.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.RED);
                        snackbar1.show();
                    }

                });

        //changing the color of the text inside snack bar
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.GREEN);

        snackbar.show();
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
    protected void onResume() {
        super.onResume();
        makeSnackBar(R.string.snackbar, R.string.turnOff1, R.string.background);

    }

    public void makeSnackbar1(int message) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        //changing the collor of the text inside snack bar 1
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        snackbar.show();

    }

    public void makeSnackbar2(int message) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        //changing the collor of the text inside snack bar 1
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.GREEN);
        snackbar.show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        stopServiceOne();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    // play background music from intent
    public void startServiceOne() {
        startService(new Intent(this, MusicService.class));
    }

    // stop background Music
    public void stopServiceOne() {
        stopService(new Intent(this, MusicService.class));
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

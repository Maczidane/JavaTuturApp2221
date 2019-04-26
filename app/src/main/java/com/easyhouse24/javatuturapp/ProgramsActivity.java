package com.easyhouse24.javatuturapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;

import io.github.kbiakov.codeview.classifier.CodeProcessor;


public class ProgramsActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private FrameLayout frameLayout;


    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;


    private Toolbar toolbar;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    private ExpandableCardView cardView1;
    private ExpandableCardView cardView2;
    private ExpandableCardView cardView3;
    private ExpandableCardView cardView4;
    private ExpandableCardView cardView5;
    private ExpandableCardView cardView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);





        cardView1 = findViewById(R.id.program_1_card);
        cardView2 = findViewById(R.id.program_2_card);
        cardView3 = findViewById(R.id.program_3_card);
        cardView4 = findViewById(R.id.program_4_card);
        cardView5 = findViewById(R.id.program_5_card);
        cardView6 = findViewById(R.id.program_6_card);


        button1 = (Button) findViewById(R.id.see_1);
        button2 = (Button) findViewById(R.id.see_2);
        button3 = (Button) findViewById(R.id.see_3);
        button4 = (Button) findViewById(R.id.see_4);
        button5 = (Button) findViewById(R.id.see_5);
        button6 = (Button) findViewById(R.id.see_6);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openProgram_1();



            }
        });

        Boolean QuizFirst = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("QuizFirst2", true);

        if(QuizFirst)
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setPositiveButton("Get App", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callShare();
                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("QuizFirst2", false).apply();
                }
            });
            alert.setNegativeButton("Leave It", null);

            alert.setMessage("Here you can view the source codes to some of our sample programs. To see the program run , you can copy the codes an paste in an IDE. We recommended and IDE for you. Do you want to download IDE now ?");
            alert.show();

        }


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Program_2_Activity.class);

                startActivity(i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Program_3_Activity.class);

                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Program_4_Activity.class);

                startActivity(i);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Program_5_Activity.class);

                startActivity(i);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Program_6_Activity.class);

                startActivity(i);
            }
        });




        toolbar = (Toolbar) findViewById(R.id.toolbar_programs);
        toolbar.setTitle("Sample Programs");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    public void callShare() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);


        //Copy App URL from Google Play Store.
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.duy.compiler.javanide"));

        startActivity(intent);

    }

    public void hanRun(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                openProgram_1();
            }
        };

        Handler han = new Handler();
        han.postDelayed(run,2000);
    }

    private void progressDialogue(){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait........");
        progressDialog.show();
    }

    private void openProgram_1(){
        Intent i = new Intent(getApplicationContext(), Program_1_Activity.class);

        startActivity(i);
    }


}

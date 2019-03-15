package com.easyhouse24.javatuturapp;


import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdvancedFragment extends Fragment {



    private CardView mCardViewAdvanced_1;
    private CardView mCardViewAdvanced_2;

    private CardView mCardViewAdvanced_3;

    private CardView mCardViewAdvanced_4;
    private CardView mCardViewAdvanced_5;

    private CardView mCardViewAdvanced_6;


    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    private ProgressBar progressBar;


    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;




    public AdvancedFragment() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advanced, container, false);


        mCardViewAdvanced_1 = (CardView) view.findViewById(R.id.CardViewAdvanced_1);
        mCardViewAdvanced_2 = (CardView) view.findViewById(R.id.CardViewAdvanced_2);
        mCardViewAdvanced_3 = (CardView) view.findViewById(R.id.CardViewAdvanced_3);
        mCardViewAdvanced_4 = (CardView) view.findViewById(R.id.CardViewAdvanced_4);
        mCardViewAdvanced_5 = (CardView) view.findViewById(R.id.CardViewAdvanced_5);
        mCardViewAdvanced_6 = (CardView) view.findViewById(R.id.CardViewAdvanced_6);

        progressBar = (ProgressBar) view.findViewById(R.id.progress_horizontal_advanced);


        textView1 = (TextView) view.findViewById(R.id.textViewAdvanced_1);
        textView2 = (TextView) view.findViewById(R.id.textViewAdvanced_2);
        textView3 = (TextView) view.findViewById(R.id.textViewAdvanced_3);
        textView4 = (TextView) view.findViewById(R.id.textViewAdvanced_4);
        textView5 = (TextView) view.findViewById(R.id.textAdvanced_5);
        textView6 = (TextView) view.findViewById(R.id.textViewAdvanced_6);

        checkBox1 = (CheckBox) view.findViewById(R.id.box_date);
        checkBox2 = (CheckBox) view.findViewById(R.id.box_objects);
        checkBox3 = (CheckBox) view.findViewById(R.id.box_constructors);
        checkBox4 = (CheckBox) view.findViewById(R.id.box_modifiers);
        checkBox5 = (CheckBox) view.findViewById(R.id.box_decision);
        checkBox6 = (CheckBox) view.findViewById(R.id.box_regular);


        mCardViewAdvanced_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Date");
                startActivity(i);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Date");
                startActivity(i);
            }
        });

        mCardViewAdvanced_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Objects");
                startActivity(i);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Objects");
                startActivity(i);
            }
        });

        mCardViewAdvanced_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Constructors");
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Constructors");
                startActivity(i);
            }
        });

        mCardViewAdvanced_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Modifiers");
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Modifiers");
                startActivity(i);
            }
        });

        mCardViewAdvanced_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Decision");
                startActivity(i);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Decision");
                startActivity(i);
            }
        });

        mCardViewAdvanced_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Regular");
                startActivity(i);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Regular");
                startActivity(i);
            }
        });




        String prefAdvanced = getActivity().getSharedPreferences("IS_ACCEPTED", MODE_PRIVATE).getString("X_NUMBER", null);

        double x = 16.6666666667;
        double y = x + 5.444444445;
        progressBar.setMax(100);
        progressBar.setMin(0);


        if (prefAdvanced != null) {
            int pref = Integer.valueOf(prefAdvanced);
            if (pref == 11) {
                int i = (int) x;
                int z = (int) y;
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);
                checkBox1.setChecked(true);
                //Disabling checkbox after being checked
                checkBox1.setEnabled(false);

            }

            if (pref == 12) {

                int i = (int) (x * 2);
                int z = (int) (y * 2);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);
                //Checking the check box
                checkBox1.setChecked(true);
                //Disabling checkbox after being checked
                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);
                //Disabling checkbox after being checked
                checkBox2.setEnabled(false);
            }
            if (pref == 13) {
                int i = (int) (x * 3);
                int z = (int) (y * 3);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox1.setChecked(true);
                //Disabling checkbox after being checked
                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);
                //Disabling checkbox after being checked
                checkBox2.setEnabled(false);
                checkBox3.setChecked(true);
                //Disabling checkbox after being checked
                checkBox3.setEnabled(false);
            }
            if (pref == 14) {
                int i = (int) (x * 4);
                int z = (int) (y * 4);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox4.setChecked(true);

                checkBox4.setEnabled(false);
                checkBox1.setChecked(true);

                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);

                checkBox2.setEnabled(false);
                checkBox3.setChecked(true);

                checkBox3.setEnabled(false);
                checkBox4.setChecked(true);

                checkBox4.setEnabled(false);
            }
            if (pref == 15) {
                int i = (int) (x * 5);
                int z = (int) (y * 5);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);


                checkBox1.setChecked(true);

                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);

                checkBox2.setEnabled(false);
                checkBox3.setChecked(true);

                checkBox3.setEnabled(false);
                checkBox4.setChecked(true);

                checkBox4.setEnabled(false);

                checkBox5.setChecked(true);

                checkBox5.setEnabled(false);
            }
            if (pref == 16) {
                int i = (int) (x * 6);
                int z = (int) (y * 6);
                progressBar.incrementProgressBy(i);
                //progressBar.setSecondaryProgress(z);

                checkBox1.setChecked(true);

                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);

                checkBox2.setEnabled(false);
                checkBox3.setChecked(true);

                checkBox3.setEnabled(false);
                checkBox4.setChecked(true);

                checkBox4.setEnabled(false);
                checkBox5.setChecked(true);

                checkBox5.setEnabled(false);
                checkBox6.setChecked(true);

                checkBox6.setEnabled(false);
            }

        }

            return view;

        }

    }
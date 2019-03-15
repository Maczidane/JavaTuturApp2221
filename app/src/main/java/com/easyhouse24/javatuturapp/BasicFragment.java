package com.easyhouse24.javatuturapp;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BasicFragment extends Fragment {

    private CardView mCardViewBasic_into;

    private CardView mCardViewBasic_1;
    private CardView mCardViewBasic_2;

    private CardView mCardViewBasic_3;

    private CardView mCardViewBasic_4;
    private CardView mCardViewBasic_5;

    private CardView mCardViewBasic_6;
    private CardView mCardViewBasic_7;

    private CardView mCardViewBasic_8;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textViewIntro;

    private ProgressBar progressBar;

    private CheckBox checkBox;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;


    public BasicFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progress_horizontal);

        mCardViewBasic_into = (CardView) view.findViewById(R.id.CardViewBasic_intro);
        mCardViewBasic_1 = (CardView) view.findViewById(R.id.CardViewBasic_1);
        mCardViewBasic_2 = (CardView) view.findViewById(R.id.CardViewBasic_2);
        mCardViewBasic_3 = (CardView) view.findViewById(R.id.CardViewBasic_3);
        mCardViewBasic_4 = (CardView) view.findViewById(R.id.CardViewBasic_4);
        mCardViewBasic_5 = (CardView) view.findViewById(R.id.CardViewBasic_5);
        mCardViewBasic_6 = (CardView) view.findViewById(R.id.CardViewBasic_6);
        mCardViewBasic_7 = (CardView) view.findViewById(R.id.CardViewBasic_7);
        mCardViewBasic_8 = (CardView) view.findViewById(R.id.CardViewBasic_8);

        checkBox = (CheckBox) view.findViewById(R.id.box_introduction);
        checkBox1 = (CheckBox) view.findViewById(R.id.box_syntax);
        checkBox2 = (CheckBox) view.findViewById(R.id.box_variables);
        checkBox3 = (CheckBox) view.findViewById(R.id.box_basic_data);
        checkBox4 = (CheckBox) view.findViewById(R.id.box_numbers);
        checkBox5 = (CheckBox) view.findViewById(R.id.box_characters);
        checkBox6 = (CheckBox) view.findViewById(R.id.box_strings);
        checkBox7 = (CheckBox) view.findViewById(R.id.box_loops);
        checkBox8 = (CheckBox) view.findViewById(R.id.box_arrays);


        textView1 = (TextView) view.findViewById(R.id.textViewBasic_1);
        textView2 = (TextView) view.findViewById(R.id.textViewBasic_2);
        textView3 = (TextView) view.findViewById(R.id.textViewBasic_3);
        textView4 = (TextView) view.findViewById(R.id.textViewBasic_4);
        textView5 = (TextView) view.findViewById(R.id.textViewBasic_5);
        textView6 = (TextView) view.findViewById(R.id.textViewBasic_6);
        textView7 = (TextView) view.findViewById(R.id.textViewBasic_7);
        textView8 = (TextView) view.findViewById(R.id.textViewBasic_8);
        textViewIntro = (TextView) view.findViewById(R.id.textViewBasic_intro);

        final String prefAdvanced = getActivity().getSharedPreferences("IS_ACCEPTED", MODE_PRIVATE).getString("X_NUMBER", null);

        double x = 5.555555559;
        double y = x + 2.444444445;
        progressBar.setMax(100);
        progressBar.setMin(0);


        if (prefAdvanced != null) {
            int pref = Integer.valueOf(prefAdvanced);
            if (pref == 1) {
                int i = (int) x;
                int z = (int) y;
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);
                checkBox.setChecked(true);
                //Disabling checkbox after being checked
                checkBox.setEnabled(false);

            }

            if (pref == 2) {

                int i = (int) (x * 4);
                int z = (int) (y * 4);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);
                //Checking the check box
                checkBox.setChecked(true);
                //Disabling checkbox after being checked
                checkBox.setEnabled(false);
                checkBox1.setChecked(true);
                //Disabling checkbox after being checked
                checkBox1.setEnabled(false);
            }
            if (pref == 3) {
                int i = (int) (x * 6);
                int z = (int) (y * 6);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);
                //Disabling checkbox after being checked
                checkBox.setEnabled(false);
                checkBox1.setChecked(true);
                //Disabling checkbox after being checked
                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);
                //Disabling checkbox after being checked
                checkBox2.setEnabled(false);
            }
            if (pref == 4) {
                int i = (int) (x * 8);
                int z = (int) (y * 8);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);

                checkBox.setEnabled(false);
                checkBox1.setChecked(true);

                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);

                checkBox2.setEnabled(false);
                checkBox3.setChecked(true);

                checkBox3.setEnabled(false);
            }
            if (pref == 5) {
                int i = (int) (x * 10);
                int z = (int) (y * 10);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);

                checkBox.setEnabled(false);
                checkBox1.setChecked(true);

                checkBox1.setEnabled(false);
                checkBox2.setChecked(true);

                checkBox2.setEnabled(false);
                checkBox3.setChecked(true);

                checkBox3.setEnabled(false);
                checkBox4.setChecked(true);

                checkBox4.setEnabled(false);
            }
            if (pref == 6) {
                int i = (int) (x * 12);
                int z = (int) (y * 12);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);

                checkBox.setEnabled(false);
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
            if (pref == 7) {
                int i = (int) (x * 14);
                int z = (int) (y * 14);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);

                checkBox.setEnabled(false);
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
            if (pref == 8) {
                int i = (int) (x * 16);
                int z = (int) (y * 16);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);

                checkBox.setEnabled(false);
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
                checkBox7.setChecked(true);

                checkBox7.setEnabled(false);
            }
            if (pref == 9) {
                int i = (int) (x * 18);
                int z = (int) (y * 18);
                progressBar.incrementProgressBy(i);
                progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);

                checkBox.setEnabled(false);
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
                checkBox7.setChecked(true);

                checkBox7.setEnabled(false);

            }

            if (pref == 10) {
                int i = (int) (x * 20);
                int z = (int) (y * 20);
                progressBar.incrementProgressBy(i);
               // progressBar.setSecondaryProgress(z);

                checkBox.setChecked(true);

                checkBox.setEnabled(false);
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
                checkBox7.setChecked(true);

                checkBox7.setEnabled(false);
                checkBox8.setChecked(true);

                checkBox8.setEnabled(false);


            }


        }


        mCardViewBasic_into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Introduction");
                startActivity(i);
            }
        });

        textViewIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent i = new Intent(getContext(), TutorialActivity.class);
                    i.putExtra("Fragment", "Introduction");
                    startActivity(i);

            }
        });

        mCardViewBasic_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Basic Syntax");
                startActivity(i);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Basic Syntax");
                startActivity(i);
            }
        });

        mCardViewBasic_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Variables");
                startActivity(i);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Variables");
                startActivity(i);
            }
        });

        mCardViewBasic_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Data types");
                startActivity(i);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Data types");
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Numbers");
                startActivity(i);
            }
        });
        mCardViewBasic_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Numbers");
                startActivity(i);
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Characters");
                startActivity(i);
            }
        });

        mCardViewBasic_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Characters");
                startActivity(i);
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "String");
                startActivity(i);
            }
        });

        mCardViewBasic_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "String");
                startActivity(i);
            }
        });
        mCardViewBasic_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Loops");
                startActivity(i);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Loops");
                startActivity(i);
            }
        });

        mCardViewBasic_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Arrays");
                startActivity(i);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TutorialActivity.class);
                i.putExtra("Fragment", "Arrays");
                startActivity(i);
            }
        });

        return view;
    }

}

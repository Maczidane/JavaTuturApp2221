package com.easyhouse24.javatuturapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetSelectFragment extends Fragment {

    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;
    private CardView cardView5;
    private CardView cardView6;
    private CardView cardView7;
    private CardView cardView8;
    private CardView cardView9;

    private QuestionFragment questionFragment;


    private TextView textView1;
    private TextView textView2;
    private TextView textView4;
    private TextView textView3;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;



    public SetSelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_set_select, container, false);

        cardView1 = (CardView) view.findViewById(R.id.CardViewBasic_1);
        cardView2 = (CardView) view.findViewById(R.id.CardViewBasic_2);
        cardView3 = (CardView) view.findViewById(R.id.CardViewBasic_3);
        cardView4= (CardView) view.findViewById(R.id.CardViewBasic_4);
        cardView5 = (CardView) view.findViewById(R.id.CardViewBasic_5);
        cardView6 = (CardView) view.findViewById(R.id.CardViewBasic_6);
        cardView7 = (CardView) view.findViewById(R.id.CardViewBasic_7);
        cardView8 = (CardView) view.findViewById(R.id.CardViewBasic_8);
        cardView9 = (CardView) view.findViewById(R.id.CardViewBasic_9);

        textView1 = (TextView) view.findViewById(R.id.textViewBasic_1);
        textView2 = (TextView) view.findViewById(R.id.textViewBasic_2);
        textView4 = (TextView) view.findViewById(R.id.textViewBasic_4);
        textView3 = (TextView) view.findViewById(R.id.textViewBasic_3);
        textView5 = (TextView) view.findViewById(R.id.textViewBasic_5);
        textView6= (TextView) view.findViewById(R.id.textViewBasic_6);
        textView7 = (TextView) view.findViewById(R.id.textViewBasic_7);
        textView8 = (TextView) view.findViewById(R.id.textViewBasic_8);
        textView9 = (TextView) view.findViewById(R.id.textViewBasic_9);

        questionFragment = new QuestionFragment();


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set1");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set1");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set2");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set2");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set3");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set3");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set4");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set4");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set5");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set5");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });


        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set6");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set6");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set7");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set7");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set8");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set8");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });

        cardView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set9");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();

            }
        });

        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putDifficulty("set9");
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, questionFragment, "NewFragmentTag");
                ft.commit();
            }
        });






        return view;
    }

    public void putDifficulty(String number)
    {
        SharedPreferences pref = getActivity().getSharedPreferences("IS_DIFFICULTY", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("X_DIFFICULTY", number);
        editor.apply();
    }

}

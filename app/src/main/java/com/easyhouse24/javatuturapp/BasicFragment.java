package com.easyhouse24.javatuturapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


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


    public BasicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic, container, false);

        mCardViewBasic_into = (CardView) view.findViewById(R.id.CardViewBasic_intro);
        mCardViewBasic_1 = (CardView) view.findViewById(R.id.CardViewBasic_1);
        mCardViewBasic_2 = (CardView) view.findViewById(R.id.CardViewBasic_2);
        mCardViewBasic_3 = (CardView) view.findViewById(R.id.CardViewBasic_3);
        mCardViewBasic_4 = (CardView) view.findViewById(R.id.CardViewBasic_4);
        mCardViewBasic_5 = (CardView) view.findViewById(R.id.CardViewBasic_5);
        mCardViewBasic_6 = (CardView) view.findViewById(R.id.CardViewBasic_6);
        mCardViewBasic_7 = (CardView) view.findViewById(R.id.CardViewBasic_7);
        mCardViewBasic_8 = (CardView) view.findViewById(R.id.CardViewBasic_8);

        textView1 = (TextView) view.findViewById(R.id.textViewBasic_1);
        textView2 = (TextView) view.findViewById(R.id.textViewBasic_2);
        textView3 = (TextView) view.findViewById(R.id.textViewBasic_3);
        textView4 = (TextView) view.findViewById(R.id.textViewBasic_4);
        textView5 = (TextView) view.findViewById(R.id.textViewBasic_5);
        textView6 = (TextView) view.findViewById(R.id.textViewBasic_6);
        textView7 = (TextView) view.findViewById(R.id.textViewBasic_7);
        textView8 = (TextView) view.findViewById(R.id.textViewBasic_8);
        textViewIntro = (TextView) view.findViewById(R.id.textViewBasic_intro);


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


        return view;
    }

}

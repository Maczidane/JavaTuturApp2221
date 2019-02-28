package com.easyhouse24.javatuturapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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



    public AdvancedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_advanced, container, false);


        mCardViewAdvanced_1 = (CardView) view.findViewById(R.id.CardViewAdvanced_1);
        mCardViewAdvanced_2 = (CardView) view.findViewById(R.id.CardViewAdvanced_2);
        mCardViewAdvanced_3 = (CardView) view.findViewById(R.id.CardViewAdvanced_3);
        mCardViewAdvanced_4 = (CardView) view.findViewById(R.id.CardViewAdvanced_4);
        mCardViewAdvanced_5 = (CardView) view.findViewById(R.id.CardViewAdvanced_5);
        mCardViewAdvanced_6 = (CardView) view.findViewById(R.id.CardViewAdvanced_6);


        textView1 = (TextView) view.findViewById(R.id.textViewAdvanced_1);
        textView2 = (TextView) view.findViewById(R.id.textViewAdvanced_2);
        textView3 = (TextView) view.findViewById(R.id.textViewAdvanced_3);
        textView4 = (TextView) view.findViewById(R.id.textViewAdvanced_4);
        textView5 = (TextView) view.findViewById(R.id.textAdvanced_5);
        textView6 = (TextView) view.findViewById(R.id.textViewAdvanced_6);

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


        return view;
    }

}

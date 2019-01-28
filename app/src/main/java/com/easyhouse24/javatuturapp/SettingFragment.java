package com.easyhouse24.javatuturapp;


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
public class SettingFragment extends Fragment {
    private TextView mTextViewLogout;
    private TextView mTextViewHelp;
    private TextView mTextViewContact;
    private TextView mTextViewTerms;

    private CardView mCardViewContact;
    private CardView mCardViewHelp;
    private CardView mCardViewLogout;
    private CardView mCardViewTerms;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_setting, container, false);

        mTextViewLogout = (TextView) view.findViewById(R.id.textViewExit);
        mTextViewHelp = (TextView) view.findViewById(R.id.textViewHelp);
        mTextViewContact = (TextView) view.findViewById(R.id.textViewContact);
        mTextViewTerms = (TextView) view.findViewById(R.id.textViewTerms);

        mCardViewLogout = (CardView)view.findViewById(R.id.CardViewExit);
        mCardViewHelp = (CardView)view.findViewById(R.id.CardViewHelp);
        mCardViewTerms = (CardView)view.findViewById(R.id.CardViewTerms);
        mCardViewContact = (CardView)view.findViewById(R.id.CardViewContact);




        mTextViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        mCardViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }

}

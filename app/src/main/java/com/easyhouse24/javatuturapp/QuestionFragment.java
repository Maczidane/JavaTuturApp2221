package com.easyhouse24.javatuturapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
    public class QuestionFragment extends Fragment {

        private Button mButton;

        public QuestionFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v =  inflater.inflate(R.layout.fragment_question, container, false);

            mButton = (Button) v.findViewById(R.id.btn_start_quiz);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getContext(), QuizActivity.class);
                    startActivity(i);
                }
            });
            return  v;
        }

}

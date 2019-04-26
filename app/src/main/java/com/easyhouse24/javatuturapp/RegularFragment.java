package com.easyhouse24.javatuturapp;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegularFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;

    private DecisionFragment decisionFragment;




    public RegularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_regular, container, false);
        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.nav_tutorial_regular);

        bottomNavigationView.setSelectedItemId(R.id.tutorial_next);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.tutorial_next:

                        String prefAdvanced = getActivity().getSharedPreferences("IS_ACCEPTED", MODE_PRIVATE).getString("X_NUMBER", null);

                        int pref1 = Integer.valueOf(prefAdvanced);
                        if ( 16 > pref1) {

                            SharedPreferences pref = getActivity().getSharedPreferences("IS_ACCEPTED", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("X_NUMBER", "16");
                            editor.commit();
                        }


                       showSelectionTab();

                        //Toast.makeText(getContext(),"Still to continue filling tutorials",Toast.LENGTH_LONG).show();
                        break;


                    case  R.id.tutorial_back:
                        decisionFragment = new DecisionFragment();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame_tutorial, decisionFragment, "NewFragmentTag");
                        ft.commit();



                        break;
                }
                return false;
            }
        });

        return view;
    }

    public void askChange(){
        AlertDialog.Builder  builder = new AlertDialog.Builder(getContext());

        builder.setCancelable(false);
        builder.setMessage("Congratulations, you have finished the Advanced section Tutorials.You've been awarded a trophy. Move to : ");



        builder.setPositiveButton("Stay here ",null);

        builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getContext(),StartActivity.class);
                startActivity(i);
            }
        });

        builder.setIcon(R.drawable.ic_stars_black_24dp);

        builder.show();

    }


    public void showSelectionTab(){
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setMessage("Congratulations, you have finished learning our tutorials. Do you which to answer questions related to what you have learned in the previous topics?");
        alert.setNegativeButton("Answer Questions", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                QuestionFragment questionFragment;
                questionFragment = new QuestionFragment();
                putDifficulty("set6");
                Intent v = new Intent(getContext(),Main2Activity.class);
                startActivity(v);
            }
        });

        alert.setPositiveButton("Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent f = new Intent(getActivity(), StartActivity.class);
                startActivity(f);
            }
        });

        alert.setIcon(R.drawable.ic_add_alert_black_24dp);
        alert.show();
    }

    public void putDifficulty(String number)
    {
        SharedPreferences pref = getActivity().getSharedPreferences("IS_DIFFICULTY", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("X_DIFFICULTY", number);
        editor.apply();
    }


}
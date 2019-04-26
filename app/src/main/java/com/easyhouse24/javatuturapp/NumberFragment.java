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
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;

    private DataTypesFragment dataTypesFragment;

    private CharactersFragment charactersFragment;
    ;

    public NumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_number, container, false);


        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.nav_tutorial_numbers);
        bottomNavigationView.setSelectedItemId(R.id.tutorial_next);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.tutorial_next:
                        String prefAdvanced = getActivity().getSharedPreferences("IS_ACCEPTED", MODE_PRIVATE).getString("X_NUMBER", null);

                        if (prefAdvanced == null) {
                            Toast.makeText(getContext(), "Please read Introduction First", Toast.LENGTH_LONG).show();
                            return false;

                        } else {
                            int pref1 = Integer.valueOf(prefAdvanced);
                            if (6 > pref1) {
                                SharedPreferences pref = getActivity().getSharedPreferences("IS_ACCEPTED", Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("X_NUMBER", "6");
                                editor.commit();
                            }

                           showSelectionTab();

                            break;
                        }


                    case R.id.tutorial_back:
                        dataTypesFragment = new DataTypesFragment();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame_tutorial, dataTypesFragment, "NewFragmentTag");
                        ft.commit();
                        break;

                }
                return false;
            }
        });

        return view;
    }

    public void showSelectionTab(){
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        alert.setMessage("Do you which to answer questions related to what you have learned in the previous topics?");
        alert.setNegativeButton("Answer Questions", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                putDifficulty("set1");
                Intent v = new Intent(getContext(),Main2Activity.class);
                startActivity(v);


            }
        });

        alert.setPositiveButton("Continue ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                charactersFragment = new CharactersFragment();
                final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.frame_tutorial, charactersFragment, "NewFragmentTag");
                ft1.commit();
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

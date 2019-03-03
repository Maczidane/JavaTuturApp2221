package com.easyhouse24.javatuturapp;


import android.content.Context;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class CharactersFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;

    private NumberFragment numberFragment;


    public CharactersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_characters, container, false);

        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.nav_tutorial_character);

        bottomNavigationView.setSelectedItemId(R.id.tutorial_next);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.tutorial_next:

                        SharedPreferences pref = getActivity().getSharedPreferences("IS_ACCEPTED", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("X_NUMBER","7");
                        editor.commit();

                        Toast.makeText(getContext(),"Still to continue filling tutorials",Toast.LENGTH_LONG).show();
                        break;


                    case  R.id.tutorial_back:
                        numberFragment = new NumberFragment();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame_tutorial, numberFragment, "NewFragmentTag");
                        ft.commit();



                        break;
                }
                return false;
            }
        });

        return view;
    }

}

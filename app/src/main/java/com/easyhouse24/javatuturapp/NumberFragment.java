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
                        SharedPreferences pref = getActivity().getSharedPreferences("IS_ACCEPTED", Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("X_NUMBER", "6");
                        editor.commit();

                        charactersFragment = new CharactersFragment();
                        final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                        ft1.replace(R.id.frame_tutorial, charactersFragment, "NewFragmentTag");
                        ft1.commit();
                        break;


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

}

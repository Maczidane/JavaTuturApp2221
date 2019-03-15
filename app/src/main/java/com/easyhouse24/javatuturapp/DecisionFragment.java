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

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DecisionFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;

    private RegularFragment regularFragment;

    private ModifiersFragment modifiersFragment;


    public DecisionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_decision, container, false);

        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.nav_tutorial_decision);

        bottomNavigationView.setSelectedItemId(R.id.tutorial_next);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.tutorial_next:

                        String prefAdvanced = getActivity().getSharedPreferences("IS_ACCEPTED", MODE_PRIVATE).getString("X_NUMBER", null);

                        int pref1 = Integer.valueOf(prefAdvanced);
                        if ( 15 > pref1) {

                            SharedPreferences pref = getActivity().getSharedPreferences("IS_ACCEPTED", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("X_NUMBER", "15");
                            editor.commit();
                        }

                        regularFragment = new RegularFragment();
                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame_tutorial, regularFragment, "NewFragmentTag");
                        ft.commit();



                        //Toast.makeText(getContext(),"Still to continue filling tutorials",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.tutorial_back:
                        modifiersFragment = new ModifiersFragment();
                        final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                        ft1.replace(R.id.frame_tutorial, modifiersFragment, "NewFragmentTag");
                        ft1.commit();
                        break;




                }
                return false;
            }
        });

        return view;
    }

}

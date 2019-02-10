package com.easyhouse24.javatuturapp;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BasicSyntaxFragment extends Fragment {

    private BasicSyntaxFragment basicSyntaxFragment;

    private IntroFragment introFragment;


    private BottomNavigationView bottomNavigationView;



    public BasicSyntaxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_basic_syntax, container, false);

        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.nav_tutorial);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.tutorial_next:

                        //This code is to replace a fragment with another fragment from a fragment
                        Toast.makeText(getContext(),"TODO: Still to continue the development of this section",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.nav_back:
                        introFragment = new IntroFragment();
                        final FragmentTransaction ftt = getFragmentManager().beginTransaction();
                        ftt.replace(R.id.frame_tutorial, introFragment, "NewFragmentTag");
                        ftt.commit();
                        break;

                }
                return false;
            }
        });







       return view;
    }

}

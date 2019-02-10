package com.easyhouse24.javatuturapp;


import android.os.Build;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {

    private BasicSyntaxFragment basicSyntaxFragment;

    private FrameLayout frameLayout;

    private NestedScrollView nestedScrollView;
    private BottomNavigationView bottomNavigationView;


    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_intro, container, false);

       bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.nav_tutorial);

       nestedScrollView = (NestedScrollView) view.findViewById(R.id.intro_scroll);



        bottomNavigationView.setSelectedItemId(R.id.tutorial_next);

       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

               switch (menuItem.getItemId())
               {
                   case R.id.tutorial_next:

                       //This code is to replace a fragment with another fragment from a fragment
                       basicSyntaxFragment = new BasicSyntaxFragment();
                       final FragmentTransaction ft = getFragmentManager().beginTransaction();
                       ft.replace(R.id.frame_tutorial, basicSyntaxFragment, "NewFragmentTag");
                       ft.commit();
                       break;
               }
               return false;
           }
       });

       return view;
    }

}

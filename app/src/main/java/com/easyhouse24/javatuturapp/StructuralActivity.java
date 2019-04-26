package com.easyhouse24.javatuturapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class StructuralActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structural);
        toolbar = (Toolbar)findViewById(R.id.toolbar_structural);
        setSupportActionBar(toolbar);
    }
}

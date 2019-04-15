package com.easyhouse24.javatuturapp;

import android.app.ProgressDialog;
import android.content.ClipboardManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.classifier.CodeProcessor;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class Program_3_Activity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_3_);

        hanRun();

        toolbar = (Toolbar) findViewById(R.id.toolbar_programs_3);


        //Display codes in codeView format
        codeView();



        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    private void codeView(){

        //Codes for CodeView

        // train classifier on app start
        CodeProcessor.init(this);


        CodeView codeView = (CodeView) findViewById(R.id.code_view_3);

        codeView.setOptions(Options.Default.get(this)
                .withLanguage("java")
                .withCode(R.string.listing_java_3)
                .withTheme(ColorTheme.MONOKAI));

    }



    @Override
    protected void onStart() {
        super.onStart();
        //hanRun();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //hanRun();
    }

    public void hanRun(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Getting the necessary codes........");
        progressDialog.show();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        };

        Handler han = new Handler();
        han.postDelayed(run,6000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.copy_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_copy_1:
                copyClipboard();
                createStyledToast();


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void createStyledToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void copyClipboard() {
        //this item has your app icon


        String string = getString (R.string.listing_java_3);

        // place your TextView's text in clipboard
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipboard.setText(string);


    }
}

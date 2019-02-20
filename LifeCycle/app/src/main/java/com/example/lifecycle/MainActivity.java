package com.example.lifecycle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    Button bt;

    LinearLayout myScreen;
    EditText txtMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.btExit);
        myScreen = (LinearLayout)findViewById(R.id.layout1) ;
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApp();
            }
        });

        txtMsg = (EditText  ) findViewById(R.id.txtMsg);
        txtMsg.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count , int after){
            }
            @Override
            public void onTextChanged(CharSequence s , int start, int before , int count){

            }
            @Override
            public void afterTextChanged(Editable s)
            {
                String color= s.toString().toLowerCase(Locale.US);
                changeBackground(color, myScreen);
            }
        } );

    }
        public void exitApp()
        {
        finish();
        }
        public void changeBackground(String color, LinearLayout
                myscreen)
        {
            if(color.contains("red"))
                myscreen.setBackgroundColor(Color.RED);
            if(color.contains("green"))
                myscreen.setBackgroundColor(Color.GREEN);
            if(color.contains("blue"))
                myscreen.setBackgroundColor(Color.BLUE);
            if(color.contains("white"))
                myscreen.setBackgroundColor(Color.WHITE);
        }


    @Override
    protected void onStart(){
        super.onStart();
         Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

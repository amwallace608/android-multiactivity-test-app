package com.example.quicklauncher;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //check if gets information
        if(getIntent().hasExtra("com.example.quicklauncher.someInfo")) {
            //define TextView item for textView of second activity
            TextView textView = (TextView) findViewById(R.id.textView);
            //get string from extra info passed from main activity
            String text = getIntent().getExtras().getString("com.example.quicklauncher.someInfo");
            //set textView of second activity to string passed from main activity
            textView.setText(text);
        }

    }
}

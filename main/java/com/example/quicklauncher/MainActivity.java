package com.example.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //define buttons
        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        //define onClickListeners for each button
        //Launch a second activity within the app
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create new Intent for second activity class
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                //how to pass info to another activity, use key value pairs for putExtra()
                startIntent.putExtra("com.example.quicklauncher.someInfo", "Howdy");
                //start Activity with Intent created for second activity
                startActivity(startIntent);
            }
        });
        //launch an activity outside the app (google)
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set up address to go to
                String google = "http://www.google.com";
                //parse address from string to Uri
                Uri webAddress = Uri.parse(google);
                //setup intent Action view to go to google, broadcasts to apps need web address opened
                Intent gotoGoogle = new Intent (Intent.ACTION_VIEW, webAddress);
                //check response from request, make sure it's not null, then start activity
                if(gotoGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}

package com.ams.planindia.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.ams.planindia.R;


public class MainActivity extends Activity {


    Button SignUp;
    private ProgressBar progress_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignUp = findViewById(R.id.signUpBtn);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), com.ams.planindia.Activities.SignUp.class);
                startActivity(i);

            }
        });


    }





}


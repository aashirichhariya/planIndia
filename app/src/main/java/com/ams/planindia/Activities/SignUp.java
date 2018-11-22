package com.ams.planindia.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.ams.planindia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends Activity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button sign_up_button;
    private EditText username_text;
    private EditText pass_text;
    private EditText confirm_pass_text;
    private Spinner gender;
    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_up_layout);
        //Buttons
        sign_up_button = findViewById(R.id.button);
        // Edit Text
        username_text = findViewById(R.id.login);
        pass_text = findViewById(R.id.pass);
        firebaseAuth = FirebaseAuth.getInstance();
        progress_bar = new ProgressBar(this);
        sign_up_button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == sign_up_button) {

            signUp();

        }
    }

    private void signUp() {

        String email = username_text.getText().toString().trim();
        String password = pass_text.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Username Empty", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(password)) {

            Toast.makeText(this, "Password Empty", Toast.LENGTH_SHORT).show();
            return;
        }else{
            progress_bar.setVisibility(View.VISIBLE);

            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){

                           progress_bar.setVisibility(View.GONE);




                       }else{
                           Log.v("checkResult","Not Successful");



                       }
                        }
                    });

        }

    }
}

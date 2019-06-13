package com.example.coder_kun.simplechat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button signupbtnlog;
    private Button loginbtnlog;
    private Button vipbtn;
    private EditText emailtextlog;
    private EditText pwtextlog;
    private ProgressDialog progloglog;

    private FirebaseAuth firebaseauthent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progloglog = new ProgressDialog(this);

        loginbtnlog = (Button) findViewById(R.id.loginbtnlog);
        signupbtnlog = (Button) findViewById(R.id.signupbtnlog);
        vipbtn =(Button) findViewById(R.id.vipbtn);
        emailtextlog = (EditText) findViewById(R.id.emailtextlog);
        pwtextlog = (EditText) findViewById(R.id.pwtextlog);

        firebaseauthent = FirebaseAuth.getInstance();

        if (firebaseauthent.getCurrentUser() !=null)
        {
            //start home screen activity
        }
        signupbtnlog.setOnClickListener(this);
        loginbtnlog.setOnClickListener(this);
        vipbtn.setOnClickListener(this);
    }
    public void toReg()
    {
        Intent intent = new Intent(LoginActivity.this, RegActivity.class);
        startActivity(intent);
    }
    private void login(){
        String emaillog = emailtextlog.getText().toString().trim();
        String pwlog = pwtextlog.getText().toString().trim();

        if (TextUtils.isEmpty(emaillog)) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwlog)) {
            Toast.makeText(this, "please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }
        progloglog.setMessage("Gimme a sec plx ..");
        progloglog.show();

        firebaseauthent.signInWithEmailAndPassword(emaillog,pwlog).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progloglog.dismiss();
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Logged in successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else { Toast.makeText(LoginActivity.this,"Login Failed, maybe mafeesh internet", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void vip (){
        progloglog.setMessage("Gimme a sec plx ..");
        progloglog.show();

        Toast.makeText(LoginActivity.this,"Logged in successfully", Toast.LENGTH_SHORT).show();
        finish();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

        progloglog.dismiss();
    }

    @Override
    public void onClick(View v) {
        if (v == signupbtnlog) {
            toReg ();
            finish();
        }
        if (v == loginbtnlog) {
            login();
        }
        if (v == vipbtn) {
            vip();
        }
    }
}
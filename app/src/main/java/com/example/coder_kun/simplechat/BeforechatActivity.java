package com.example.coder_kun.simplechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BeforechatActivity extends AppCompatActivity implements View.OnClickListener {
    public static String chatusername = "A Lazy user";
EditText mynameisedit;
Button chatmeinbtn, chatkbtn, chatdbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforechat);

        mynameisedit = findViewById(R.id.mynameiseditid);
        chatmeinbtn = findViewById(R.id.mynameisbtn);
        chatmeinbtn.setOnClickListener(this);
        chatkbtn = findViewById(R.id.mynameiskbtn);
        chatkbtn.setOnClickListener(this);
        chatdbtn = findViewById(R.id.mynameisdbtn);
        chatdbtn.setOnClickListener(this);



    }

    public void openChat()
    {
        Intent intent = new Intent(BeforechatActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == chatmeinbtn){
            chatusername = mynameisedit.getText().toString().trim();
            if (chatusername.isEmpty()){
                chatusername = "A lazy user";
            }
        }

        if (v == chatkbtn){
            chatusername = "VIP I";
        }

        if (v == chatdbtn){
            chatusername = "VIP II";
        }

        openChat();
    }
}

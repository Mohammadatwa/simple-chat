package com.example.coder_kun.simplechat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements Gridfrag.OnFragmentInteractionListener,View.OnClickListener {

    Button opengrid;
    Button chat;
    boolean openclose = false;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opengrid = (Button)findViewById(R.id.btnoneid);
        chat = (Button)findViewById(R.id.btntid);
        opengrid.setOnClickListener(this);
        chat.setOnClickListener(this);

        linearLayout = (LinearLayout) findViewById(R.id.linearoneid);
        linearLayout.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void openbeforeChat()
    {
        Intent intent = new Intent(MainActivity.this, BeforechatActivity.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if (v == opengrid) {
            if (openclose == false) {//show grid
                linearLayout.setVisibility(View.VISIBLE);
                openclose = true;
                //       Intent intent = new Intent(MainActivity.this, EmoActivity.class);
                //         startActivity(intent);
            } else {// hide grid
                linearLayout.setVisibility(View.INVISIBLE);
                openclose = false;
            }

        }
        if(v == chat){
            openbeforeChat();

        }
    }
}

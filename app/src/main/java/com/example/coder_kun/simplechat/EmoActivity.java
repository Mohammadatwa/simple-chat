package com.example.coder_kun.simplechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EmoActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageview;
    TextView headline,body;
    Button bkbtn,sharebtn;
    int position = 0 ;

    public  String[] emoHeadlineList = {
            "Happy", "Sad", "angry", "depressed", "noob",
            "snugly", "smokey", "sleepy", "scared", "neutral",
            "worried", "lovey", "confused", "stressed", "excited"

    };

    public  String[] emobodyList = {
            "Hey i'm feeling Happy (ow)", "Hey i'm feeling Sad (ow)", "Hey i'm feeling Angry (ow)", "Hey i'm feeling Depressed (ow)", "Hey i'm feeling like i Wanna play (ow)",
            "Hey i'm feeling Snuggly (ow)", "Hey i'm feeling like i Wanna smoke (ow)", "Hey i'm feeling Sleepy (ow)", "Hey i'm feeling Scared (ow)", "Hey i'm feeling Neutral (ow)",
            "Hey i'm feeling Anxious (ow)", "Hey i'm feeling Lovey dovey (ow)", "Hey i'm feeling Confused (ow)", "Hey i'm feeling Stressed (ow)", "Hey i'm feeling Excited (ow)"
    };

    public  int[] emoimagesList = {
            R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg,
            R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg,
            R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg, R.drawable.beforchatbg
    };
    public String[] ifeelList = {
            "Hey i'm feeling Happy (ow)", "Hey i'm feeling Sad (ow)", "Hey i'm feeling Angry (ow)", "Hey i'm feeling Depressed (ow)", "Hey i'm feeling like i Wanna play (ow)",
            "Hey i'm feeling Snuggly (ow)", "Hey i'm feeling like i Wanna smoke (ow)", "Hey i'm feeling Sleepy (ow)", "Hey i'm feeling Scared (ow)", "Hey i'm feeling Neutral (ow)",
            "Hey i'm feeling Anxious (ow)", "Hey i'm feeling Lovey dovey (ow)", "Hey i'm feeling Confused (ow)", "Hey i'm feeling Stressed (ow)", "Hey i'm feeling Excited (ow)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emo);
        sharebtn = (Button) findViewById(R.id.sharebtnid);
        imageview = (ImageView) findViewById(R.id.emobgimgid);
        headline = (TextView) findViewById(R.id.emoheadtextid);
        body = (TextView) findViewById(R.id.emobodytextid);
        bkbtn = (Button) findViewById(R.id.bkbtn);
        bkbtn.setOnClickListener(this);
        sharebtn.setOnClickListener(this);
//calling bk the index from the adapter
        Intent intent = getIntent();
        position = (int) intent.getExtras().get("index");


        imageview.setImageResource(emoimagesList[position]);
        headline.setText(emoHeadlineList[position]);
        body.setText(emobodyList[position]);
    }

    @Override
    public void onClick(View v) {
        if(v == bkbtn){
            finish();
        }
        if(v == sharebtn){
            //share intent
            Intent txtIntent = new Intent(Intent.ACTION_SEND);
            txtIntent.setType("text/plain");
            // not working for some reason
            // txtIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, emoHeadlineList[position]);
            txtIntent.putExtra(Intent.EXTRA_TEXT, ifeelList[position]);
            startActivity(Intent.createChooser(txtIntent ,"Share"));
        }

    }
}

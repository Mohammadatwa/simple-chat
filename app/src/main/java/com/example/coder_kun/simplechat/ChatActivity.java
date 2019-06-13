package com.example.coder_kun.simplechat;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChatActivity extends AppCompatActivity {
    private String msgbeforesend;
    private DatabaseReference databaseReference;
    TextView chatBody;
    EditText textToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //ui
        chatBody = findViewById(R.id.textchatbodyid);
        chatBody.setMovementMethod(new ScrollingMovementMethod());
        textToSend = findViewById(R.id.chatdittxtid);


        //firebase
        //recieving data from database
        databaseReference = FirebaseDatabase.getInstance().getReference("anotherpath");
//        databaseReference.setValue("0=Did you miss me already?");
  //      databaseReference.orderByKey();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue()==null){
                    return;
                }

          //      chatBody.setText("");
                //whole array
                String[] messages = dataSnapshot.getValue().toString().split(",");
                //calling sort method
                chatBody.setText(sortTexts(messages));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
              //turn into toast
                 chatBody.setText("Error retriving data");
            }
        });

    }

    public SpannableStringBuilder  sortTexts(String[] messages) {

        Long[] arrayOfIds = new Long[messages.length];
        String[] arrayOfText = new String[messages.length];
        SpannableStringBuilder finalFinalMessage = new SpannableStringBuilder("");

        for (int i =0; i < messages.length; i ++){

            String[] finalMessage = messages[i].split("=");

            if(finalMessage.length > 1) {

                //remove {
                if (finalMessage[0].startsWith("{")) {
                    finalMessage[0] = finalMessage[0].replace("{", "");
                }
                if (finalMessage[0].contains(" ")) {
                    finalMessage[0] = finalMessage[0].replace(" ", "");
                }
                //add ids to a new array
                arrayOfIds[i] = Long.parseLong(finalMessage[0]);
            }
        }

        // sort the ids array
        long temp;
        for (int i = 0; i < arrayOfIds.length; i++) {  // i loops from 1 to 11
            for (int j = i; j > 0; j--) {        // j loops from i index to 0
                if (arrayOfIds[j] < arrayOfIds [j - 1]) {
                    temp = arrayOfIds[j];
                    arrayOfIds[j] = arrayOfIds[j - 1];
                    arrayOfIds[j - 1] = temp;
                }
            }
        }

        // sort the main array by checking if the element in it contains the element in the sorted array
        //

        for (int j = 0; j < arrayOfIds.length; j ++) {

            for (int i =0; i < messages.length; i ++) {

                if (messages[i].contains(Long.toString(arrayOfIds[j]))) {

                    String[] finalMessage = messages[i].split("=");

                    if(finalMessage.length > 1) {

                        // remove }
                        if (finalMessage[1].endsWith("}")) {
                            finalMessage[1] = finalMessage[1].replace("}", "");
                        }

                    }
                    SpannableStringBuilder msg = new SpannableStringBuilder(finalMessage[1]);
                    if(finalMessage[1].startsWith("VIP II")) {
                        ForegroundColorSpan pink = new ForegroundColorSpan(Color.rgb(166, 40, 80));
                        msg.setSpan(pink, 0, finalMessage[1].length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                    }
                    else if(finalMessage[1].startsWith("VIP I")) {
                        ForegroundColorSpan purple = new ForegroundColorSpan(Color.rgb(81, 25, 134));
                        msg.setSpan(purple, 0, finalMessage[1].length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                    }
                    else if(finalMessage[1].startsWith("A lazy user")) {
                        ForegroundColorSpan black = new ForegroundColorSpan(Color.rgb(60, 93, 60));
                        msg.setSpan(black, 0, finalMessage[1].length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
                    }
                    else if (finalMessage[1].startsWith(BeforechatActivity.chatusername)) {
                        ForegroundColorSpan green = new ForegroundColorSpan(Color.rgb(2, 1, 1));
                        msg.setSpan(green, 0, finalMessage[1].length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

                    } else {
                        ForegroundColorSpan blue = new ForegroundColorSpan(Color.BLUE);
                        msg.setSpan(blue, 0, finalMessage[1].length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

                    }
                    arrayOfText[j] = finalMessage[1];
                    finalFinalMessage = new SpannableStringBuilder().append(finalFinalMessage).append(msg).append("\n"+"\n");
                }
            }

        }

        return  finalFinalMessage;

    }

    public void sendmessage(View view) {

        msgbeforesend = textToSend.getText().toString();
        if(msgbeforesend.contains("=")){
            msgbeforesend=msgbeforesend.replace("=","equal");
        }
        if(msgbeforesend.contains(",")){
            msgbeforesend=msgbeforesend.replace(","," ");
        }

        if (TextUtils.isEmpty(msgbeforesend)) {
            Toast.makeText(this, "please write a message", Toast.LENGTH_SHORT).show();
            return;
        }
        String text = BeforechatActivity.chatusername+" : "+msgbeforesend;
        String id = Long.toString(System.currentTimeMillis());
        databaseReference.child(id).setValue(text);
        textToSend.setText("");
    }
}
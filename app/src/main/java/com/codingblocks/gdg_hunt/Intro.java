package com.codingblocks.gdg_hunt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Intro extends AppCompatActivity {

    public static final String TAG = "INtro Activity";

    Button start;
    EditText startText;
    String code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        start = (Button) findViewById(R.id.start_button);
        startText = (EditText) findViewById(R.id.code_intro);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code = startText.getText().toString();
                if(code.equals("0000")){
                    Log.d(TAG, "onClick: "  + code);
                    Intent i = new Intent(Intro.this , QuestionDisplay.class);
                    int random = (int) (Math.random() * 4);

                    if(random == 0){
                        SharedPreferences sharedPreferences = getSharedPreferences("random" , random);
                    }else if(random == 1){
                        SharedPreferences sharedPreferences = getSharedPreferences("random" , random);
                    }else if(random == 2){
                        SharedPreferences sharedPreferences = getSharedPreferences("random" , random);
                    }else if(random == 3){
                        SharedPreferences sharedPreferences = getSharedPreferences("random" , random);
                    }
                    startActivity(i);
                }else{
                    Snackbar snackbar
                             = Snackbar.make(findViewById(R.id.activity_intro), "Invalid Input", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });


    }
}

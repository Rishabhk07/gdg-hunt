package com.codingblocks.gdg_hunt;

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
                if(code == "0000"){
                    Log.d(TAG, "onClick: "  + code);
                }else if(code == "1111"){

                }else if(code == "2222"){

                }else if(code == "3333"){

                }else{
                    Snackbar snackbar
                             = Snackbar.make(findViewById(R.id.activity_intro), "Invalid Input", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
        });


    }
}

package com.codingblocks.gdg_hunt;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionDisplay extends AppCompatActivity {
    Button scan;
    //Button b1,b2;
    int permReqCode = 111;
   // TextView tv_score;
    //ScorePref scorePref;
    TextView ques;
    TextView desc;
    PathPref pathPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_display);
        int perm = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);

        ques = (TextView) findViewById(R.id.question_number);
        desc = (TextView) findViewById(R.id.code_tv);
        pathPref=new PathPref(this);

        desc.setText(pathPref.getQuestion());

        if(perm == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, permReqCode);
        }


        scan=(Button)findViewById(R.id.scan_btn);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(QuestionDisplay.this, Scan.class), 121);

            }
        });


    }


//    public  void change(String question , String description){
//
//        ques.setText(question);
//        desc.setText(description);
//
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 121){
            if(data != null) {
                String question = data.getStringExtra("question");
                ques.setText(question);
            }
            if(data != null) {
                String description = data.getStringExtra("description");
                Log.d("TAG", "activity result");

                desc.setText(description);
            }

        }
    }
}

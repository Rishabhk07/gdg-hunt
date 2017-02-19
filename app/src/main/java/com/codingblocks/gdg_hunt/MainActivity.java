package com.codingblocks.gdg_hunt;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    int permReqCode = 111;
    TextView tv_score;
    ScorePref scorePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int perm = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if(perm == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.CAMERA},permReqCode);
        }


        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FromAssets.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Scan.class));
                finish();
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        scorePref = new ScorePref(getApplicationContext());
        tv_score = (TextView) findViewById(R.id.score);
        tv_score.setText(tv_score.getText().toString()+scorePref.getScore());
    }

}

package com.codingblocks.gdg_hunt;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Continue extends AppCompatActivity {
    Button go_btn;
    TextView hint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_continue);
        hint = (TextView) findViewById(R.id.hint);


        go_btn=(Button)findViewById(R.id.go_btn);

        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = hint.getText().toString();
                if(pass.equals("7798")) {
                    Intent i = new Intent(Continue.this, QuestionDisplay.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(Continue.this, "Wrong Password !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

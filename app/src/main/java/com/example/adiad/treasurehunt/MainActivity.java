package com.example.adiad.treasurehunt;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler  {
    private ZXingScannerView mScannerView;
    private TextView code_tv;
    private TextView question_number;
    private PrefManager prefManager;
   // private String QuestionOrder="1.2.3.4.5";
   // private static int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        prefManager=new PrefManager(this);
        //prefManager.setQuestionNumber(1);
        //Toast.makeText(this,"pref manager number is "+prefManager.getQuestionNumber()+" ",Toast.LENGTH_LONG).show();
//        question_number=(TextView)findViewById(R.id.question_number);
        code_tv=(TextView)findViewById(R.id.code_tv);
        if(prefManager.getQuestionNumber()==1)
        {
            code_tv.setText(" ");
        }
        else {
            code_tv.setText(prefManager.getDisplayCode());
        }

        //int qn=prefManager.getQuestionNumber();

        //question_number.setText("Question "+qn+".");
    }

    public void QrScanner(View view){

        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();
    }
    @Override
    public void onPause() {
            super.onPause();
//            mScannerView.stopCamera();   // Stop camera on pause
    }
    @Override
    public void handleResult(Result rawResult)
    {

        Log.e("handler", rawResult.getText());
        Log.e("handler", rawResult.getBarcodeFormat().toString());
        //Toast.makeText(this,rawResult.getText().toString(),Toast.LENGTH_LONG).show();
        //code_tv.setText(rawResult.getText().toString());
        mScannerView.stopCamera();
        setContentView(R.layout.activity_main);
        code_tv=(TextView)findViewById(R.id.code_tv);
        String code_from_qr=rawResult.getText().toString();

        int score=prefManager.getQuestionNumber()-1;
        if(score==3) //winning score as of now is 3
        {
            Intent i=new Intent(MainActivity.this,Win.class);
            startActivity(i);
            finish();
        }
        else
        {
            if(Integer.parseInt(code_from_qr.substring(0,1))==prefManager.getQuestionNumber()) //checks if the qr code scanned matches with the fixed order that was to be scanned
            {
                int num= prefManager.getQuestionNumber();
                prefManager.setQuestionNumber(num+1);
              //  Toast.makeText(this,"pref manager number is "+prefManager.getQuestionNumber()+" ",Toast.LENGTH_LONG).show();
                code_tv.setText(rawResult.getText().toString());
                Log.e("result", "badiya bc");
                prefManager.setDisplayCode(rawResult.getText().toString());
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("OOPS !!");
                builder.setMessage("Your output seems to be incorrect. Please try again.");
                AlertDialog alert1 = builder.create();
                alert1.show();
                code_tv.setText(prefManager.getDisplayCode());
                Log.e("result","chuttiya kat gya");
            }
        }



    }
}

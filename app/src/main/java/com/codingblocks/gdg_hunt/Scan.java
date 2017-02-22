package com.codingblocks.gdg_hunt;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class Scan extends AppCompatActivity {
    PathPref pathPref;
    private SurfaceView cameraView;
    private TextView barcodeInfo;
    private TextView question;
    Button verify;
    private int track = 0;
    dbHelper mdbHelper;
    static int scanned=-1;
    String scan="-1";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        context = this;

        cameraView = (SurfaceView) findViewById(R.id.camera_view);
        barcodeInfo = (TextView) findViewById(R.id.code_info);
        verify = (Button) findViewById(R.id.verify);
        //question = (TextView) findViewById(R.id.question);
        mdbHelper = new dbHelper();
        mdbHelper.createDummydb(this);
        pathPref =new PathPref(this);
        //Show the first(0th) question
        display(mdbHelper.get());

        BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();

        final CameraSource cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .setAutoFocusEnabled(true)
                .build();
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if (barcodes.size() != 0) {
                    barcodeInfo.post(new Runnable() {    // Use the post method of the TextView
                        public void run() {
                            try
                            {

                             scan = barcodes.valueAt(0).displayValue;
                                barcodeInfo.setText(    // Update the TextView
                                   scan
                                );
                            }
                            catch (Exception e)
                            {
                                Log.e("error : ",e.getMessage());
//                                Log.e("error : ",e.printStackTrace());
                            }
                        }
                    });
                }
            }
        });



        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {

                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    cameraSource.start(cameraView.getHolder());
                    Log.i("status"," called start!");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("CAMERA SOURCE ", e.getMessage());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });
    }

    public void verifyQR(View view)
    {
        if(scan.equals("-1")) {
            Log.d("gdg_hunt","Nothing detected, blocking");
            return;
        }
//
//        if(track == 100) {
//            Toast.makeText(getApplicationContext(), "GAME OVER", Toast.LENGTH_LONG).show();
//            return;
//        }
        TreasureLocation t = mdbHelper.get();
        Log.e("tag",t.getPass());
        Log.e("tag",scan);

       // String t_string=Integer.toString(t.getPass());
        boolean ret = (t.getPass().equals(scan));
        if(ret) {
            track = mdbHelper.moveToNext();
            scanned = -1;
//            if(track < 100)
//            {
//
//                display(mdbHelper.get());
//            }

//            question.setText(mdbHelper.get().getDescription());
            String ques = mdbHelper.get().getQ();
            String desc = mdbHelper.get().getDescription();

            Intent returnIntent = new Intent();
            returnIntent.putExtra("question" , ques);
            returnIntent.putExtra("description" , desc);
            pathPref.setQuestion(desc);
            setResult(121, returnIntent);
            Toast.makeText(Scan.this, "Level Cleared Succesfully", Toast.LENGTH_SHORT).show();
            finish();
            Log.d("TAG",mdbHelper.get().getQ());
        }
        else {
            Toast.makeText(getApplicationContext(), "Wrong QR Code !! ", Toast.LENGTH_LONG).show();
            scanned = -1;
        }
    }

    private void display(TreasureLocation obj)
    {
        //set new question here
       // question.setText(obj.getQ());
        //barcodeInfo.setText(scanned + "");
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}

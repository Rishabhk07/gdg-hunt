package com.codingblocks.gdg_hunt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

public class FromAssets extends AppCompatActivity {

    Button b3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_assets);

        b3= (Button) findViewById(R.id.button3);
        tv= (TextView) findViewById(R.id.textView);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Bitmap myQRCode = BitmapFactory.decodeStream(
                            getAssets().open("qr_code.jpg")
                    );
                    BarcodeDetector barcodeDetector =
                            new BarcodeDetector.Builder(getApplicationContext())
                                    .setBarcodeFormats(Barcode.QR_CODE)
                                    .build();
                    Frame myFrame = new Frame.Builder()
                            .setBitmap(myQRCode)
                            .build();
                    SparseArray<Barcode>barcodes = barcodeDetector.detect(myFrame);
                    if(barcodes.size() != 0) {

                        // Print the QR code's message
                        tv.setText(barcodes.valueAt(0).displayValue);
                    }

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"error occured while reading the qr code!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

package com.example.imeiandroid;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        IMEINumber imeiNumber = new IMEINumber(this);
//        String imei = imeiNumber.getIMEINumber();
//
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(imei);
        String imei = IMEIUtils.getIMEI(this);
        if (imei != null) {
            tv=findViewById(R.id.textview);
            tv.setText(imei);
        }
    }
}
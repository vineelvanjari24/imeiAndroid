package com.example.imeiandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

    public class MainActivity extends AppCompatActivity {
EditText ev;
        private static final int PERMISSION_REQUEST_READ_PHONE_STATE = 1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
ev=findViewById(R.id.textview);
            // Check for permission and request it if necessary
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.READ_PHONE_STATE},
                            PERMISSION_REQUEST_READ_PHONE_STATE);
                } else {
                    getIMEI();
                }
            } else {
                getIMEI();
            }
        }

        private void getIMEI() {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
            if (telephonyManager != null) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                        == PackageManager.PERMISSION_GRANTED) {
                    String imei = telephonyManager.getDeviceId();
                    // Check if IMEI is available
                    if (imei != null && !imei.isEmpty()) {
                        // Do something with the IMEI
                    ev.setText(imei);
                        Toast.makeText(this, "IMEI: " + imei, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "IMEI not available", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == PERMISSION_REQUEST_READ_PHONE_STATE) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getIMEI();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }


}
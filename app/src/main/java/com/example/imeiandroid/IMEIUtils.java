package com.example.imeiandroid;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

public class IMEIUtils {

    public static String getIMEI(Context context) {
        String imei = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager != null) {
                imei = telephonyManager.getDeviceId();
            }
        } catch (SecurityException e) {
            // Permission denied
        }
        if (imei == null) {
            imei = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }


        return imei;
    }
}


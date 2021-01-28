package com.example.callhippo_sdk_demo;

import android.nfc.Tag;
import android.util.Log;

public class logutils {

   public static String TAG="logutils";
    public static String TAG2="CH_Calling_logs";

    public static void logutils_method(){
        Log.e(TAG,"manthan");
    }


    public static void make_outbound_call()
    {
        Log.e(TAG2,"outbound_calling...");
    }
}

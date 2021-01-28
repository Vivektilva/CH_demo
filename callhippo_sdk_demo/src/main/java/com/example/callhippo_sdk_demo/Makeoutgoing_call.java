package com.example.callhippo_sdk_demo;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.getkeepsafe.relinker.elf.Elf;
import com.twilio.voice.CallException;
import com.twilio.voice.ConnectOptions;
import com.twilio.voice.Voice;

import java.io.IOException;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static org.webrtc.ContextUtils.getApplicationContext;

public  class Makeoutgoing_call {

  public static com.twilio.voice.Call activeCall;
  static MediaPlayer mediaPlayer;
//Context mcontext;
  public static String TAG_twilio="twiliolog";
  public static String TAG="Makeoutgoing_call";
    private static OnCallhippoCallListener listener;

    public static void makeCall(Context mcontext)
    {

        String from="+16175397278";
        String _id="";
        String devicetype="";
        String input="+919978948089";


        HashMap<String, String> params = new HashMap<>();
        params.put("To", input);
        params.put("X-PH-Fromnumber", from);
        params.put("X-PH-Userid", _id);
        params.put("X-PH-Devicetype", "android");
        params.put("X-PH-Networkstrength", "");



        String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImN0eSI6InR3aWxpby1mcGE7dj0xIn0.eyJqdGkiOiJTSzYwNzNmNWJiMmM3OTY1ZTRlOGE3OTAwMGEzMTI2N2IxLTE2MTE4MTYxOTMiLCJncmFudHMiOnsiaWRlbnRpdHkiOiI1ZTA5Y2M4MjAxYzZkODBjNTVmMWI5MTItYW5kcm9pZCIsInZvaWNlIjp7ImluY29taW5nIjp7ImFsbG93Ijp0cnVlfSwib3V0Z29pbmciOnsiYXBwbGljYXRpb25fc2lkIjoiQVA4YzllMzcyZDU2MmI4YTg4MDliMzhkMTNmNDFmNjk5YyJ9LCJwdXNoX2NyZWRlbnRpYWxfc2lkIjoiQ1IyMDcxYzUzNzAyYzhmYjQ1NmY3M2Q2NjZjYmZjOTA2MSJ9fSwiaWF0IjoxNjExODE2MTkzLCJleHAiOjE2MTE5MDI1OTMsImlzcyI6IlNLNjA3M2Y1YmIyYzc5NjVlNGU4YTc5MDAwYTMxMjY3YjEiLCJzdWIiOiJBQ2RjOTBmODJlNzc3YThhOTljZTFmZmUwZDlkYjU2YmY5In0.9oJqQ6hvmK2t3_MWwUAmidSP4q-pHSHVkhzrp-oLBgU";

        ConnectOptions connectOptions = new ConnectOptions.Builder(accessToken)
                .params(params)
                .build();
        activeCall = Voice.connect(mcontext, connectOptions, listener());
        Log.e(TAG,"mmakeCall_method");
//        Makeoutgoing_call makeoutgoing_call = new Makeoutgoing_call();
//        makeoutgoing_call.setCustomListener(new OnCallhippoCallListener() {
//            @Override
//            public void OnRinging(String text) {
//
//            }
//        });

    }

    public interface OnCallhippoCallListener {
        void onConnectFailure();

        void OnRinging(String text);

        void onConnected();

        void onDisconnected();

    }

    public Makeoutgoing_call(){
        this.listener=null;
//        Log.e(TAG,"jjjjjjjjjjjjjj");
//        listen_tolistener();
    }

    public void setCustomListener(OnCallhippoCallListener listener){
        this.listener = listener;
//        Log.e(TAG,"ddddddddd");
//        listen_tolistener();

    }

//    public void listen_tolistener(){
////        if (listener != null){
//            listener.OnRinging("hellow");
////        }
//    }

    public static com.twilio.voice.Call.Listener listener()
    {
        return new com.twilio.voice.Call.Listener() {
            @Override
            public void onConnectFailure(@NonNull com.twilio.voice.Call call, @NonNull CallException callException) {
                Log.e(TAG_twilio,"onConnectFailure "+callException.getExplanation());
                Log.e(TAG_twilio+"_pc","3");
                // for call reject , miss call

//                Intent intent = new Intent(tw_NOTIFICATION);
//                intent.putExtra("tw_actionname", "tw_call_connectionfail");
//                sendBroadcast(intent);
//
//                editor = sharedPreferences.edit();
//                editor.putString("is_tw_calling","");
//                editor.commit();

//                try
//                {
//                    if(callException.getExplanation().contains("Forbidden"))
//                    {
////
//
//                        String tw_uname=sharedPreferences.getString("loginemaid","");
//                        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
//
//                        Bundle bundle5 = new Bundle();
//                        bundle5.putString("tw_uname",tw_uname);
//                        mFirebaseAnalytics.logEvent("twilio_token_expire", bundle5);
//
//                        update_token();
//                    }
//
//                }
//                catch (Exception e){}

                try
                {
                    if(mediaPlayer!=null)
                    {
                        mediaPlayer.stop();
                    }
                }
                catch (Exception e){
                    Log.e(TAG_twilio,"excpp:"+e.getMessage());}


            }

            @Override
            public void onRinging(@NonNull com.twilio.voice.Call call) {
                Log.e(TAG_twilio,"onRinging");
                Log.e(TAG_twilio+"_pc","3");
                activeCall=call;
                listener.OnRinging("CH_SDK_onringing");
                try
                {
                    String ringtone_url="https://cdn.plivo.com/sdk/browser/audio/us-ring.mp3";
                    mediaPlayer  = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_VOICE_CALL);
                    try {
                        mediaPlayer.setDataSource(ringtone_url);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e(TAG_twilio,"excc:"+e.getMessage());
                    }
                    mediaPlayer.prepareAsync();
                }
                catch (Exception e){}


//                Intent i = new Intent(getApplicationContext(), OngoingActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//                startActivity(i);

                try
                {
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
//                Toast.makeText(getApplicationContext(),"Media is prepared",Toast.LENGTH_SHORT).show();
//                            Log.e(TAG_twilio,"media_done");
                            mediaPlayer.setLooping(true);
                            mediaPlayer.start();
                        }
                    });
                }
                catch (Exception e){}


            }

            @Override
            public void onConnected(@NonNull com.twilio.voice.Call call) {
                Log.e(TAG_twilio,"onConnected");
                Log.e(TAG_twilio+"_pc","4");

                try
                {
                    if(mediaPlayer!=null)
                    {
                        mediaPlayer.stop();
                    }
                }
                catch (Exception e){}


//                Intent intent = new Intent(tw_NOTIFICATION);
//                intent.putExtra("tw_actionname", "tw_call_accept");
//                sendBroadcast(intent);

            }

            @Override
            public void onDisconnected(@NonNull com.twilio.voice.Call call, @Nullable CallException callException) {
                Log.e(TAG_twilio,"onDisconnected");
                Log.e(TAG_twilio+"_pc","5");
                // call hangup after connected

                try
                {
                    if(mediaPlayer!=null)
                    {
                        mediaPlayer.stop();
                    }
                }
                catch (Exception e){}


//                Intent intent = new Intent(tw_NOTIFICATION);
//                intent.putExtra("tw_actionname", "tw_call_disconnected");
//                sendBroadcast(intent);
//
//                editor = sharedPreferences.edit();
//                editor.putString("is_tw_calling","");
//                editor.commit();

            }
        };

    }
}

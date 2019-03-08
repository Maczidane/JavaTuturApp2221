package com.easyhouse24.javatuturapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MusicService extends Service {
    public static MediaPlayer mediaPlayer;
    static int length;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.music);// raw/s.mp3


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

        }


        return START_STICKY;
    }

    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }







    public static void pausePlay() {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {


            mediaPlayer.pause();


        }
        mediaPlayer.release();


    }





//    public static void resumePlay() {
//
//        if (mediaPlayer != null) {
//            int pausePosition = mediaPlayer.getCurrentPosition();
//            mediaPlayer.seekTo(pausePosition);
//            mediaPlayer.start();
//        }
//
//
//    }


}

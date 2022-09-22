package com.example.dayeight;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class backgroundService extends Service {
    private MediaPlayer musicPlayer;

    public backgroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        musicPlayer= MediaPlayer.create(this, R.raw.neon_blade_moondeity);
        musicPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        musicPlayer.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        musicPlayer.stop();
        super.onDestroy();
    }
}
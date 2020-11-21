package com.finalproject.openrun.module.music.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.finalproject.openrun.module.music.broadcasts.NotificationReceiver;
import com.finalproject.openrun.module.music.view.notification.MusicPlayerNotification;

public class MusicService extends Service{

    public static final String GO_NEXT = "GO_NEXT";
    public static final String PLAY_PAUSE = "PLAY_PAUSE";
    public static final String GO_BACK = "GO_BACK";

    private PendingIntent goPreviousPI;
    private PendingIntent playPausePI;
    private PendingIntent goNextPI;
    private PendingIntent openMusicPlayerPI;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createActionsPI();
        // Track player notification
        final NotificationManager notificationManager = getSystemService(NotificationManager.class);
        MusicPlayerNotification.getInstance().prepare(MusicService.this, notificationManager, openMusicPlayerPI, goPreviousPI, playPausePI, goNextPI);
        MusicPlayerNotification.getInstance().run();

        startForeground(MusicPlayerNotification.NOTIFICATION_ID, MusicPlayerNotification.getInstance().getNotification());

        return START_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void  createActionsPI() {
        // Actions and intents
        Intent goPreviousIntent = new Intent(MusicService.this, NotificationReceiver.class);
        goPreviousIntent.setAction(GO_BACK);
        goPreviousPI = PendingIntent.getBroadcast(MusicService.this, 0, goPreviousIntent, 0);

        Intent playPauseIntent = new Intent(MusicService.this, NotificationReceiver.class);
        playPauseIntent.setAction(PLAY_PAUSE);
        playPausePI = PendingIntent.getBroadcast(MusicService.this, 0, playPauseIntent, 0);

        Intent goNextIntent = new Intent(MusicService.this, NotificationReceiver.class);
        goNextIntent.setAction(GO_NEXT);
        goNextPI = PendingIntent.getBroadcast(MusicService.this, 0, goNextIntent, 0);

        //Intent openMusicPlayerIntent = new Intent(MusicService.this, MusicPlayerActivity.class);
        //openMusicPlayerPI = PendingIntent.getActivity(MusicService.this, 0, openMusicPlayerIntent, 0);
    }
}

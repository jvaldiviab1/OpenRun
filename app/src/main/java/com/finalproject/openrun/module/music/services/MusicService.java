package com.finalproject.openrun.module.music.services;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.MediaStore;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;

import java.util.Observable;
import java.util.Observer;

public class MusicService extends Service implements Observer {

    static String CHANNEL_ID_MUSIC = "app.MUSIC";
    static String CHANNEL_NAME_MUSIC = "Music";
    static int NOTIFICATION_ID_MUSIC = 101;

    static int BROADCAST_ID_MUSIC = 201;
    final static String NOTIFICATION_PREVIOUS = "notification.PREVIOUS";
    final static String NOTIFICATION_PLAY = "notification.PLAY";
    final static String NOTIFICATION_NEXT = "notification.NEXT";
    final static String NOTIFICATION_CANCEL = "notification.CANCEL";

    static String ACTION_FIND_NEW_SONG = "action.FIND_NEW_SONG";
    static String ACTION_NOT_SONG_FOUND = "action.NOT_FOUND";

    private RemoteViews mRemoteView;
    private PendingIntent intentPREVIOUS;
    private PendingIntent intentPlay;
    private PendingIntent intentNext;
    private PendingIntent intentCancel;

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String temp = intent.getAction();
            switch (intent.getAction()) {
                case NOTIFICATION_PREVIOUS:
                    break;
                case NOTIFICATION_PLAY:
                    break;
                case NOTIFICATION_NEXT:
                    break;
                case NOTIFICATION_CANCEL:
                    break;

            }
        }
    };

    private MediaMetadataRetriever mMetaRetriever = new MediaMetadataRetriever();
    private Uri uriExtenal = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

    private Handler mHandler = new Handler(Looper.getMainLooper());




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}

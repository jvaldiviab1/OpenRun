package com.finalproject.openrun.module.music.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.finalproject.openrun.module.music.data.model.Song;
import com.finalproject.openrun.module.music.data.repository.MusicPlayer;

import java.io.IOException;
import java.util.List;

public class NotificationReceiver extends BroadcastReceiver {

    public static final String GO_NEXT = "GO_NEXT";
    public static final String PLAY_PAUSE = "PLAY_PAUSE";
    public static final String GO_BACK = "GO_BACK";

    private Context context;

    private MusicPlayer musicPlayer = MusicPlayer.getInstance();

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        String action = intent.getAction();
        Log.d("NotificationReceiver", "onReceive: " + action);
        switch (action) {
            case GO_BACK:
                onPreviousBtnClicked();
                break;
            case PLAY_PAUSE:
                onPlayPauseBtnClicked();
                break;
            case GO_NEXT:
                onNextBtnClicked();
                break;
            default:
                break;
        }
    }

    public void onPlayPauseBtnClicked() {
        if (isPlayingMusic().getValue())
            musicPlayer.pause();
        else
            musicPlayer.resume();
    }

    public void onPreviousBtnClicked() {
        int index = getPlayingSong().getValue().getIndex() - 1;
        if (index < 0)
            index += getPlayingList().getValue().size();
        try {
            musicPlayer.playMusic(musicPlayer.getPlayingList().getValue().get(index), context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onNextBtnClicked() {
        int index = getPlayingSong().getValue().getIndex() + 1;
        if (index >= getPlayingList().getValue().size())
            index = 0;
        try {
            musicPlayer.playMusic(musicPlayer.getPlayingList().getValue().get(index), context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MutableLiveData<Song> getPlayingSong() {
        return musicPlayer.getPlayingSong();
    }

    public MutableLiveData<List<Song>> getPlayingList() {
        return musicPlayer.getPlayingList();
    }

    public MutableLiveData<Boolean> isPlayingMusic() {
        return musicPlayer.isPlaying();
    }

}

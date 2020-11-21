package com.finalproject.openrun.module.music.data.repository;

import android.media.MediaPlayer;

import androidx.lifecycle.MutableLiveData;
import com.finalproject.openrun.module.music.data.model.Song;

public class MusicPlayer {

    public static final String CONTENT_MEDIA_EXTERNAL_AUDIO_ALBUMART = "content://media/external/audio/albumart";
    private static MusicPlayer instance;

    public static MusicPlayer getInstance(){
        if (instance == null)
            instance = new MusicPlayer();
        return instance;
    }

    private MutableLiveData<MediaPlayer> mediaPlayer = new MutableLiveData<>();
    private MutableLiveData<Boolean> isPlaying = new MutableLiveData<>();
    private MutableLiveData<Song> playingSong = new MutableLiveData<>();

}

package com.finalproject.openrun.module.music.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.finalproject.openrun.module.music.data.repository.MusicPlayer;

public class MusicPlayerViewModel extends AndroidViewModel {

    private MusicPlayer musicPlayer = MusicPlayer.getInstance();

    public MusicPlayerViewModel(@NonNull Application application) {
        super(application);
    }
}

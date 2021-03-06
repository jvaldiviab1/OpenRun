package com.finalproject.openrun.module.music;

import com.finalproject.openrun.module.music.data.model.Song;

public interface MusicContract {
    interface View{
        void showLoadding();
        void stopLoading();
        void updateSongState();
        void onSongClick(Song song, Boolean isPlaying);
    }

    interface Presenter{

    }

    interface Interactor{

    }

    interface onMusicListener{

    }
}

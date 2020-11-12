package com.finalproject.openrun.module.music;

public class MusicInteractor implements MusicContract.Interactor{

    private MusicContract.onMusicListener mOnMusicListener;

    public MusicInteractor(MusicContract.onMusicListener mOnMusicListener){
        this.mOnMusicListener = mOnMusicListener;
    }

}

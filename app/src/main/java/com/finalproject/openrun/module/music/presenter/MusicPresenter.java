package com.finalproject.openrun.module.music.presenter;

import com.finalproject.openrun.module.music.MusicContract;
import com.finalproject.openrun.module.music.MusicInteractor;

public class MusicPresenter implements MusicContract.Presenter, MusicContract.onMusicListener {

    private final MusicContract.View mMusicView;
    private final MusicInteractor mMusicInteractor;

    public MusicPresenter(MusicContract.View mMusicView){
        this.mMusicView = mMusicView;
        mMusicInteractor = new MusicInteractor(this);
    }
}

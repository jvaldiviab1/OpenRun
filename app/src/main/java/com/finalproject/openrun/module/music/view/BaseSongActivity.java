package com.finalproject.openrun.module.music.view;

import com.finalproject.openrun.module.base.BaseActivity;

import java.util.Observable;
import java.util.Observer;

public class BaseSongActivity extends BaseActivity implements Observer {

    private int REQUEST_WRITE__EXTERNAL_STORAGE = 10;


    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

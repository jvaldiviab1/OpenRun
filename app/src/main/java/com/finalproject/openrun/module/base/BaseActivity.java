package com.finalproject.openrun.module.base;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean isActive(){
        return getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) ||
                getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }
}

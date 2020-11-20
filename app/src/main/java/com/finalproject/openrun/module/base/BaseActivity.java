package com.finalproject.openrun.module.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;

import com.google.android.material.snackbar.Snackbar;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

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

    public void context(){
        Context context= this;
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showSnackBar(View v, String msg){
        Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();
    }

    protected boolean hasPermission(String permission){
        return ContextCompat.checkSelfPermission(this, permission)==PERMISSION_GRANTED;
    }

    protected void requestPermission(int requestCode, String[] permissions){
        ActivityCompat.requestPermissions(this, permissions, requestCode);
    }

}

package com.finalproject.openrun.module.login.presenter;

import android.app.Activity;

import com.finalproject.openrun.module.login.LoginContract;
import com.finalproject.openrun.module.login.LoginInteractor;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.onLoginListener {

    private String TAG = "LoginPresenter";

    private LoginContract.View mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenter(LoginContract.View mLoginView){
        this.mLoginView = mLoginView;
        mLoginInteractor = new LoginInteractor(this);

    }

    @Override
    public void login(Activity activity, String email, String password) {
        mLoginInteractor.performFirebaseLogin(activity, email, password);
    }

    @Override
    public void checkCredentials(Activity activity, String email, String password) {
        mLoginInteractor.validateCredentials(activity, email, password);
    }

    @Override
    public void onSuccess(String message) {
        mLoginView.onLoginSuccess(message);
    }

    @Override
    public void onFailure(String message) {
        mLoginView.onLoginFailure(message);
    }
}

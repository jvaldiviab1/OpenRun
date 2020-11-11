package com.finalproject.openrun.module.login;

import android.app.Activity;
import android.content.Context;

public interface LoginContract {
    interface View{
        void onLoginSuccess(String message);
        void onLoginFailure(String message);
    }

    interface Presenter{
        void login(Activity activity, String email, String password);
        void checkCredentials(Activity activity, String email, String password);
    }

    interface Intractor{
        void performFirebaseLogin(Activity activity, String email, String password);
        void validateCredentials(Activity activity, String email, String password);
    }

    interface onLoginListener{
        void onSuccess(String message);
        void onFailure(String message);
    }

}

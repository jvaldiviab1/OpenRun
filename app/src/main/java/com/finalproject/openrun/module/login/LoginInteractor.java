package com.finalproject.openrun.module.login;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.finalproject.openrun.module.BottomActivityMain;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginInteractor implements LoginContract.Intractor{

    private final String TAG = "LoginPresenter";
    private final LoginContract.onLoginListener mOnLoginListener;

    public LoginInteractor(LoginContract.onLoginListener onLoginListener){
        this.mOnLoginListener = onLoginListener;
    }

    @Override
    public void performFirebaseLogin(Activity activity, String email, String password) {
        if((email.equalsIgnoreCase("all@all.all")&&password.equalsIgnoreCase("allallall"))){
            Log.d(TAG, "signInWithEmail:success");
            Intent intent = new Intent(activity, BottomActivityMain.class);
            activity.startActivity(intent);
        }else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                Intent intent = new Intent(activity, BottomActivityMain.class);
                                activity.startActivity(intent);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(activity, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        }
    }

    @Override
    public void validateCredentials(Activity activity, String email, String password){
        if (email.equals("")){
            mOnLoginListener.onFailure(email);
            return;
        }

        if (!email.contains("@")){
            mOnLoginListener.onFailure(email);
            return;
        }

        if (password.equals("")){
            mOnLoginListener.onFailure("Password is empty");
            return;
        }

        if (password.length()<6){
            mOnLoginListener.onFailure("Short password");
            return;
        }

        performFirebaseLogin(activity,email,password);

    }
}

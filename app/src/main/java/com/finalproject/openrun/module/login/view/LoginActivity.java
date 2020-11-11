package com.finalproject.openrun.module.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.finalproject.openrun.R;
import com.finalproject.openrun.module.base.BaseActivity;
import com.finalproject.openrun.module.BottomActivityMain;
import com.finalproject.openrun.module.SplashActivity;
import com.finalproject.openrun.module.login.LoginContract;
import com.finalproject.openrun.module.login.presenter.LoginPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements LoginContract.View, View.OnClickListener{

    private LoginPresenter mLoginPresenter;
    private FirebaseAuth mAuth;

    @BindView(R.id.etEmail)
    EditText mEtEmail;
    @BindView(R.id.etPassword)
    EditText mEtPassword;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mLoginPresenter = new LoginPresenter(this);

        Button mBtnLogin = findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(this);

    }

    private void initLogin(String email, String password) {
        mLoginPresenter.checkCredentials(this, email, password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                initLogin(String.valueOf(mEtEmail.getText().toString()),String.valueOf(mEtPassword.getText().toString()));
                break;
        }
    }

    @Override
    public void onBackPressed(){
        finish();
    }

    @Override
    public void onLoginSuccess(String message) {
        hideLoadingScreen();
        IsEmailVerified();
    }

    @Override
    public void onLoginFailure(String message) {
        hideLoadingScreen();
        onError(message);
    }

    private void IsEmailVerified() {
        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        if (user.isEmailVerified()){
            // If the users email has been verified, then it starts the main activity
            startActivity(new Intent(LoginActivity.this, BottomActivityMain.class));
            finish();
        }
        else {
            // If the users email has not been verified, it starts the verification activity
            startActivity(new Intent(LoginActivity.this, SplashActivity.class));
            finish();
        }
    }


}
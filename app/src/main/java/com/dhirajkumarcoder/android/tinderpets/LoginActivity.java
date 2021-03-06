package com.dhirajkumarcoder.android.tinderpets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dhirajkumarcoder.android.tinderpets.Interfaces.LoginInterface;
import com.dhirajkumarcoder.android.tinderpets.Interfaces.UserReceived;
import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.User;
import com.dhirajkumarcoder.android.tinderpets.Presenter.LoginPresenter;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginInterface{


    static {
        new FirebaseUtil();
    }

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    public static LoginResult loginResult;

    @Inject
    LoginPresenter loginPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this) ;
        ((AppController)this.getApplicationContext()).get().inject(this);

        if (AccessToken.getCurrentAccessToken() != null) {
            FirebaseUtil.getUserById(Profile.getCurrentProfile().getId(), new UserReceived() {
                @Override
                public void userReceived(User user) {
                    User.user = user;
                    Intent i = new Intent(getApplicationContext(), StartupActivity.class);
                    startActivity(i);
                }
            });
        }
        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.button_facebook_login1);
        loginButton.setReadPermissions("email");
        loginButton.setReadPermissions("user_birthday");
        loginButton.setReadPermissions("user_photos");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult lr) {
                loginResult = lr;
                loginPresenter.getRequiredImages(lr);
                goMainScreen();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "login error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "LoginError", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        loginPresenter.register(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        loginPresenter.unRegister();
        super.onPause();
    }

    private void goMainScreen() {
        Intent intent = new Intent(this, FormActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent data) {
        super.onActivityResult(requestCode, ResultCode, data);
        callbackManager.onActivityResult(requestCode, ResultCode, data);
    }

}

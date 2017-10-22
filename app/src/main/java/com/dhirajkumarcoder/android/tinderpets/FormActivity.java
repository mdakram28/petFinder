package com.dhirajkumarcoder.android.tinderpets;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dhirajkumarcoder.android.tinderpets.Model.UiModels.User;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {
    //ImageView signup;
    @BindView(R.id.etName)      EditText etName;
    @BindView(R.id.etEmail)     EditText etEmail;
    @BindView(R.id.etAddress)   EditText etAddress;
    @BindView(R.id.etCity)      EditText etCity;
    @BindView(R.id.etContact)   EditText etContact;
    @BindView(R.id.etCountry)   EditText etCountry;
    @BindView(R.id.etDOB)       EditText etDOB;
    @BindView(R.id.etHouse)     EditText etHouse;
    @BindView(R.id.etState)     EditText etState;
    @BindView(R.id.etZip)       EditText etZip;

    @BindView(R.id.btnSignUp)   Button submitButton;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        setFacebookData(LoginActivity.loginResult);

        submitButton.setOnClickListener(this);
    }

    public void startup(View view) {
        Intent i = new Intent(getApplicationContext(), StartupActivity.class);
        startActivity(i);

    }


    User user = new User();


    private void setFacebookData(final LoginResult loginResult) {
        mHandler = new Handler(Looper.getMainLooper());
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {
                            Log.i("Response", response.toString());

                            user.email = response.getJSONObject().getString("email");
                            user.gender = response.getJSONObject().getString("gender");
                            user.birthday = response.getJSONObject().getString("birthday");
                            user.name = response.getJSONObject().getString("name");
                            user.id = response.getJSONObject().getString("id");

                            Profile profile = Profile.getCurrentProfile();
                            String id = profile.getId();
                            String link = profile.getLinkUri().toString();
                            Log.i("Link", link);
                            if (Profile.getCurrentProfile() != null) {
                                Log.i("Login", "ProfilePic" + Profile.getCurrentProfile().getProfilePictureUri(200, 200));
                            }

                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    etEmail.setText(user.email, TextView.BufferType.EDITABLE);
                                    etName.setText(user.name, TextView.BufferType.EDITABLE);
//                                    etGender.setText(user.gender, TextView.BufferType.EDITABLE);
                                    etDOB.setText(user.birthday, TextView.BufferType.EDITABLE);
                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email,name,gender,birthday");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    public void onClick(View view) {
        user.address = etAddress.getText().toString();
        user.birthday = etDOB.getText().toString();
        user.city = etCity.getText().toString();
        user.country = etCountry.getText().toString();
        user.email = etEmail.getText().toString();
        user.name = etName.getText().toString();
        user.phone = etCountry.getText().toString();
        user.state = etState.getText().toString();
        user.phone = etContact.getText().toString();
        FirebaseUtil.addUser(user);
        startup(view);
    }
}


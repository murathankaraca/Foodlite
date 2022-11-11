package com.eray.foodlite.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.eray.foodlite.Models.Profile;
import com.eray.enbuyukfener.R;
import com.eray.foodlite.Repository.ProfileRepository;
import com.eray.foodlite.SecondaryActivity;
import com.eray.foodlite.Services.HttpService;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Date;
import java.util.Random;

import cz.msebera.android.httpclient.Header;

public class ProfileEditActivity extends AppCompatActivity {

    EditText userName;
    EditText name;
    EditText lastName;
    EditText password;
    EditText rpassword;
    EditText email;
    EditText phoneNumber;
    EditText address;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        //
        userName = findViewById(R.id.edtUsername);
        name = findViewById(R.id.edtName);
        lastName = findViewById(R.id.edtSurname);
        password = findViewById(R.id.edtPassword);
        rpassword = findViewById(R.id.edtRPassword);
        email = findViewById(R.id.edtEmail);
        phoneNumber = findViewById(R.id.edtPhoneNumber);
        address = findViewById(R.id.edtAddress);
        //
        userName.setText(ProfileRepository.Instance.getCurrentUser().getUserName());
        name.setText(ProfileRepository.Instance.getCurrentUser().getName());
        lastName.setText(ProfileRepository.Instance.getCurrentUser().getLastName());
        password.setText(ProfileRepository.Instance.getCurrentUser().getPassword());
        email.setText(ProfileRepository.Instance.getCurrentUser().getEmail());
        phoneNumber.setText(ProfileRepository.Instance.getCurrentUser().getPhoneNumber());
        address.setText(ProfileRepository.Instance.getCurrentUser().getAddress());
        //

        Button btnBack = findViewById(R.id.btnBack);
        Button btnEditProfile = findViewById(R.id.btnEditProfile);

        btnBack.setOnClickListener(v -> {
            super.onBackPressed();
        });

        // TO DO : A PUT REQUEST ON THE SERVER.

        btnEditProfile.setOnClickListener(v -> {
            updateProfile();
        });

    }

    public void updateProfile() {
        try {

            RequestParams reqParams = new RequestParams();

            reqParams.add("id", String.valueOf(new Random().nextInt() * 250000));
            reqParams.add("userName", String.valueOf(userName.getText()));
            reqParams.add("name", String.valueOf(name.getText()));
            reqParams.add("lastName", String.valueOf(lastName.getText()));
            reqParams.add("password", String.valueOf(password.getText()));
            reqParams.add("email", String.valueOf(email.getText()));
            reqParams.add("phoneNumber", String.valueOf(phoneNumber.getText()));
            reqParams.add("joinDate", String.valueOf(new Date()));
            reqParams.add("address", String.valueOf(address.getText()));

            HttpService.post("profiles/updateUser",reqParams, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray
                    System.out.println("Response is: " + response.toString()) ;
                    ProfileRepository.Instance.setCurrentUser(
                            new Profile(new Random().nextInt() * 250000,
                                    userName.getText().toString(),
                                    name.getText().toString(),
                                    lastName.getText().toString(),
                                    password.getText().toString(),
                                    email.getText().toString(),
                                    phoneNumber.getText().toString(),
                                    new Date().toString(),
                                    address.getText().toString()
                            )
                    );
                    Intent intent = new Intent(ProfileEditActivity.this, SecondaryActivity.class);
                    startActivity(intent);
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                    // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                    t.printStackTrace();
                }
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

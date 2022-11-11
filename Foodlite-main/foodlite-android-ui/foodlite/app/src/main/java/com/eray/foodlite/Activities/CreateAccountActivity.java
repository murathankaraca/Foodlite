package com.eray.foodlite.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.eray.enbuyukfener.R;
import com.eray.foodlite.SecondaryActivity;
import com.eray.foodlite.Services.HttpService;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.Date;
import java.util.Random;

import cz.msebera.android.httpclient.Header;

public class CreateAccountActivity extends AppCompatActivity {
    //
    EditText userName;
    EditText name;
    EditText lastName;
    EditText password;
    EditText confirmPassword;
    EditText email;
    EditText phoneNumber;
    EditText address;
    //

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        userName = findViewById(R.id.edtTextUsername);
        name = findViewById(R.id.edtTextName);
        lastName = findViewById(R.id.edtTextSurname);
        password = findViewById(R.id.edtTextPassword);
        confirmPassword = findViewById(R.id.edtRPassword);
        email = findViewById(R.id.edtTextEmail);
        phoneNumber = findViewById(R.id.edtTextPhoneNumber);
        address = findViewById(R.id.edtTextAdress);
        //


        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            super.onBackPressed();
        });
        Button btnCreate = findViewById(R.id.btnCreateNewAccount);
        btnCreate.setOnClickListener(this::createAccount);

    }

    // TO DO: POST REQUEST ON SERVER
    public void createAccount(View v) {
        if(String.valueOf(password.getText()).equals(String.valueOf(confirmPassword.getText()))) {
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

                HttpService.post("profiles/addUser/",reqParams, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        // If the response is JSONObject instead of expected JSONArray
                        System.out.println("Response is: " + response.toString()) ;
                        Intent intent = new Intent(CreateAccountActivity.this, SecondaryActivity.class);
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
}

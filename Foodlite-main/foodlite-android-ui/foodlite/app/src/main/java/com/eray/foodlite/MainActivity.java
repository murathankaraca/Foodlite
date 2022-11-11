package com.eray.foodlite;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eray.foodlite.Activities.CreateAccountActivity;
import com.eray.foodlite.Models.Profile;
import com.eray.enbuyukfener.R;
import com.eray.foodlite.Repository.Basket;
import com.eray.foodlite.Repository.ProductRepository;
import com.eray.foodlite.Repository.ProfileRepository;
import com.eray.foodlite.Services.HttpService;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ProductRepository productRepository = new ProductRepository();
    ProfileRepository profileRepository = new ProfileRepository();
    EditText txtUsername;
    EditText txtPassword;
    AlertDialog dialogNotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Basket basket = new Basket();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = (EditText) findViewById(R.id.edtTextUsername);
        txtPassword = (EditText) findViewById(R.id.edtTextPassword);
//        Button button = (Button) findViewById(R.id.btnBack);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
//                startActivity(intent);
//            }
//        });

        Button button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(v -> validateUser());

        Button buttonToNewAccount = (Button) findViewById(R.id.btnNewAccount);
        buttonToNewAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        dialogNotFound = new AlertDialog.Builder(this).setMessage("Böyle bir kullanıcı yok.")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        // Do stuff if user accepts
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        // Do stuff when user neglects.
                    }
                }).create();
    }

    public Profile validateUser() {
        final Profile[] profile = new Profile[1];
        try {
            HttpService.get("profiles/", null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                    // Pull out the first event on the public timeline
                    JSONObject getUserEvent = null;
                    int userId = -1;
                    String name = "";
                    String lastName = "";
                    String userName = "";
                    String password = "";
                    String email = "";
                    String phoneNumber = "";
                    String joinDate;
                    String address = "";
                    try {
                        for(int i = 0; i < timeline.length(); i++) {
                            getUserEvent = (JSONObject) timeline.get(i);
                            // Do something with the response
                            System.out.println("Iterated date is: " + getUserEvent);
                            //
                            userId = getUserEvent.getInt("userId");
                            userName = getUserEvent.getString("userName");
                            name = getUserEvent.getString("name");
                            lastName = getUserEvent.getString("lastName");
                            email = getUserEvent.getString("email");
                            password = getUserEvent.getString("password");
                            phoneNumber = getUserEvent.getString("phoneNumber");
                            joinDate = getUserEvent.getString("joinDate");
                            address = getUserEvent.getString("address");
                            if(userName.contentEquals(txtUsername.getText()) && password.contentEquals(txtPassword.getText())) {
                                profile[0] = new Profile(userId, userName, name, lastName, password, email, phoneNumber, joinDate, address);
                                ProfileRepository.Instance.setCurrentUser(profile[0]);
                                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                                startActivity(intent);
                                break;
                            }
                        }
                        System.out.println(ProfileRepository.Instance.getCurrentUser());
                        if(ProfileRepository.Instance.getCurrentUser() == null) {
                            dialogNotFound.show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return profile[0];
    }
}

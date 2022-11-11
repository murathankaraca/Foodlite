package com.eray.foodlite.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eray.foodlite.Activities.ProfileEditActivity;
import com.eray.enbuyukfener.R;
import com.eray.foodlite.Repository.ProfileRepository;

public class ProfileFragment extends Fragment {
    TextView userName;
    TextView name;
    TextView lastName;
    TextView password;
    TextView email;
    TextView phoneNumber;
    TextView address;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, null);

        // Assigning all the required text fields.

        userName = rootView.findViewById(R.id.txtUsername);
        name = rootView.findViewById(R.id.txtName);
        lastName = rootView.findViewById(R.id.txtLastname);
        password = rootView.findViewById(R.id.txtPassword);
        email = rootView.findViewById(R.id.txtEmail);
        phoneNumber = rootView.findViewById(R.id.txtPhoneNumber);
        address = rootView.findViewById(R.id.txtAddress);

        // Initializing the texts for all text fields inside the fragment.

        userName.setText(ProfileRepository.Instance.getCurrentUser().getUserName());
        name.setText(ProfileRepository.Instance.getCurrentUser().getName());
        lastName.setText(ProfileRepository.Instance.getCurrentUser().getLastName());
        password.setText(ProfileRepository.Instance.getCurrentUser().getPassword());
        email.setText(ProfileRepository.Instance.getCurrentUser().getEmail());
        phoneNumber.setText(ProfileRepository.Instance.getCurrentUser().getPhoneNumber());
        address.setText(ProfileRepository.Instance.getCurrentUser().getAddress());

        //

        // Burada diger aktiviteye gidiyor.
        Button btnEdit = rootView.findViewById(R.id.btnEditProfile);
        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileEditActivity.class);
            startActivity(intent);
        });
        return rootView;
    }

}

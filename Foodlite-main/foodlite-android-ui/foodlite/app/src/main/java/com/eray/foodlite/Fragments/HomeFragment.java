package com.eray.foodlite.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eray.foodlite.Activities.SearchProductActivity;
import com.eray.foodlite.Activities.SearchProviderActivity;
import com.eray.enbuyukfener.R;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, null);

        Button btnHamburger = homeView.findViewById(R.id.btnHamburger);
        Button btnPizza = homeView.findViewById(R.id.btnPizza);
        Button btnBurgerKing = homeView.findViewById(R.id.btnBurgerKing);

        btnHamburger.setOnClickListener(
                v -> proceedToSearchByFoodCategory("Hamburger")
        );
        btnPizza.setOnClickListener(
                v -> proceedToSearchByFoodCategory("Pizza")
        );
        btnBurgerKing.setOnClickListener(
                v -> proceedToSearchByRestaurant("Burger King")
        );

        return homeView;
    }

    public void proceedToSearchByFoodCategory(String foodCategory) {
        SearchProviderActivity.searchParam = foodCategory;
        Intent intent = new Intent(getActivity(), SearchProductActivity.class);
        startActivity(intent);
    }

    public void proceedToSearchByRestaurant(String restaurantName) {
        SearchProviderActivity.searchParam = restaurantName;
        Intent intent = new Intent(getActivity(), SearchProviderActivity.class);
        startActivity(intent);
    }
}

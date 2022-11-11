package com.eray.foodlite.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eray.foodlite.Adapters.BasketProductAdapter;
import com.eray.enbuyukfener.R;
import com.eray.foodlite.Repository.Basket;

import java.util.Objects;

public class BasketFragment extends Fragment {
    RecyclerView.Adapter adapter;
    static TextView txtPrice;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View basketView =  inflater.inflate(R.layout.fragment_basket, null);

        final FragmentActivity basketActivity = getActivity();

        adapter = createRecyclerViewForProducts(basketView, basketActivity);

        Button btnClear = basketView.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(v -> clearBasket());

        Button btnPayment = basketView.findViewById(R.id.btnPayment);
        btnPayment.setOnClickListener(v -> clearBasket());

        txtPrice = (TextView) basketView.findViewById(R.id.txtPrice);
        BasketFragment.changeBasketPrice();

        return basketView;
    }

    private RecyclerView.Adapter createRecyclerViewForProducts(View v, FragmentActivity act) {

        RecyclerView rvProducts = (RecyclerView) Objects.requireNonNull(v)
                .findViewById(R.id.rvBasket);

        BasketProductAdapter adapter = new BasketProductAdapter(Basket.Instance.productList);

        rvProducts.setLayoutManager(new LinearLayoutManager(act));
        rvProducts.setAdapter(adapter);

        return adapter;
    }

    public void clearBasket() {
        Basket.Instance.productList.clear();
        txtPrice.setText(String.valueOf(Basket.Instance.getTotalPrice()));
        adapter.notifyDataSetChanged();
    }
    public static void changeBasketPrice() {
        if(txtPrice != null) {
            txtPrice.setText(String.valueOf(Basket.Instance.getTotalPrice()));
        }
    }
}

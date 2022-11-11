package com.eray.foodlite.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eray.foodlite.Adapters.ProductAdapter;
import com.eray.foodlite.Adapters.ProviderAdapter;
import com.eray.enbuyukfener.R;
import com.eray.foodlite.Repository.ProductRepository;

import java.util.Objects;

public class SearchFragment extends Fragment {

    RecyclerView rvProducts;
    ProductAdapter adapter;

    Button btnSearch;
    EditText edtSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View searchView = inflater.inflate(R.layout.fragment_search, null);
        final FragmentActivity searchActivity = getActivity();

        edtSearch = searchView.findViewById(R.id.edtSearch);
        btnSearch = searchView.findViewById(R.id.btnAra);

        btnSearch.setOnClickListener(v -> {
            searchForProduct(searchView, searchActivity);
            adapter.notifyDataSetChanged();
            System.out.println("Search is done!");
        });

        createRecyclerViewForProducts(searchView, searchActivity);
        return searchView;
    }

    private void createRecyclerViewForProducts(View v, FragmentActivity act) {

        rvProducts = (RecyclerView) Objects.requireNonNull(v)
                .findViewById(R.id.recyclerProduct);

        adapter = new ProductAdapter(ProductRepository.Instance.getProducts());
        rvProducts.setLayoutManager(new LinearLayoutManager(act));
        rvProducts.setAdapter(adapter);

    }
    private void searchForProduct(View v, FragmentActivity act) {

        rvProducts = (RecyclerView) Objects.requireNonNull(v)
                .findViewById(R.id.recyclerProduct);

        adapter = new ProductAdapter(ProductRepository.Instance.fetchListByName(edtSearch.getText().toString()));

        rvProducts.setLayoutManager(new LinearLayoutManager(act));
        rvProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void createRecyclerViewForProviders(View v, FragmentActivity act) {

        RecyclerView rvProviders = (RecyclerView) Objects.requireNonNull(v)
                .findViewById(R.id.recyclerProduct);

        ProviderAdapter adapter = new ProviderAdapter(null);

        rvProviders.setLayoutManager(new LinearLayoutManager(act));
        rvProviders.setAdapter(adapter);
    }
}

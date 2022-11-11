package com.eray.foodlite.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eray.foodlite.Models.Provider;
import com.eray.enbuyukfener.R;

import java.util.List;

public class ProviderAdapter extends
        RecyclerView.Adapter<ProviderAdapter.ViewHolder> {

    // Storing the information.
    private List<Provider> providers;

    public ProviderAdapter(List<Provider> providers) {
        this.providers = providers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.product, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
//        Provider provider = providers.get(position);
//
//        // Set item views based on your views and data model
//        // Binds the Product Title to the relevant text view.
//        TextView textViewTitle = holder.titleTextView;
//        textViewTitle.setText(provider.getProductName());
//        //
//        // Binds the Product Price to the relevant text view.
//        TextView textViewPrice = holder.priceTextView;
//        textViewPrice.setText(String.valueOf(product.getPrice()));
//        //
//        // Binds the Provider name to the relevant text view.
//        TextView textViewProvider = holder.providerTextView;
//        textViewProvider.setText(product.getProductProvider().getProviderName());
//        System.out.println(product.getProductName());
    }

    @Override
    public int getItemCount() {
        return providers.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView titleTextView;
        public TextView providerTextView;
        public TextView priceTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.profileTitle);
            providerTextView = (TextView) itemView.findViewById(R.id.productProvider);
            priceTextView = (TextView) itemView.findViewById(R.id.productPrice);
        }
    }
}

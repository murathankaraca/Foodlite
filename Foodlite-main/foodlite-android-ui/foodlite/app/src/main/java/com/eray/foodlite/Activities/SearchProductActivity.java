package com.eray.foodlite.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eray.foodlite.Adapters.ProductAdapter;
import com.eray.foodlite.Models.Product;
import com.eray.foodlite.Models.Provider;
import com.eray.enbuyukfener.R;
import com.eray.foodlite.Repository.ProductRepository;
import com.eray.foodlite.Services.HttpService;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class SearchProductActivity extends AppCompatActivity {
    public static String searchParam = "";
    List<Product> products;

    RecyclerView rvProducts;
    ProductAdapter adapter;

    Button btnSearch;
    EditText edtSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_product);
        createRecyclerViewForProducts();

        initBackButton();
        edtSearch = findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnAra);

        btnSearch.setOnClickListener(v -> {
            ProductRepository.Instance.fetchListByName(edtSearch.getText().toString());
            adapter.notifyDataSetChanged();
            System.out.println("Search is done!");
        });
    }

    private void initBackButton() {
        ImageButton btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> super.onBackPressed());
    }

    private void createRecyclerViewForProducts() {

        rvProducts = (RecyclerView) findViewById(R.id.recyclerProduct);

        adapter = new ProductAdapter(fetchListByProvider());

        rvProducts.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvProducts.setAdapter(adapter);
    }

    public List<Product> fetchListByProvider(){
        products = new ArrayList<Product>();
        try {
            HttpService.get("products/", null, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // If the response is JSONObject instead of expected JSONArray
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                    // Pull out the first event on the public timeline
                    JSONObject firstEvent = null;
                    int productId = -1;
                    String productName = null;
                    int providerId = -1;
                    String providerName = null;
                    String providerType = null;
                    double price = -1;
                    String productType = null;
                    try {
                        for(int i = 0; i < timeline.length(); i++) {
                            firstEvent = (JSONObject) timeline.get(i);
                            productId = firstEvent.getInt("productId");
                            productName = firstEvent.getString("productName");
                            price = firstEvent.getDouble("price");
                            providerId = firstEvent.getJSONObject("productProvider").getInt("providerId");
                            providerName = firstEvent.getJSONObject("productProvider").getString("providerName");
                            providerType = firstEvent.getJSONObject("productProvider").getString("providerType");
                            productType = firstEvent.getString("productType");
                            Product product = new Product(
                                    productId,
                                    productName,
                                    new Provider(providerId, providerName, providerType),
                                    price,
                                    productType
                            );
                            if(product.getProductType().toLowerCase().contains(searchParam.toLowerCase())) {
                                products.add(product);
                                System.out.println("Found one!");
                                System.out.println(product.getProductName());
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // Do something with the response
                    System.out.println("Entire data is: " + firstEvent);
                }
            });
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

}

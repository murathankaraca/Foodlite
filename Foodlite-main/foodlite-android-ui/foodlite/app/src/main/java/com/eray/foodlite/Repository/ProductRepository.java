package com.eray.foodlite.Repository;

import com.eray.foodlite.Models.Product;
import com.eray.foodlite.Models.Provider;
import com.eray.foodlite.Services.HttpService;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ProductRepository {

    public static ProductRepository Instance;

    private List<Product> products;

    public ProductRepository() {
        if(Instance == null) {
            Instance = this;
            products = fetchList();
        }
    }

    public List<Product> getProductsByProviderName(String providerName) {
        products = new ArrayList<Product>();
        try {
            HttpService.get("products/provider/" + providerName, null, new JsonHttpResponseHandler() {
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
                            products.add(product);
                            System.out.println(product.getProductName());
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

    public List<Product> getProductsByName(String productName) {
        products = new ArrayList<Product>();
        return products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public List<Product> fetchList(){
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
                    String productType = null;
                    double price = -1;
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
                            products.add(product);
                            System.out.println(product.getProductName());
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

    public List<Product> fetchListByName(String name){
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
                            if(product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                                products.add(product);
                                System.out.println("DONE! ");
                            }
                            System.out.println(product.getProductName());
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

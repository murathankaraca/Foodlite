package com.eray.foodlite.Services;

import com.loopj.android.http.*;

public class HttpService {
    // EGER BASKA WIFI BAGLANTISI UZERINDEN SUNUCU KURULURSA IP4 ADRESI DEGISMELI!
    private static final String IP4ADDRESS = "192.168.1.100";
    private static final String PORT = "8080";

    private static final String BASE_URL = "http://" + IP4ADDRESS + ":" + PORT  + "/foodlite/api/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.delete(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
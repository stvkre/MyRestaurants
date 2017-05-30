package com.example.stephen.myrestaurants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class YelpService {
    private static OkHttpClient client = new OkHttpClient();

    public static void findRestaurants(String location, Callback callback) {

        // Buiiding the Request URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        // creatng a new request with OkHttp

        Request request= new Request.Builder()
                .header("Authorization", "Bearer " + Constants.YELP_TOKEN)
                .url(url)
                .build();

        // calling a request asynchronously
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}




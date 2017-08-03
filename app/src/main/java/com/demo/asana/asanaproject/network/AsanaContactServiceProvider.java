package com.demo.asana.asanaproject.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mastertao on 7/25/17.
 */

public class AsanaContactServiceProvider {
    private static AsanaContactService asanaContactService;

    public synchronized static AsanaContactService getAsanaContactService(){
        if (asanaContactService != null){
            return asanaContactService;
        }

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://asa.na")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        if (asanaContactService == null) {
            asanaContactService = retrofit.create(AsanaContactService.class);
        }

        return asanaContactService;
    }
}

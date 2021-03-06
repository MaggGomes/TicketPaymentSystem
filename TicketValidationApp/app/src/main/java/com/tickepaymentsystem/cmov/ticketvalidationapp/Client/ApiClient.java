package com.tickepaymentsystem.cmov.ticketvalidationapp.Client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit INSTANCE = null;
    private static String BASE_URL = "http://localhost:8000/api/";

    public static Retrofit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return INSTANCE;
    }
}

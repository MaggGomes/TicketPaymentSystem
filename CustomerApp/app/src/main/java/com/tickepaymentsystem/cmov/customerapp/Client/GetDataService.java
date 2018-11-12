package com.tickepaymentsystem.cmov.customerapp.Client;

import com.tickepaymentsystem.cmov.customerapp.Models.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
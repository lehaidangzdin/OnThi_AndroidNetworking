package com.lhd.onthi.network;

import com.lhd.onthi.model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("getall.json")
    Call<ProductResponse> getProduct();
}

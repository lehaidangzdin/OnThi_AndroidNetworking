package com.lhd.onthi.network;

import com.lhd.onthi.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("albums")
    Call<List<Album>> getAlbums();
}

package com.lhd.onthi.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.lhd.onthi.R;
import com.lhd.onthi.adapter.AlbumAdapter;
import com.lhd.onthi.databinding.ActivityMainBinding;
import com.lhd.onthi.model.Album;
import com.lhd.onthi.network.ApiService;
import com.lhd.onthi.network.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getAlbum();
    }

    private void getAlbum() {
        apiService = RetroClient.getInstance().create(ApiService.class);
        apiService.getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                binding.process.setVisibility(View.GONE);
                displayRCV(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayRCV(List<Album> response) {
        AlbumAdapter albumAdapter = new AlbumAdapter(response);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.rcv.setLayoutManager(manager);
        binding.rcv.setAdapter(albumAdapter);


    }


    public void bai02(View view) {
    }
}
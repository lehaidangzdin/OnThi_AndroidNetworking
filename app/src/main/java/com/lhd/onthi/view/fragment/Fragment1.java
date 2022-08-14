package com.lhd.onthi.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.lhd.onthi.adapter.ProductAdapter;
import com.lhd.onthi.databinding.Fragment1Binding;
import com.lhd.onthi.model.Product;
import com.lhd.onthi.model.ProductResponse;
import com.lhd.onthi.network.ApiService;
import com.lhd.onthi.network.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class Fragment1 extends Fragment {
    private static final String TAG = Fragment1.class.getSimpleName();

    private Fragment1Binding binding;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);
        getProduct();
        return binding.getRoot();
    }

    public void getProduct() {
        ApiService apiService = RetroClient.getInstance().create(ApiService.class);
        apiService.getProduct().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductResponse> call, @NonNull retrofit2.Response<ProductResponse> response) {
                ProductResponse productResponse = response.body();
                assert productResponse != null;
                displayRecycleView(productResponse.getProducts());
            }

            @Override
            public void onFailure(@NonNull Call<ProductResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void displayRecycleView(List<Product> lsProducts) {
        binding.process.setVisibility(View.GONE);
        ProductAdapter adapter = new ProductAdapter(lsProducts);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        binding.rcv.setLayoutManager(manager);
        binding.rcv.setAdapter(adapter);

        double averagePrice = handlerPrice(lsProducts);
        binding.tvAverageProduct.setText("Gia trung binh: " + averagePrice);
//        Toast.makeText(this, "" + averagePrice, Toast.LENGTH_SHORT).show();
    }

    private double handlerPrice(List<Product> lsProducts) {
        double averagePrice = 0;

        for (Product product : lsProducts) {
            averagePrice += Double.parseDouble(product.getPrice());
        }
        averagePrice = averagePrice / lsProducts.size() + 1;
        Log.e("TAG", "handlerPrice: " + averagePrice);

        return averagePrice;
    }
}
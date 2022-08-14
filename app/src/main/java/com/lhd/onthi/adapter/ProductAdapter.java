package com.lhd.onthi.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lhd.onthi.databinding.ItemProductBinding;
import com.lhd.onthi.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> lsProducts;

    public ProductAdapter(List<Product> lsProducts) {
        this.lsProducts = lsProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding itemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product product = lsProducts.get(position);
        if (product == null) return;
        holder.binding.setItem(product);

    }

    @Override
    public int getItemCount() {
        return lsProducts != null ? lsProducts.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemProductBinding binding;

        public ViewHolder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}

package com.lhd.onthi.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lhd.onthi.databinding.ItemAlbumBinding;
import com.lhd.onthi.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> lsAlbums ;

    public AlbumAdapter(List<Album> lsAlbums) {
        this.lsAlbums = lsAlbums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAlbumBinding itemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemAlbumBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Album album = lsAlbums.get(position);
        if (album == null) return;
        holder.binding.setItem(album);

    }

    @Override
    public int getItemCount() {
        return lsAlbums != null ? lsAlbums.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemAlbumBinding binding;

        public ViewHolder(@NonNull ItemAlbumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}

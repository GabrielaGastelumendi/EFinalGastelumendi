package com.gabriela.efinal.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gabriela.efinal.databinding.ItemShowBinding;
import com.gabriela.efinal.model.Shows;

import java.util.List;
public class RVShowAdapter extends RecyclerView.Adapter<RVShowAdapter.ShowViewHolder> {

    private List<Shows> shows;
    private FavoriteClick favoriteClick;

    public RVShowAdapter(List<Shows> shows, FavoriteClick favoriteClick) {
        this.shows = shows;
        this.favoriteClick = favoriteClick;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowBinding binding = ItemShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new ShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        holder.bind(shows.get(position));

    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder{

        private ItemShowBinding binding;

        public ShowViewHolder(@NonNull ItemShowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        //Iteracción con el boton favoritos
        public void bind(Shows show) {
            binding.txtName.setText(show.getName());
            binding.btnFavorite.setOnClickListener(v -> {
                favoriteClick.onClick(show);
            });
            Glide.with(itemView.getContext()).load(show.getImgUrl()).into(binding.show);
        }
    }

    public interface FavoriteClick{
        public void onClick(Shows show);

    }
}



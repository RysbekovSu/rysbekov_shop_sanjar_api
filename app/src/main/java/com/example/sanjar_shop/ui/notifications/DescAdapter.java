package com.example.sanjar_shop.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.sanjar_shop.R;
import com.example.sanjar_shop.databinding.ItemDescCardBinding;
import com.example.sanjar_shop.model.ModelM;

import java.util.ArrayList;
import java.util.List;

public class DescAdapter extends RecyclerView.Adapter<DescAdapter.ViewHolder> {
    ItemDescCardBinding binding;
    Context context;

    List<ModelM> listD = new ArrayList<>();
    public void setListD(List<ModelM> listD) {
        this.listD = listD;
    }

    public DescAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemDescCardBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(listD.get(position));

    }





    @Override
    public int getItemCount() {
        return listD.size();
    }



    public  class ViewHolder extends  RecyclerView.ViewHolder{

        ItemDescCardBinding binding;
        public ViewHolder(@NonNull ItemDescCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView; // Проинициализировать binding в конструкторе ViewHolder
        }

        public void onBind(ModelM furnitureModel) {
            binding.nameCard.setText(furnitureModel.getTitle());
            binding.priceCard.setText(String.valueOf(furnitureModel.getPrice()));
            binding.descriptionCard.setText(furnitureModel.getDescription());
            Glide.with(context)
                    .load(listD.get(getAdapterPosition()).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imageCard);
        }
    }
}

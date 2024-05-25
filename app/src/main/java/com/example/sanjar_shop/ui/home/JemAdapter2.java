package com.example.sanjar_shop.ui.home;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanjar_shop.R;
import com.example.sanjar_shop.databinding.ItemProductBinding;
import com.example.sanjar_shop.model.CMODEL;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class JemAdapter2 extends RecyclerView.Adapter<JemAdapter2.ViewHolder> {
    ItemProductBinding itemProductBinding;
    Context context;
    List<CMODEL> list;
    ArrayList<CMODEL> selected_list = new ArrayList<>();
    ArrayList<CMODEL> selected_intoBacketList = new ArrayList<>();

    NavController navController;


    public JemAdapter2(Context context, List<CMODEL> list) {
        this.context = context;
        this.list = list;
    }


    public ArrayList<CMODEL> getSelected_intoBacketList() {
        return selected_intoBacketList;
    }

    @NonNull
    @Override
    public JemAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull JemAdapter2.ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();  // Проверка на null перед вызовом size()
        } else {
            return 0;  // Или возвращайте другое значение по умолчанию
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding itemProductBinding;

        public ViewHolder(@NonNull ItemProductBinding itemView) {
            super(itemView.getRoot());
            this.itemProductBinding = itemView;
        }

        public void onBind(CMODEL CMODEL) {
            itemProductBinding.nameProductCard.setText(CMODEL.getModelId());
            itemProductBinding.priceCard.setText(String.valueOf(CMODEL.getModelName()));

//            itemProductBinding.btnZoom.setOnClickListener(v->{
//                selected_list.add(CMODEL);
//                Bundle bundle = new Bundle();
//                bundle.putParcelableArrayList("favorite", selected_list);
//
//                navController = Navigation.findNavController((Activity) itemView.getContext(), R.id.nav_host_fragment_activity_main);
//                navController.navigate(R.id.descriptionFragment, bundle);
//                Log.e("TAG", "pass data to description!");
//            });
//




            itemView.setOnClickListener(v1 -> {
                if (itemProductBinding.tovarFavoriteCheck.getVisibility()== View.INVISIBLE){
                    itemProductBinding.tovarFavoriteCheck.setVisibility(View.VISIBLE);
                    selected_intoBacketList.add(CMODEL);


                }else {
                    itemProductBinding.tovarFavoriteCheck.setVisibility(View.INVISIBLE);
                    selected_intoBacketList.remove(CMODEL);
                }
            } );
        }

    }
}

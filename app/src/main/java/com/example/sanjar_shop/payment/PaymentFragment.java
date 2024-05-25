package com.example.sanjar_shop.payment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sanjar_shop.R;
import com.example.sanjar_shop.databinding.FragmentPaymentBinding;
import com.example.sanjar_shop.model.Order;
import com.example.sanjar_shop.remote_data.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentFragment extends Fragment {

    FragmentPaymentBinding binding;
    NavController navController;
    List<Order> payed_list;
    SharedPreferences preferences;


    public PaymentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPaymentBinding
                .inflate(inflater, container, false);
        preferences=getActivity()
                .getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        View root = binding.getRoot();
        if (getArguments() != null) {
            payed_list = getArguments().getParcelableArrayList("payed");
        }
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.cardVisa.setOnClickListener(v -> {
//            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cis.visa.com/"));
//            startActivity(myIntent);
//        });
//        binding.cardMastercard.setOnClickListener(v -> {
//            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/"));
//            startActivity(myIntent);
//        });
//        binding.cardMBank.setOnClickListener(v -> {
//            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mbank.kg/"));
//            startActivity(myIntent);
//        });
//        binding.cardGoogle.setOnClickListener(v -> {
//            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=kg.o.nurtelecom/"));
//            startActivity(myIntent);
//        });

        binding.btnBack.setOnClickListener(v -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_paymentFragment_to_navigation_home);
        });
        binding.btnBack.setOnClickListener(v1 -> {
            navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_paymentFragment_to_navigation_home);});

        binding.btnPayFinally.setOnClickListener(v2 -> {
            binding.progressBar.setVisibility(View.VISIBLE);
            try{
                for (int i = 0; i < payed_list.size(); i++) {
                    Call<Order> apiCall = RetrofitBuilder.getInstance()
                            .getApi().createNewOrder(payed_list.get(i));
                    apiCall.enqueue(new Callback<Order>() {
                        @Override
                        public void onResponse(Call<Order> call, Response<Order> response) {
                            if (response.isSuccessful()) {
                                if (response.body() != null) {
                                    binding.progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(requireActivity(), "Order is successful!", Toast.LENGTH_LONG).show();
                                    SharedPreferences.Editor prefLoginEdit = preferences.edit();
                                    prefLoginEdit.putBoolean("Order", true);
                                    prefLoginEdit.commit();
                                    binding.tvOtvet.setText("Ваш заказ принят доставка  составляет от 5 до 12 дней." );

                                }
                            } else {
                                Log.e("fail", "fail");
                                Toast.makeText(requireActivity(), "Order is not available now", Toast.LENGTH_LONG).show();
                            }

                        }
                        @Override
                        public void onFailure(Call<Order> call, Throwable throwable) {
                            Toast.makeText(requireActivity(), "Order is not available now", Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }catch (Exception ex){
                Log.e("TAG",ex.toString());
                Toast.makeText(requireActivity(), "Товары не выбраны", Toast.LENGTH_LONG).show();
            }
//            binding.tvOtvet.setText("Ваш заказ в обработке, доставка  составляет от 5 до 12 дней." );
        });
    }
}
package com.example.rysbekov_shop_api.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.airbnb.lottie.LottieDrawable;
import com.example.rysbekov_shop_api.databinding.FragmentHomeBinding;
import com.example.rysbekov_shop_api.model.ModelM;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    JemAdapter jemAdapter;

    HomeViewModel homeViewModel;

    NavController navController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeViewModel.getModeResponseLiveData().observe(
                getViewLifecycleOwner(), new Observer<List<ModelM>>() {
                    @Override
                    public void onChanged(List<ModelM> modelMS) {
                        binding.progressBar.setVisibility(View.INVISIBLE);
                        jemAdapter = new JemAdapter(requireActivity(), modelMS);
                        binding.rvCatalogM.setAdapter(jemAdapter);
                    }
                }
        );
        //setUpBackPressed();
//        setUpOnBackPressed();
      return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.basketBtn.
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.sanjar_shop.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.sanjar_shop.model.CMODEL;
import com.example.sanjar_shop.model.ModelM;
import com.example.sanjar_shop.repositories.JemRepositoty;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private JemRepositoty jemRepositoty;

    private  LiveData<List<ModelM>> modelMResponseLiveData;
//    private  LiveData<List<CMODEL>> modelMResponseLiveData2;
    public HomeViewModel() {
        jemRepositoty = new JemRepositoty();
        modelMResponseLiveData = jemRepositoty.getDashJeminyList();
//        jemRepositoty2 = new JemRepositoty2();
//        modelMResponseLiveData2 = jemRepositoty2.getDashJeminyList();
    }

    public LiveData<List<ModelM>> getModeResponseLiveData() {
        return modelMResponseLiveData;
    }

//    public LiveData<List<CMODEL>> getModeResponseLiveData() {
//        return modelMResponseLiveData2;
//    }
}
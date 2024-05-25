//package com.example.sanjar_shop.repositories;
//
//import android.util.Log;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.sanjar_shop.model.CMODEL;
//import com.example.sanjar_shop.remote_data.RetrofitBuilder;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class JemRepositoty2 {
//
//    final MutableLiveData<List<CMODEL>> data = new MutableLiveData<>();
//
//    public LiveData<List<CMODEL>> getDashJeminyList() {
//        Call<List<CMODEL>> apiCall = RetrofitBuilder.getInstance().getApi().get();
//
//        apiCall.enqueue(new Callback<List<CMODEL>>() {
//            @Override
//            public void onResponse(Call<List<CMODEL>> call, Response<List<CMODEL>> response) {
//                if (response.body() != null) {
//                    data.postValue(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<CMODEL>> call, Throwable throwable) {
//                Log.e("TAG", "NO DATA" + throwable.getLocalizedMessage());
//                data.postValue(null);
//            }
//
//        });
//        return data;
//    }
//
//
//}
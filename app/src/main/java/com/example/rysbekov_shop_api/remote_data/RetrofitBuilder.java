package com.example.rysbekov_shop_api.remote_data;


import com.example.rysbekov_shop_api.constant.ConstantApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private  Api api;
    private static RetrofitBuilder instance = null;



    private RetrofitBuilder() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ConstantApi.BASE_URl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
                api = retrofit.create(Api.class);
    }


    public static synchronized RetrofitBuilder getInstance(){
        if(instance==null){
            instance = new RetrofitBuilder();
        }
        return instance;
    }

    public Api getApi(){
        return api;
    }
}

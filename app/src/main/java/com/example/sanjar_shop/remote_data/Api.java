package com.example.sanjar_shop.remote_data;


import com.example.sanjar_shop.model.CMODEL;
import com.example.sanjar_shop.model.CurrentUser;
import com.example.sanjar_shop.model.LoginResponse;
import com.example.sanjar_shop.model.ModelM;
import com.example.sanjar_shop.model.Order;
import com.example.sanjar_shop.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface Api {
    @GET("api/v1/product/all")Call<List<ModelM>> getStoreProducts();
    @POST("api/v1/product/create/")Call<ModelM> createNewProduct();
    @GET("api/v1/product/{id}/")
    Call<ModelM> getProductById();
    @PUT("api/v1/product/{id}/")Call<ModelM> updateProductById();
    @DELETE("api/v1/product/{id}/")Call<ModelM> deleteProductById();
    @PATCH("api/v1/product/{id}/")Call<ModelM> changeProductById();
    @POST("api/v1/auth/register")Call<User> registrationNewUser(@Body User user);
    @POST("api/v1/auth/login")Call<LoginResponse> checkLoginUser(@Body CurrentUser currentUser);
    @POST("api/v1/auth/logout")Call<User> makeLogOutUser();
    @POST("api/v1/order/create/")Call<Order> createNewOrder(@Body  Order order);
    @GET("api/v1/order/all")
    Call<List<Order>> getAllOrders();}
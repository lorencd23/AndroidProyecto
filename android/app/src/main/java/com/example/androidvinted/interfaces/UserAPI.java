package com.example.androidvinted.interfaces;

import com.example.androidvinted.model.pojo.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPI {
    @FormUrlEncoded
    @POST("register")
    Call<User> REGISTER_CALL(
            @Field("name") String name,
            @Field("mail") String mail,
            @Field("pass") String pass
    );

    @FormUrlEncoded
    @POST("login")
    Call<User>LOGIN_CALL(
            @Field("name") String name,
            @Field("mail") String mail,
            @Field("pass") String pass
    );

}

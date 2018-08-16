package com.shy.androidjinjiezhiguang;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ShangHongyu on 2018/8/3.
 */
public interface IPService {
    @GET("123")
    Call<String> getGetStrings();
    @POST("123")
    Call<String> getPostString();
}

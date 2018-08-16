package com.shy.androidjinjiezhiguang;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ShangHongyu on 2018/8/3.
 */
public class RetrofitTest {
    String url = "http://www.baidu.com/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    IPService ipService=retrofit.create(IPService.class);
    String stringCall=ipService.getGetStrings();


}

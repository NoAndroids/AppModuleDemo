package com.shy.retrofittest;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by ShangHongyu on 2018/8/4.
 */
public interface IpService {
    @GET("123")
    Call<String> getGetStrings();
    @POST("123")
    Call<String> getPostString();
    @GET("{path}/123")
    Call<String> getPathString(@Path("path") String path);
    @GET("123")
    Call<String> getQueryString(@Query("id") String id);
    @GET("123")
    Call<String> getQueryMapString(@QueryMap Map<String, String > map);
    @FormUrlEncoded
    @POST("123")
    Call<String> getFiledString(@Field("id") String id);
    @POST("123")
    Call<String> getBodyString(@Body BodyParams bodyParams);
    @Multipart //表示允许多个part
    Call<String> getPartString(@Part MultipartBody.Part photo, @Part("description")RequestBody description);
    @Multipart
    Call<String> getPartMapString(@PartMap Map<String,RequestBody> photo,@Part("description") RequestBody description);
}

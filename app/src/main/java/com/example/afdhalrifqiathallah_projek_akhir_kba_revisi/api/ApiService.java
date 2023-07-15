package com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api;

import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.dataMahasiswa.ResponseDataMahasiswa;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.login.ResponseLogin;
import com.example.afdhalrifqiathallah_projek_akhir_kba_revisi.api.models.register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("getMahasiswa")
    Call<ResponseDataMahasiswa> getDataMahasiswa();

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> requestLogin(@Field("email") String email,
                                     @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> requestRegister(@Field("username") String username,
                                           @Field("email") String email,
                                           @Field("password") String password);
}

package com.gabriela.efinal.data.retrofit;

import com.gabriela.efinal.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogInterface {
    @GET("198c5b07-ca0b-418f-acfe-4d7248d2c97d")
    Call<ShowResponse> getShow();
}


package com.example.sawaari.APIPlaceHolder;

import java.util.List;

import com.example.sawaari.CityData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface RentalPlaceHolder {

    @GET("city")
    Call<List<CityData>> getCity();



}

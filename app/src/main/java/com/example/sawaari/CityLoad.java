package com.example.sawaari;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.example.sawaari.APIPlaceHolder.RentalPlaceHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class CityLoad extends AppCompatActivity {

    private RentalPlaceHolder rentalPlaceHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        String url="http://192.168.1.70:8000/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        rentalPlaceHolder = retrofit.create(RentalPlaceHolder.class);





    }


    private void getCity(){
        Call<List<CityData>> call = rentalPlaceHolder.getCity();
        call.enqueue(new Callback<List<CityData>>() {
            @Override
            public void onResponse(Call<List<CityData>> call, Response<List<CityData>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(CityLoad.this, "Code: "+response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<CityData> getCityList = response.body();
                CityDataAdapter cityDataAdapter = new CityDataAdapter(CityLoad.this,getCityList);

            }

            @Override
            public void onFailure(Call<List<CityData>> call, Throwable t) {
                Toast.makeText(CityLoad.this, "Failure: "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}

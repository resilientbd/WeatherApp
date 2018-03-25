package bnlive.in.weatherapp.retrofit;

/**
 * Created by Sk Faisal on 3/25/2018.
 */

import java.util.List;

import bnlive.in.weatherapp.responsemodel.Weather;
import bnlive.in.weatherapp.responsemodel.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SOService {

    @GET("weather?q=dhaka,bd&APPID=e6f0df6107710b741c0c1f8e09222564")
    Call<WeatherData> getData();


}
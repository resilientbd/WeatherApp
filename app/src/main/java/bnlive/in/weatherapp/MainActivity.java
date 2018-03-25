package bnlive.in.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import bnlive.in.weatherapp.responsemodel.Weather;
import bnlive.in.weatherapp.responsemodel.WeatherData;
import bnlive.in.weatherapp.retrofit.ApiUtils;
import bnlive.in.weatherapp.retrofit.SOService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
String TAG="retrofit";
private SOService mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService= ApiUtils.getSOService();
        mService.getData().enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if(response.isSuccessful()){
                    WeatherData data=response.body();
                    Log.d(TAG,"Success: "+data.toString());
                }
              else
                {
                    Log.d(TAG,"Error: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                                Log.d(TAG,"Failed: "+t);
            }
        });
//        mService.getData("dhaka,bn").enqueue(new Callback<WeatherData>() {
//            @Override
//            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
//                if(response.isSuccessful()){
//                    WeatherData data=response.body();
//                    Log.d(TAG,"Success: "+data.toString());
//                }
//              else
//                {
//                    Log.d(TAG,"Error: "+response.code());
//                }
//            }


//            @Override
//            public void onFailure(Call<WeatherData> call, Throwable t) {
//                Log.d(TAG,"Failed: "+t);
//            }
//        });

    }
}

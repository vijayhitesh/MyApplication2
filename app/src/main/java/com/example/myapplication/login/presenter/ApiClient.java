package com.example.myapplication.login.presenter;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static Retrofit retrofit = null;


  //public static final String GOOGLE_PLACE_API_KEY = "AIzaSyAl6cdxB9pZJkEd3Vw1SbUlyR2IFyXUu3k";
   public static final String GOOGLE_PLACE_API_KEY = "AIzaSyB_O3out_MkHuaILqdl77XJ_QAm6fTd52A";

    public static String base_url = "https://maps.googleapis.com/maps/api/";
    //public static String base_url = "https://console.cloud.google.com/google/maps-apis/api-list?folder=&organizationId=&project=easyroads";

    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptor).build();


        retrofit = null;

        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }
}

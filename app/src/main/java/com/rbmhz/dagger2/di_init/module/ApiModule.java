package com.rbmhz.dagger2.di_init.module;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rbmhz.dagger2.di_init.component.NetworkInterface;
import com.rbmhz.dagger2.di_init.scope.Scope;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    String baseUrl = "http://jsonplaceholder.typicode.com/";
    Gson gson = new GsonBuilder().setLenient().create();

    @Provides
    @Scope
    OkHttpClient provideOkHttpClient() {
        try {
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            client.connectTimeout(70, TimeUnit.SECONDS)
                    .readTimeout(70, TimeUnit.SECONDS)
                    .writeTimeout(70, TimeUnit.SECONDS);

            return client.build();
        } catch (Exception e) {
            Log.d("Exception==>", e.toString());
        }
        return null;
    }


    @Provides
    @Scope
    NetworkInterface provideNetworkService(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build().create(NetworkInterface.class);
    }
}

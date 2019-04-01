package com.rbmhz.dagger2.di_init.component;

import com.rbmhz.dagger2.di_init.scope.Scope;
import com.rbmhz.dagger2.pojo.Resp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

@Scope
public interface NetworkInterface {

    @GET("albums")
    Call<ArrayList<Resp.data>> getDatas();

}

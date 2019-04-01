package com.rbmhz.dagger2.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.rbmhz.dagger2.R;
import com.rbmhz.dagger2.di_init.component.NetworkInterface;
import com.rbmhz.dagger2.helper.App;
import com.rbmhz.dagger2.pojo.Resp;
import com.rbmhz.dagger2.views.adapter.recycleView;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    NetworkInterface apiService;

    private recycleView mAdapter;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);

        ((App) getApplication()).get(this).getNetComponent().inject(this);
        callApis();

    }

    private void callApis() {
        apiService.getDatas().enqueue(new Callback<ArrayList<Resp.data>>() {
            @Override
            public void onResponse(Call<ArrayList<Resp.data>> call, Response<ArrayList<Resp.data>> response) {
                Log.d("Response==>", new Gson().toJson(response.body()));
                mAdapter = new recycleView(response.body());
                rv.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Resp.data>> call, Throwable t) {
                Log.d("onFailure==>", t.getMessage());

            }
        });
    }
}

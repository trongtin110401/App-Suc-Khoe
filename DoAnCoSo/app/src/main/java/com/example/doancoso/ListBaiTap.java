package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.doancoso.Adapter.AdapterBaiTap;
import com.example.doancoso.Adapter.AdapterFood;
import com.example.lib.Model.BaitapModel;
import com.example.lib.Model.ThucAnModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBaiTap extends AppCompatActivity {
    ListView listbt;
    AdapterBaiTap adapterBaiTap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bai_tap);
        listbt = findViewById(R.id.listbaitap);
        adapterBaiTap = new AdapterBaiTap(ListBaiTap.this, R.layout.itembaitap);
        Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
        Call<BaitapModel[]> call = methods.getbaitap();
        call.enqueue(new Callback<BaitapModel[]>() {
            @Override
            public void onResponse(Call<BaitapModel[]> call, Response<BaitapModel[]> response) {
                BaitapModel[] data = response.body();
                for (BaitapModel dt : data) {
                    adapterBaiTap.add(dt);
                }
            }

            @Override
            public void onFailure(Call<BaitapModel[]> call, Throwable t) {

            }
        });
        listbt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BaitapModel temp = adapterBaiTap.getItem(i);
                Intent intent = new Intent(ListBaiTap.this,ChiTietBaiTap.class);
                intent.putExtra("key_4",temp.getIdbaitap());
                intent.putExtra("key_11",temp.getTenbaitap());
                intent.putExtra("key_2",temp.getHinhanh());
                intent.putExtra("key_3",temp.getSocalomoigio());
                startActivity(intent);
            }
        });
        listbt.setAdapter(adapterBaiTap);
    }
}
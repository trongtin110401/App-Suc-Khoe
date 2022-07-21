package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.doancoso.Adapter.AdapterFood;
import com.example.lib.Model.ThucAnModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListThucAn extends AppCompatActivity {
    ListView listfood;
    AdapterFood adapterFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_thuc_an);
        Intent intent = getIntent();
        int idbuoi = intent.getIntExtra("key_1",0);
        listfood = findViewById(R.id.lvfood);
        adapterFood = new AdapterFood(ListThucAn.this, R.layout.itemthucan);
        Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
        Call<ThucAnModel[]> call = methods.getdata();

        call.enqueue(new Callback<ThucAnModel[]>() {
            @Override
            public void onResponse(Call<ThucAnModel[]> call, Response<ThucAnModel[]> response) {
                ThucAnModel[] data = response.body();
                for (ThucAnModel dt : data) {
                    adapterFood.add(dt);
                }
            }

            @Override
            public void onFailure(Call<ThucAnModel[]> call, Throwable t) {

            }
        });
        listfood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThucAnModel temp = adapterFood.getItem(i);
                Intent intent = new Intent(ListThucAn.this,ChiTietThucAn.class);
                intent.putExtra("key_7",temp.getIdthucan());
                intent.putExtra("key_1",temp.getTenthucan());
                intent.putExtra("key_2",temp.getCacboyhidrate());
                intent.putExtra("key_3",temp.getImgthucan());
                intent.putExtra("key_4",temp.getLuongcalo());
                intent.putExtra("key_5",temp.getProtein());
                intent.putExtra("key_6",temp.getChatbeo());
                intent.putExtra("key_10",idbuoi);
                startActivity(intent);
            }
        });
        listfood.setAdapter(adapterFood);
    }
}
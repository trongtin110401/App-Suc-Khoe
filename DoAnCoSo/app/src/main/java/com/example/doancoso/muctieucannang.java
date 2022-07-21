package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lib.Model.CanhanModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class muctieucannang extends AppCompatActivity {
    EditText cannang,cannangmuctieu;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muctieucannang);
        btn2 = findViewById(R.id.button2);
        cannang = findViewById(R.id.editTextNumber6);
        cannangmuctieu = findViewById(R.id.editTextNumber7);

        Intent intent = getIntent();
        String ten = intent.getStringExtra("key_1");
        String tuoi = intent.getStringExtra("key_2");
        String chieucao = intent.getStringExtra("key_3");
        String gt = intent.getStringExtra("key_4");
        int id = intent.getIntExtra("key_5",0);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
                CanhanModel temp = new CanhanModel();
                temp.setIdcanhan(id);
                temp.setTen(ten);
                temp.setGioitinh(gt);
                temp.setTuoi(tuoi);
                temp.setCannang(Float.parseFloat(cannang.getText().toString()));
                temp.setCannangmuctieu(Float.parseFloat(cannangmuctieu.getText().toString()));
                Call<CanhanModel> call = methods.postcanhan(temp);

                call.enqueue(new Callback<CanhanModel>() {
                    @Override
                    public void onResponse(Call<CanhanModel> call, Response<CanhanModel> response) {

                    }

                    @Override
                    public void onFailure(Call<CanhanModel> call, Throwable t) {

                    }
                });
                Intent intent1 = new Intent(muctieucannang.this,MainActivity.class);
                startActivity(intent1);
            }
        });


    }
}
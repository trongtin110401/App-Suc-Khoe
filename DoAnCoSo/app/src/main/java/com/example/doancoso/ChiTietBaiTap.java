package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib.Model.ChitietBT;
import com.example.lib.Model.ChitiettapluyenModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietBaiTap extends AppCompatActivity {
    ImageView imageView;
    EditText calo,ten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bai_tap);
        Calendar calendar = Calendar.getInstance();
        String CurrentDate = DateFormat.getDateInstance().format(calendar.getTime());
        imageView = findViewById(R.id.imageView);
        ten = findViewById(R.id.editTextTextPersonName4);
        calo = findViewById(R.id.editTextNumber5);
        ImageButton add = findViewById(R.id.imageButton3);
        EditText thoigian = findViewById(R.id.editTextNumber4);
        Intent intent = getIntent();
        int idbt = (int)intent.getFloatExtra("key_4",-1);
        String a = intent.getStringExtra("key_11");
        String b = intent.getStringExtra("key_2");
        float c = intent.getFloatExtra("key_3",1);
        Picasso.get().load(b).into(imageView);
        ten.setText(a);
        calo.setText(String.valueOf(c));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChitiettapluyenModel temp = new ChitiettapluyenModel();
                temp.setBaitap_idbaitap(idbt);
                temp.setThoigian(Float.valueOf(thoigian.getText().toString()));
                temp.setThongtincanhan_idcanhan(5);
                temp.setNgay(CurrentDate);
                Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
                Call<ChitiettapluyenModel> call = methods.postchitiettapluyen(temp);
                call.enqueue(new Callback<ChitiettapluyenModel>() {
                    @Override
                    public void onResponse(Call<ChitiettapluyenModel> call, Response<ChitiettapluyenModel> response) {

                    }

                    @Override
                    public void onFailure(Call<ChitiettapluyenModel> call, Throwable t) {

                    }
                });
                Intent intent1 = new Intent(ChiTietBaiTap.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
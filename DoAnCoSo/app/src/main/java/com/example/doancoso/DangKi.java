package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lib.Model.UserModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangKi extends AppCompatActivity {
    EditText name,tk,mk,email,mknhaplai;
    TextView Thongbao;
    Button dangKi,Huy;
    ArrayList<UserModel> userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        tk = findViewById(R.id.TK);
        mk = findViewById(R.id.MK);
        email = findViewById(R.id.Email);
        Thongbao = findViewById(R.id.txtThongBao);
        dangKi = findViewById(R.id.btnDangKi);
        Huy = findViewById(R.id.btnHuy);
        mknhaplai = findViewById(R.id.MKnhaplai);
        userAdapter = new ArrayList<>();
        Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
        Call<UserModel[]> call = methods.getUser();
        call.enqueue(new Callback<UserModel[]>() {
            @Override
            public void onResponse(Call<UserModel[]> call, Response<UserModel[]> response) {
                UserModel[] data = response.body();
                for (UserModel dt:data
                ) {
                    userAdapter.add(dt);
                }
            }

            @Override
            public void onFailure(Call<UserModel[]> call, Throwable t) {

            }
        });

        for (UserModel dt:userAdapter
        ) {
        }

        dangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUser();
            }
        });
        Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKi.this,DangNhap.class);
                startActivity(intent);
            }
        });
    }

    public void insertUser(){
        if( tk.getText().toString().isEmpty() || mk.getText().toString().isEmpty() || email.getText().toString().isEmpty()){
            Thongbao.setText("vui lòng nhập đầy đủ thông tin");
            return;
        } else {
            if(mknhaplai.getText().toString().equals(mk.getText().toString()))
            {

                Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
                UserModel temp = new UserModel();
                temp.setAccount(tk.getText().toString());
                temp.setPassword(mk.getText().toString());
                temp.setEmail(email.getText().toString());
                Intent intent = new Intent(DangKi.this,Verify.class);
                intent.putExtra("key_1",temp.getAccount());
                intent.putExtra("key_2",temp.getPassword());
                intent.putExtra("key_3",temp.getEmail());
                startActivity(intent);
            }else {
                Thongbao.setText("Mật khẩu nhập lại không chính xác");
                return;
            }
        }
    }
}
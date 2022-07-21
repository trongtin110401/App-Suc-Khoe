package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lib.Model.OtpModel;
import com.example.lib.Model.UserModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Verify extends AppCompatActivity {
    String otp;
    Button xn;
    EditText temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        xn = findViewById(R.id.button5);
        temp = findViewById(R.id.editTextNumber10);
        Intent intent = getIntent();
        String acc = intent.getStringExtra("key_1");
        String pass = intent.getStringExtra("key_2");
        String email = intent.getStringExtra("key_3");
        Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
        Call<OtpModel> call = methods.getOTP();
        call.enqueue(new Callback<OtpModel>() {
            @Override
            public void onResponse(Call<OtpModel> call, Response<OtpModel> response) {
                OtpModel data = response.body();
                otp =data.getMessage();
            }

            @Override
            public void onFailure(Call<OtpModel> call, Throwable t) {

            }
        });
        xn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("temp",temp.getText().toString());
                Log.v("otp",otp);
                if(temp.getText().toString().equals(otp.toString()))
                {
                    Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
                    UserModel temp = new UserModel();
                    temp.setAccount(acc);
                    temp.setPassword(pass);
                    temp.setEmail(email);
                    Call<UserModel> call = methods.postUser(temp);
                    call.enqueue(new Callback<UserModel>() {
                        @Override
                        public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        }
                        @Override
                        public void onFailure(Call<UserModel> call, Throwable t) {
                        }
                    });
                    Intent intent1 = new Intent(Verify.this,thongtincanhan.class);
                    intent1.putExtra("key_1",5);
                    startActivity(intent1);
                }
            }
        });
    }
}
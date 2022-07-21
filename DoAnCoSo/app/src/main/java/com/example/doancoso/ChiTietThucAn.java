package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doancoso.fragment.Homnay.FragmentChieu;
import com.example.doancoso.fragment.Homnay.FragmentSang;
import com.example.doancoso.fragment.Homnay.FragmentToi;
import com.example.doancoso.fragment.Homnay.FragmentTrua;
import com.example.doancoso.fragment.HomnayFragment;
import com.example.lib.Model.ChitietbuoianModel;
import com.example.lib.Model.UserModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietThucAn extends AppCompatActivity {
    ImageView imageView;
    TextView ten;
    EditText calo,car,chatbeo,pro,soluong;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_thuc_an);
        add = findViewById(R.id.button);
        soluong = findViewById(R.id.editTextNumber);
        imageView = findViewById(R.id.imgthucan);
        ten = findViewById(R.id.textView3);
        calo = findViewById(R.id.editTextNumber3);
        chatbeo = findViewById(R.id.editTextTextPersonName);
        car = findViewById(R.id.editTextTextPersonName2);
        pro = findViewById(R.id.editTextTextPersonName3);
        Intent intent = getIntent();
        int idthucan = (int) intent.getFloatExtra("key_7",0);
        String a = intent.getStringExtra("key_1");
        String c = intent.getStringExtra("key_3");
        int b =  (int)intent.getFloatExtra("key_2",1);
        float d =  intent.getFloatExtra("key_4",1);
        float e =  intent.getFloatExtra("key_5",1);
        float f =  intent.getFloatExtra("key_6",1);
        int idbuoi = intent.getIntExtra("key_10",0);
        Picasso.get().load(c).into(imageView);
        ten.setText(a);
        car.setText(String.valueOf(b));
        calo.setText(String.valueOf(d));
        pro.setText(String.valueOf(e));
        chatbeo.setText(String.valueOf(f));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
                ChitietbuoianModel temp = new ChitietbuoianModel();
                temp.setBuoi_idbuoi(idbuoi);
                temp.setThucan_idthucan(idthucan);
                temp.setSoluong(Integer.parseInt(soluong.getText().toString()));
                Call<ChitietbuoianModel> call = methods.postchitietbuoian(temp);
                call.enqueue(new Callback<ChitietbuoianModel>() {
                    @Override
                    public void onResponse(Call<ChitietbuoianModel> call, Response<ChitietbuoianModel> response) {

                    }

                    @Override
                    public void onFailure(Call<ChitietbuoianModel> call, Throwable t) {

                    }
                });
//                if(idbuoi==1)
//                {Intent intent1 = new Intent(ChiTietThucAn.this, HomnayFragment.class);
//                    startActivity(intent1);}
//                else if(idbuoi==2)
//                {Intent intent1 = new Intent(ChiTietThucAn.this, FragmentTrua.class);
//                    startActivity(intent1);}
//                else if(idbuoi==3)
//                {Intent intent1 = new Intent(ChiTietThucAn.this, FragmentChieu.class);
//                    startActivity(intent1);}
//                else if(idbuoi==4)
//                {Intent intent1 = new Intent(ChiTietThucAn.this, FragmentToi.class);
//                    startActivity(intent1);}
                Intent intent10 = new Intent(ChiTietThucAn.this,MainActivity.class);
                startActivity(intent10);
            }
        });
    }
}
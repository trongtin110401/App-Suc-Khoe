package com.example.doancoso.fragment.Homnay;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doancoso.Adapter.AdapterChitietTA;
import com.example.doancoso.Adapter.AdapterFood;
import com.example.doancoso.ListThucAn;
import com.example.doancoso.R;
import com.example.lib.Model.ChitietTA;
import com.example.lib.Model.ThucAnModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentToi extends Fragment {
    ListView listfood;
    AdapterChitietTA adapterFood;
    ImageButton add;
    TextView socalo;
    float tongcalo;
    public FragmentToi() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toi,container,false);
        listfood = view.findViewById(R.id.listfoodsang);
        adapterFood = new AdapterChitietTA(getActivity(), R.layout.itemthucan);
        add = view.findViewById(R.id.add);
        socalo= view.findViewById(R.id.textView33);
        Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
        Call<ChitietTA[]> call = methods.getfoodtoi();
        call.enqueue(new Callback<ChitietTA[]>() {
            @Override
            public void onResponse(Call<ChitietTA[]> call, Response<ChitietTA[]> response) {
                ChitietTA[] data = response.body();
                for (ChitietTA dt:data)
                {
                    adapterFood.add(dt);
                    tongcalo = tongcalo + (dt.getLuongcalo()*(dt.getSoluong()));
                }
                socalo.setText(String.valueOf(tongcalo));
            }

            @Override
            public void onFailure(Call<ChitietTA[]> call, Throwable t) {

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListThucAn.class);
                intent.putExtra("key_1",4);
                startActivity(intent);
            }
        });
        listfood.setAdapter(adapterFood);
        return view;
    }

}

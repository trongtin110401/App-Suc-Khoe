package com.example.doancoso.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doancoso.Adapter.AdapterBaiTap;
import com.example.doancoso.Adapter.AdapterChitietBT;
import com.example.doancoso.ChiTietBaiTap;
import com.example.doancoso.ListBaiTap;
import com.example.doancoso.R;
import com.example.lib.Model.BaitapModel;
import com.example.lib.Model.ChitietBT;
import com.example.lib.Model.ThucAnModel;
import com.example.lib.Repository.Methods;
import com.example.lib.Repository.RetrofitClient;

import java.text.DateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaiTapFragment extends Fragment {
    @Nullable
    AdapterChitietBT adapterBaiTap;
    float tongcalo;
    ListView listView;
    TextView socalo;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_baitap,container,false);
        Calendar calendar = Calendar.getInstance();
        String CurrentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textView = view.findViewById(R.id.textView30);
        socalo = view.findViewById(R.id.textView45);
        listView = view.findViewById(R.id.listbaitap1);
        textView.setText(CurrentDate);
        ImageButton button = view.findViewById(R.id.imageButton2);
        adapterBaiTap = new AdapterChitietBT(getActivity(), R.layout.itembaitap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ListBaiTap.class);
                startActivity(intent);
            }
        });
        Methods methods = RetrofitClient.getRetrofit().create(Methods.class);
        Call<ChitietBT[]> call = methods.getchitietbaitap();
        call.enqueue(new Callback<ChitietBT[]>() {
            @Override
            public void onResponse(Call<ChitietBT[]> call, Response<ChitietBT[]> response) {
                ChitietBT[] data = response.body();
                for (ChitietBT dt:data){
                    adapterBaiTap.add(dt);
                    tongcalo = tongcalo + (dt.getSocalomoigio()*(dt.getThoigian()/60));
                }
                socalo.setText(String.valueOf(tongcalo));
            }

            @Override
            public void onFailure(Call<ChitietBT[]> call, Throwable t) {

            }
        });
        listView.setAdapter(adapterBaiTap);

        return view;
    }
}

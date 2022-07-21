package com.example.doancoso.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doancoso.R;
import com.example.doancoso.momo;
import com.example.doancoso.thongtincanhan;
public class NangcapFrament extends Fragment {
    Button btn;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nangcap,container,false);
        btn = view.findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), momo.class);
                startActivity(intent);
            }
        });
        return view;
    }
}

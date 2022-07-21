package com.example.doancoso.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.doancoso.R;
import com.example.doancoso.thongtincanhan;

public class MucTieuFragment extends Fragment {
    TextView them;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentmuctieu,container,false);
        them =  view.findViewById(R.id.themmuctieu);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), thongtincanhan.class);
                intent.putExtra("key_1",5);
                startActivity(intent);
            }
        });
        return view;
    }
}

package com.example.doancoso.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doancoso.R;
import com.example.lib.Model.BaitapModel;
import com.example.lib.Model.ChitietBT;
import com.squareup.picasso.Picasso;

public class AdapterChitietBT extends ArrayAdapter<ChitietBT> {
    private final Activity context;
    int resource;

    public AdapterChitietBT(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource, null);
        ImageView imageView =view.findViewById(R.id.anhbaitap);
        TextView textView = view.findViewById(R.id.tenbaitap);
        ChitietBT baitapModel = getItem(position);
        Picasso.get().load(baitapModel.getHinhanh()).into(imageView);
        textView.setText(baitapModel.getTenbaitap());
        return view;
    }
}

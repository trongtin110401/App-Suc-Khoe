package com.example.doancoso.Adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.lib.Model.UserModel;

public class UserAdapter extends ArrayAdapter<UserModel> {
    Activity context;
    int resource;



    public UserAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
    }
}

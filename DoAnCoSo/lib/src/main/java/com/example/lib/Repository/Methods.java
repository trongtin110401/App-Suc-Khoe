package com.example.lib.Repository;

import com.example.lib.Model.BaitapModel;
import com.example.lib.Model.CanhanModel;
import com.example.lib.Model.ChitietBT;
import com.example.lib.Model.ChitietTA;
import com.example.lib.Model.ChitietbuoianModel;
import com.example.lib.Model.ChitiettapluyenModel;
import com.example.lib.Model.OtpModel;
import com.example.lib.Model.ThucAnModel;
import com.example.lib.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Methods {

    //food

    @GET("api/food")
    Call<ThucAnModel[]> getdata();
    @GET("api/foodsang")
    Call<ChitietTA[]> getfoodsang();
    @GET("api/foodtrua")
    Call<ChitietTA[]> getfoodtrua();
    @GET("api/foodchieu")
    Call<ChitietTA[]> getfoodchieu();
    @GET("api/foodtoi")
    Call<ChitietTA[]> getfoodtoi();
    @POST("api/postchitietbuoian")
    Call<ChitietbuoianModel> postchitietbuoian( @Body ChitietbuoianModel data);


    //user

    @GET("api/user")
    Call<UserModel[]> getUser();
    @POST("api/user")
    Call<UserModel> postUser(@Body UserModel data);

    //baitap

    @GET("api/baitap")
    Call<BaitapModel[]> getbaitap();
    @GET("api/baitapngay")
    Call<ChitietBT[]> getchitietbaitap();
    @POST("api/baitapngay")
    Call<ChitiettapluyenModel> postchitiettapluyen(@Body ChitiettapluyenModel data);
    //Verify

    @GET("otp")
    Call<OtpModel> getOTP();

    //canhan

    @GET("api/canhan")
    Call<CanhanModel[]> getcanhanh();
    @POST("api/canhan")
    Call<CanhanModel> postcanhan(@Body CanhanModel data);
}

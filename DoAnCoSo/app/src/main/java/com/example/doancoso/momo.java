package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import vn.momo.momo_partner.AppMoMoLib;

public class momo extends AppCompatActivity {
    Button btnThanhToan;

    private String amount = "150000";
    private String fee = "0";
    int environment = 0;//developer default
    private String merchantName = "DDTT";
    private String merchantCode = "MOMO7G3T20220616";
    private String merchantNameLabel = "Nhà cung cấp";
    private String description = "nâng cấp dịch vụ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_momo);
        AppMoMoLib.getInstance().setEnvironment(AppMoMoLib.ENVIRONMENT.DEVELOPMENT); // AppMoMoLib.ENVIRONMENT.PRODUCTION
        btnThanhToan = findViewById(R.id.btnthanhtoan);
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPayment();
            }
        });
    }
    //Get token through MoMo app
    private void requestPayment() {
        AppMoMoLib.getInstance().setAction(AppMoMoLib.ACTION.PAYMENT);
        AppMoMoLib.getInstance().setActionType(AppMoMoLib.ACTION_TYPE.GET_TOKEN);
        Map<String, Object> eventValue = new HashMap<>();
        //client Required
        eventValue.put("merchantname", merchantName); //Tên đối tác. được đăng ký tại https://business.momo.vn. VD: Google, Apple, Tiki , CGV Cinemas
        eventValue.put("merchantcode", merchantCode); //Mã đối tác, được cung cấp bởi MoMo tại https://business.momo.vn
        eventValue.put("amount", amount); //Kiểu integer
        eventValue.put("orderId", 50); //uniqueue id cho Bill order, giá trị duy nhất cho mỗi đơn hàng
        eventValue.put("orderLabel", 1); //gán nhãn

        //client Optional - bill info
        eventValue.put("merchantnamelabel", "Dịch vụ");//gán nhãn
        eventValue.put("fee", "0"); //Kiểu integer
        eventValue.put("description", description); //mô tả đơn hàng - short description

        //client extra data
        eventValue.put("requestId",  merchantCode+"merchant_billId_"+System.currentTimeMillis());
        eventValue.put("partnerCode", merchantCode);
        //Example extra data
        JSONObject objExtraData = new JSONObject();
        try {
            objExtraData.put("site_code", "008");
            objExtraData.put("site_name", "CGV Cresent Mall");
            objExtraData.put("screen_code", 0);
            objExtraData.put("screen_name", "Special");
            objExtraData.put("movie_name", "Kẻ Trộm Mặt Trăng 3");
            objExtraData.put("movie_format", "2D");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        eventValue.put("extraData", objExtraData.toString());

        eventValue.put("extra", "");
        AppMoMoLib.getInstance().requestMoMoCallBack(this, eventValue);


    }
    //Get token callback from MoMo app an submit to server side
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppMoMoLib.getInstance().REQUEST_CODE_MOMO && resultCode == -1) {
            if(data != null) {
                if(data.getIntExtra("status", -1) == 0) {
                    //TOKEN IS AVAILABLE
                    Log.v("thanh cong",data.getStringExtra("message"));
                    String token = data.getStringExtra("data"); //Token response
                    String phoneNumber = data.getStringExtra("phonenumber");
                    String env = data.getStringExtra("env");
                    if(env == null){
                        env = "app";
                    }

                    if(token != null && !token.equals("")) {
                        // TODO: send phoneNumber & token to your server side to process payment with MoMo server
                        // IF Momo topup success, continue to process your order
                    } else {
                        Log.v("thanh cong","khong thanh cong");
                    }
                } else if(data.getIntExtra("status", -1) == 1) {
                    //TOKEN FAIL
                    String message = data.getStringExtra("message") != null?data.getStringExtra("message"):"Thất bại";
                    Log.v("thanh cong","khong thanh cong");
                } else if(data.getIntExtra("status", -1) == 2) {
                    //TOKEN FAIL
                    Log.v("thanh cong","khong thanh cong");
                } else {
                    //TOKEN FAIL
                    Log.v("thanh cong","khong thanh cong");
                }
            } else {
                Log.v("thanh cong","khong thanh cong");
            }
        } else {
            Log.v("thanh cong","khong thanh cong");
        }
    }
}
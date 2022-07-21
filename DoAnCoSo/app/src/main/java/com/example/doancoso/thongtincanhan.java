package com.example.doancoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class thongtincanhan extends AppCompatActivity {
    Button ctn;
    RadioButton nam,nu;
    EditText ten,tuoi,chieucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtincanhan);
        nam = findViewById(R.id.radioButton8);
        nu = findViewById(R.id.radioButton10);
        ten = findViewById(R.id.editTextTextPersonName5);
        chieucao = findViewById(R.id.editTextNumber8);
        tuoi = findViewById(R.id.editTextNumber9);
        Intent intent = getIntent();
        int id = (int)intent.getFloatExtra("key_1",5);
        ctn = findViewById(R.id.button3);
        ctn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(thongtincanhan.this,muctieucannang.class);
                intent1.putExtra("key_1",ten.getText());
                intent1.putExtra("key_2",tuoi.getText());
                intent1.putExtra("key_3",chieucao.getText());
                if (nam.isChecked()==true) {
                    intent1.putExtra("key_4","Nam");
                } else if (nu.isChecked()==true) {
                    intent1.putExtra("key_4","Nữ");
                }
                intent1.putExtra("key_5",id);
                startActivity(intent1);
            }
        });
    }
}
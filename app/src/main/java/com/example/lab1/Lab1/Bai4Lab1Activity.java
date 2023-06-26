package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab1.R;

public class Bai4Lab1Activity extends AppCompatActivity implements View.OnClickListener {
    EditText ed4;
    Button bt4;
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab1);
        ed4 = findViewById(R.id.ed4);
        bt4 = findViewById(R.id.btn4);
        tv4 = findViewById(R.id.tv4);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String sleppTime = ed4.getText().toString();
    new Bai4AsyncTask(this,tv4,ed4).execute(sleppTime);
    }
}
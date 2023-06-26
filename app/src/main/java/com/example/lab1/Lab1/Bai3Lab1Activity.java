package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1.R;

public class Bai3Lab1Activity extends AppCompatActivity implements View.OnClickListener, Listener {

    Button btn3;
    TextView tv3;
    ImageView img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab1);
        btn3 = findViewById(R.id.btn3);
        tv3 = findViewById(R.id.tv3);
        img3 = findViewById(R.id.img3);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new Bai3Lab1AyncTask(this,this).execute("https://inkythuatso.com/uploads/thumbnails/800/2021/11/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg");
    }

    @Override
    public void onImageDowload(Bitmap bitmap) {
    img3.setImageBitmap(bitmap);
    tv3.setText("tai thanh cong");
    }

    @Override
    public void onError() {
        tv3.setText("tai that bai");

    }
}
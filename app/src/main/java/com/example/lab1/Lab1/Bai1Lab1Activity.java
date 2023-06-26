package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1.R;

import java.net.URL;

public class Bai1Lab1Activity extends AppCompatActivity implements View.OnClickListener {
    TextView tvfb;
    Button btnLoadImg;
    ImageView imgView;
    String url = "https://inkythuatso.com/uploads/thumbnails/800/2021/11/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_lab1);
        tvfb = (TextView) findViewById(R.id.tvfb);
        btnLoadImg = (Button) findViewById(R.id.btnLoadImg);
        imgView = (ImageView) findViewById(R.id.imgView);
        btnLoadImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLoadImg){
        LoadImage();

        }
    }
    private  void LoadImage(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImage(url);
                imgView.post(new Runnable() {
                    @Override
                    public void run() {
                        tvfb.setText("Image download full");
                        imgView.setImageBitmap(bitmap);
                    }
                });
            }
        });
        thread.start();
    }






//    load img
    public Bitmap loadImage(String strURL){
        URL url;
        Bitmap bitmap = null;
        try{
            url = new URL(strURL);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch ( Exception exc){
            Log.i("ERROD","=>"+exc.toString());
        }
        return bitmap;
    }


}
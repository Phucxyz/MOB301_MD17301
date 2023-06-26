package com.example.lab1.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai21Lab1Activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button but2;
    private String url = "https://inkythuatso.com/uploads/thumbnails/800/2021/11/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg";
    private Bitmap bitmap = null;
    private TextView tv2;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai21_lab1);
        imageView = findViewById(R.id.imgView2);
        but2 = findViewById(R.id.btn2);
        tv2 = findViewById(R.id.tv2);
        but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        progressDialog =  progressDialog.show(Bai21Lab1Activity.this,"down load dang","dang sown load");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap =  dowloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String thMessage = "da download xong";
                bundle.putString("message",thMessage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    private Handler messageHandler = new Handler(){
        public void handMessage(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tv2.setText(message);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };
    private Bitmap dowloadBitmap(String link){
        try{
            URL url1 = new URL(link);
            HttpURLConnection connection = (HttpURLConnection)url1.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap1 = BitmapFactory.decodeStream(inputStream);
            return bitmap1;
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
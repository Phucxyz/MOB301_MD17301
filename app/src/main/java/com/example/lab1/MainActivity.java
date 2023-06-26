package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab1.Lab1.Bai1Lab1Activity;
import com.example.lab1.Lab1.Bai21Lab1Activity;
import com.example.lab1.Lab1.Bai2Lab1Activity;
import com.example.lab1.Lab1.Bai3Lab1Activity;
import com.example.lab1.Lab1.Bai3Lab1AyncTask;
import com.example.lab1.Lab1.Bai4Lab1Activity;

public class MainActivity extends AppCompatActivity {
    Button btnBai1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Bai1(View view){
        Intent intent = new Intent(MainActivity.this, Bai1Lab1Activity.class);
        startActivity(intent);
    }
    public void Bai2(View view){
        Intent intent = new Intent(MainActivity.this, Bai21Lab1Activity.class);
        startActivity(intent);
    }
    public void Bai3(View view){
        Intent intent = new Intent(MainActivity.this, Bai3Lab1Activity.class);
        startActivity(intent);
    }
    public void Bai4(View view){
        Intent intent = new Intent(MainActivity.this, Bai4Lab1Activity.class);
        startActivity(intent);
    }
}
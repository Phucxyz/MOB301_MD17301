package com.example.lab1.Lab1;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.net.URL;

public class Bai3Lab1AyncTask extends AsyncTask<String, Void, Bitmap> {
    Listener mlistener;
    ProgressDialog progressDialog;
    public Bai3Lab1AyncTask(Listener listener, Context context){
        this.mlistener = listener;
        this.progressDialog = new ProgressDialog(context);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Bat dau tai xuong..");
        progressDialog.show();
    }
    Bitmap bitmap = null;
    @Override
    protected Bitmap doInBackground(String... strings) {
        URL url;

        try{
            url = new URL(strings[0]);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if(bitmap!=null){
            mlistener.onImageDowload(bitmap);
        }else{
            mlistener.onError();
        }
    }
}

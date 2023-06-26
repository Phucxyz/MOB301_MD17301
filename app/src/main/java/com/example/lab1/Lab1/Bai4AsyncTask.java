package com.example.lab1.Lab1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4AsyncTask extends AsyncTask<String,Void,String> {
    private ProgressDialog dialog;
    TextView tv4;
    EditText ed4;
    Context context;
    String kq;

    public Bai4AsyncTask(Context context, TextView tv4, EditText ed4) {
        this.context = context;
        this.tv4 = tv4;
        this.ed4 = ed4;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context,"TiTle","xin doi" +ed4.getText().toString()+" giay");
    }

    @Override
    protected String doInBackground(String... strings) {
//        publishProgress("Sleeping");
        try {
            int time = Integer.parseInt(strings[0]) + 100;
            Thread.sleep(time);
            kq = "Load " + strings[0] + "giay";

        } catch (Exception e) {
            e.printStackTrace();
            kq = e.getMessage();
        }
        return null;

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (dialog.isShowing()){
            dialog.isShowing();
        }
        tv4.setText(s);
    }
}

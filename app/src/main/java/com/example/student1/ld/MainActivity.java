package com.example.student1.ld;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button bStart;
    ProgressBar progressBar;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bStart = (Button)findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById( R.id.progressBar);
        text = (TextView) findViewById(R.id.text);
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadImage().execute();

            }});}
private class LoadImage extends AsyncTask<Void, Integer, Void>{
    @Override
    protected void  onPreExecute(){
        super.onPreExecute();}

    protected  Void doInBackground(Void... args){
        for (int i = 0; i<100; i+=8){
            try {
                Thread.sleep(200);
                publishProgress(i);
            }catch (InterruptedException e){
                e.printStackTrace();}}
        publishProgress(100);
        return null;}
    protected  void onPostExecute(Void image){
        text.setText("Задача выполнена");
            }
    @Override
    protected  void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
        text.setText("Выполнено: "+ values[0]+"/100");
        }
    }







}

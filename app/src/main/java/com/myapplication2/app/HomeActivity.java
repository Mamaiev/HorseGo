package com.myapplication2.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HomeActivity extends Activity {

    private ProgressBar progressBarPlayer1;
    private ProgressBar progressBarPlayer2;
    private Button btnStart;

    private TextView txtViewPlayer1ActivityHome;
    private TextView txtViewPlayer2ActivityHome; //  Hello



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtViewPlayer1ActivityHome = (TextView)findViewById(R.id.txtViewPlayer1ActivityHome);
        txtViewPlayer2ActivityHome = (TextView)findViewById(R.id.txtViewPlayer2ActivityHome);

        txtViewPlayer1ActivityHome.setText(getIntent().getStringExtra("NamePlayer1"));
        txtViewPlayer2ActivityHome.setText(getIntent().getStringExtra("NamePlayer2"));

        progressBarPlayer1 = (ProgressBar) findViewById(R.id.progressBarPlayer1);
        progressBarPlayer2 = (ProgressBar) findViewById(R.id.progressBarPlayer2);

    }

    public void startProgress(View view) {
        progressBarPlayer1.setProgress(0);
        progressBarPlayer2.setProgress(0);

        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());

        t1.start();
        t2.start();
    }
        class Task1 implements Runnable{

            @Override
            public void run() {
                for (int i = 0; i < 100;) {
                    if ((i += (int) (Math.random()*5)) >= 100) {
                        i = 100;
                    } else {
                        i += (int) (Math.random()*5);}
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBarPlayer1.setProgress(i);
                }
            }
        }
        class Task2 implements Runnable{

            @Override
            public void run() {
                for (int i = 0; i <= 100 ; i++) {
                    final int value = i;
                    i+= (int) (Math.random()*5);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBarPlayer2.setProgress(value);
                }
            }
        }

    }








//    class play extends AsyncTask<Void, Integer, Void>{
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            int progress = 0;
//            while (progress < 100)  {
//                progress += (int)(Math.random()*5);
//                publishProgress(progress);
//            SystemClock.sleep(500);
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Toast.makeText(HomeActivity.this, "Run", Toast.LENGTH_LONG).show();
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            Toast.makeText(HomeActivity.this, "END", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
//            progressBarPlayer1.setProgress(values[0]);
//        }
//    }
//
//    public void start(View view){
//
//       new play().execute();
//        }


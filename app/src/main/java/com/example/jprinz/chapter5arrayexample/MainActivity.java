package com.example.jprinz.chapter5arrayexample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener{
//public class MainActivity extends Activity {

    /*private Handler myHandler;   //Example pg161
    boolean gameOn;
    long startTime;*/

    /*private SoundPool soundPool;   //Example pg167
    int sample1 = -1;
    int sample2 = -1;
    int sample3 = -1;*/


    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "MyData";
    String stringName = "MyString";
    String defaultString = ":-(";
    String currentString = "";
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /*  int [] ourArray;  //Example pg150

        ourArray = new int[5];

        ourArray[0] = 25;
        ourArray[1] = 50;
        ourArray[2] = 125;
        ourArray[3] = 68;
        ourArray[4] = 47;

        Log.i("info", "Here is ourArray");
        Log.i("info", "[0] = " + ourArray[0]);
        Log.i("info", "[1] = " + ourArray[1]);
        Log.i("info", "[2] = " + ourArray[2]);
        Log.i("info", "[3] = " + ourArray[3]);
        Log.i("info", "[4] = " + ourArray[4]);

        int answer = ourArray[0] + ourArray [1] +
                ourArray[2] + ourArray[3] +
                ourArray[4];

        Log.i("info", "Answer = " + answer);*/


        /*int [] ourArray = new int[1000];   //example pg152

        for(int i = 0; i < 1000; i++){
            ourArray[i] = i * 5;

            Log.i("info", "i = " + i);
            Log.i("info", "ourArray[i] = " + ourArray[i]);

        }

        ArrayList<Integer> arl = new ArrayList<Integer>();

        arl.add(55);
        arl.add(155);
        Log.i("info", "arrayList = " + arl);*/


        /*Random randInt = new Random();
        int questionNumber;

        String [] [] countriesAndCities;

        countriesAndCities = new String[5][2];

        countriesAndCities[0][0] = "United Kingdom";
        countriesAndCities[0][1] = "London";

        countriesAndCities [1] [0] = "USA";
        countriesAndCities [1] [1] = "Washington";

        countriesAndCities [2] [0] = "India";
        countriesAndCities [2] [1] = "New Delhi";

        countriesAndCities [3] [0] = "Brazil";
        countriesAndCities [3] [1] = "Brasilia";

        countriesAndCities [4] [0] = "Kenya";
        countriesAndCities [4] [1] = "Nairobi";

        int country = 0;
        int capital = 1;

        for (int i = 0; i < 3; i++){
            questionNumber = randInt.nextInt(5);

            Log.i("info", "The capital of " + countriesAndCities[questionNumber][country]);
            Log.i("info", "is " + countriesAndCities[questionNumber][capital]);
        }*/


        /*startTime = System.currentTimeMillis();    //Example pg161

        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (gameOn) {
                    long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
                    Log.i("info", "seconds = " + seconds);
                }

                myHandler.sendEmptyMessageDelayed(0, 1000);

            }
        };

        gameOn = true;
        myHandler.sendEmptyMessage(0);*/


        /*soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);   //Example pg167
        try{
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor;



            descriptor = assetManager.openFd("sample1.ogg");
            sample1 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample2.ogg");
            sample2 = soundPool.load(descriptor, 0);

            descriptor = assetManager.openFd("sample3.ogg");
            sample3 = soundPool.load(descriptor, 0);

        }catch (IOException e){

        }

        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }*/


    /*@Override       //Example pg167
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button:
                soundPool.play(sample1, 1, 1, 0, 0, 1);
                break;

            case R.id.button2:
                soundPool.play(sample2, 1, 1, 0, 0, 1);
                break;

            case R.id.button3:
                soundPool.play(sample3, 1, 1, 0, 0, 1);
                break;

        }*/


        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        editor = prefs.edit();

        currentString = prefs.getString(stringName, defaultString);

        button1 = (Button)findViewById(R.id.button);

        button1.setOnClickListener(this);

        button1.setText(currentString);

    }

    @Override
    public void onClick(View view) {
        Random randInt = new Random();
        int ourRandom = randInt.nextInt(10);

        currentString = currentString + ourRandom;

        editor.putString(stringName, currentString);
        editor.commit();

        button1.setText(currentString);
    }
}

package com.curiousca.lotterywin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.curiousca.lotterywin.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_BALL_1 = "keyBall_1";
    private static final String KEY_BALL_MEGA_1 = "keyMegsBall_1";

    private TextView textViewBall_1;
    private TextView textViewBall_2;
    private TextView textViewBall_3;
    private TextView textViewBall_4;
    private TextView textViewBall_5;
    private TextView textViewBall_11;
    private TextView textViewBall_12;
    private TextView textViewBall_13;
    private TextView textViewBall_14;
    private TextView textViewBall_15;
    private TextView textViewMegaBall_1;
    private TextView textViewMegaBall_2;
    private int megaBall;

    private Button btnGetNumbers;
    private Button btnGetPastNumbers;

    private String[] lotteryNumbers = {
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
            "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        buttonClicks();
        if (savedInstanceState == null) {
            generateRandomNumbers();
            generateAdditionalRandomNumbers();
        } else {
            lotteryNumbers = savedInstanceState.getStringArray(KEY_BALL_1);
            textViewBall_1.setText(String.valueOf(lotteryNumbers));

            megaBall = savedInstanceState.getInt(KEY_BALL_MEGA_1);
            textViewMegaBall_1.setText(String.valueOf(megaBall));
        }
    }

    private void buttonClicks(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        btnGetNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Clicked", "Button clicked");
                generateRandomNumbers();
                generateAdditionalRandomNumbers();
            }
        });

        btnGetPastNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Clicked 2", "Past button clicked");
                Intent intent = new Intent(MainActivity.this, PastNumberActivity.class);
                startActivity(intent);

            }
        });

    }


    private void generateRandomNumbers() {
        Collections.shuffle(Arrays.asList(lotteryNumbers));
        textViewBall_1.setText(lotteryNumbers[0]);
        textViewBall_2.setText(lotteryNumbers[1]);
        textViewBall_3.setText(lotteryNumbers[2]);
        textViewBall_4.setText(lotteryNumbers[3]);
        textViewBall_5.setText(String.valueOf(lotteryNumbers[4]));// lotteryNumbers[4]);

        Random random = new Random();
        megaBall = (random.nextInt(25) + 1);
        textViewMegaBall_1.setText(String.valueOf(megaBall));
    }

    private void generateAdditionalRandomNumbers() {
        Collections.shuffle(Arrays.asList(lotteryNumbers));
        textViewBall_11.setText(lotteryNumbers[10]);
        textViewBall_12.setText(lotteryNumbers[11]);
        textViewBall_13.setText(lotteryNumbers[12]);
        textViewBall_14.setText(lotteryNumbers[13]);
        textViewBall_15.setText(lotteryNumbers[14]);

        Random random = new Random();
        megaBall = (random.nextInt(25) + 1);
        textViewMegaBall_2.setText(String.valueOf(megaBall));

    }

    private void initializeViews() {
        textViewBall_1 = findViewById(R.id.text_view_ball_1);
        textViewBall_2 = findViewById(R.id.text_view_ball_2);
        textViewBall_3 = findViewById(R.id.text_view_ball_3);
        textViewBall_4 = findViewById(R.id.text_view_ball_4);
        textViewBall_5 = findViewById(R.id.text_view_ball_5);
        textViewBall_11 = findViewById(R.id.text_view_ball_11);
        textViewBall_12 = findViewById(R.id.text_view_ball_12);
        textViewBall_13 = findViewById(R.id.text_view_ball_13);
        textViewBall_14 = findViewById(R.id.text_view_ball_14);
        textViewBall_15 = findViewById(R.id.text_view_ball_15);

        textViewMegaBall_1 = findViewById(R.id.text_view_mega_ball_1);
        textViewMegaBall_2 = findViewById(R.id.text_view_mega_ball_2);

        btnGetNumbers = findViewById(R.id.buttonGetNumbers);
        btnGetPastNumbers = findViewById(R.id.buttonGetOldNumbers);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArray(KEY_BALL_1, lotteryNumbers);
        outState.putInt(KEY_BALL_MEGA_1, megaBall);

    }
}

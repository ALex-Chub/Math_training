package com.alexch.math_train;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Level2a extends AppCompatActivity {
    int a, b, schet, reckord, vern, errors, c, an1, an2, an3, n;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER3 = "reckord21";
    private SharedPreferences Settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1a);
        TextView op = (TextView)findViewById(R.id.operand);
        op.setText("");
        Settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        reckord = Settings.getInt(APP_PREFERENCES_COUNTER3, 0);
        TextView reck =(TextView)findViewById(R.id.reckord);
        reck.setText(""+reckord);
        Button answer1 = (Button) findViewById(R.id.ans1);
        Button answer2 = (Button) findViewById(R.id.ans2);
        Button answer3 = (Button) findViewById(R.id.ans3);
        Button answer4 = (Button) findViewById(R.id.ans4);
        answer1.setClickable(false);
        answer1.setText("");
        answer2.setClickable(false);
        answer2.setText("");
        answer3.setClickable(false);
        answer3.setText("");
        answer4.setClickable(false);
        answer4.setText("");

    }

    protected void onResume() {
        super.onResume();
        // Получаем число из настроек
        reckord = Settings.getInt(APP_PREFERENCES_COUNTER3, 0);
        TextView reck =(TextView)findViewById(R.id.reckord);
        reck.setText(""+reckord);
    }

    public void back(View v) {
        try {
            Intent inten = new Intent(Level2a.this, MainMenu.class);
            startActivity(inten);
            finish();
        } catch (Exception e) {
        }

    }

    public void Starttrain(View v) {
        Button answer1 = (Button) findViewById(R.id.ans1);
        Button answer2 = (Button) findViewById(R.id.ans2);
        Button answer3 = (Button) findViewById(R.id.ans3);
        Button answer4 = (Button) findViewById(R.id.ans4);
        answer1.setClickable(true);
        answer2.setClickable(true);
        answer3.setClickable(true);
        answer4.setClickable(true);
        schet = 0;
        vern = 0;
        errors = 0;
        Timer();
        Proverka();
    }

    public void Timer() {
        ProgressBar time = (ProgressBar) findViewById(R.id.timer);
        Button start = (Button) findViewById(R.id.button2);
        start.setClickable(false);
        new CountDownTimer(60000, 1000) {
            int m = 60;

            @Override
            public void onTick(long millisUntilFinished) {
                m = m - 1;
                time.setProgress(m);
            }

            @Override
            public void onFinish() {
                Button answer1 = (Button) findViewById(R.id.ans1);
                Button answer2 = (Button) findViewById(R.id.ans2);
                Button answer3 = (Button) findViewById(R.id.ans3);
                Button answer4 = (Button) findViewById(R.id.ans4);
                TextView reck = (TextView) findViewById(R.id.reckord);
                TextView texta = (TextView) findViewById(R.id.z1);
                TextView textb = (TextView) findViewById(R.id.ch2);
                Button start = (Button) findViewById(R.id.button2);
                answer1.setClickable(false);
                answer1.setText("");
                answer2.setClickable(false);
                answer2.setText("");
                answer3.setClickable(false);
                answer3.setText("");
                answer4.setClickable(false);
                answer4.setText("");
                texta.setText("");
                textb.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "Время вышло!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 30, 0);
                toast.show();
                if (schet > reckord) {
                    reckord = schet;

                    toast = Toast.makeText(getApplicationContext(), "Новый рекорд!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                reck.setText("" + reckord);
                start.setClickable(true);
            }
        }.start();
    }

    public void Proverka() {
        TextView op = (TextView)findViewById(R.id.operand);
        Button answer1 = (Button) findViewById(R.id.ans1);
        Button answer2 = (Button) findViewById(R.id.ans2);
        Button answer3 = (Button) findViewById(R.id.ans3);
        Button answer4 = (Button) findViewById(R.id.ans4);
        TextView texta = (TextView) findViewById(R.id.z1);
        TextView textb = (TextView) findViewById(R.id.ch2);
        a = (int) Math.round(Math.random() * 90 + 10);
        b = (int) Math.round(Math.random() * 90 + 10);
        int operandd =(int)Math.round(Math.random()*4);
        if (operandd>2){
            c=a+b;
            op.setText("+");
        } else{
            c=a;
            a=c+b;
            op.setText("-");
        }

        an1 = c - 5;
        an2 = c + 5;
        an3 = c - 10;
        texta.setText("" +a);
        textb.setText("" + b);
        n = (int) Math.round(Math.random() * 3);
        switch (n) {
            case 0:
                answer1.setText("" + c);
                answer2.setText("" + an2);
                answer3.setText("" + an1);
                answer4.setText("" + an3);
                break;
            case 1:
                answer2.setText("" + c);
                answer1.setText("" + an2);
                answer3.setText("" + an1);
                answer4.setText("" + an3);
                break;
            case 2:
                answer3.setText("" + c);
                answer2.setText("" + an2);
                answer1.setText("" + an1);
                answer4.setText("" + an3);
                break;
            case 3:
                answer4.setText("" + c);
                answer2.setText("" + an2);
                answer3.setText("" + an1);
                answer1.setText("" + an3);
                break;
        }
    }

    public void Ans1(View v) {
        TextView sche = (TextView) findViewById(R.id.schet);
        TextView verno = (TextView) findViewById(R.id.ver);
        TextView neverno = (TextView) findViewById(R.id.err);
        if (n == 0) {
            schet = schet + 1;
            vern = vern + 1;
        } else {
            schet = schet - 1;
            errors = errors + 1;
        }
        sche.setText("" + schet);
        verno.setText("" + vern);
        neverno.setText("" + errors);
        Proverka();
    }

    public void Ans2(View v) {
        TextView sche = (TextView) findViewById(R.id.schet);
        TextView verno = (TextView) findViewById(R.id.ver);
        TextView neverno = (TextView) findViewById(R.id.err);
        if (n == 1) {
            schet = schet + 1;
            vern = vern + 1;
        } else {
            schet = schet - 1;
            errors = errors + 1;
        }
        sche.setText("" + schet);
        verno.setText("" + vern);
        neverno.setText("" + errors);
        Proverka();
    }

    public void Ans3(View v) {
        TextView sche = (TextView) findViewById(R.id.schet);
        TextView verno = (TextView) findViewById(R.id.ver);
        TextView neverno = (TextView) findViewById(R.id.err);

        if (n == 2) {
            schet = schet + 1;
            vern = vern + 1;
        } else {
            schet = schet - 1;
            errors = errors + 1;
        }
        sche.setText("" + schet);
        verno.setText("" + vern);
        neverno.setText("" + errors);
        Proverka();
    }

    public void Ans4(View v) {
        TextView sche = (TextView) findViewById(R.id.schet);
        TextView verno = (TextView) findViewById(R.id.ver);
        TextView neverno = (TextView) findViewById(R.id.err);

        if (n == 3) {
            schet = schet + 1;
            vern = vern + 1;
        } else {
            schet = schet - 1;
            errors = errors + 1;
        }
        sche.setText("" + schet);
        verno.setText("" + vern);
        neverno.setText("" + errors);
        Proverka();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = Settings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER3, reckord);
        editor.apply();
    }
}
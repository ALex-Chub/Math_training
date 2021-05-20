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

public class Yravnenia extends AppCompatActivity {
    int a, b, schet, reckord, vern, errors, c, an1, an2, an3, n, x, k;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER3 = "reckordyr";
    private SharedPreferences Settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yravnenia);
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
            Intent inten = new Intent(Yravnenia.this, MainMenu.class);
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
        Proverka();
    }

    public void Proverka() {
        Button answer1 = (Button) findViewById(R.id.ans1);
        Button answer2 = (Button) findViewById(R.id.ans2);
        Button answer3 = (Button) findViewById(R.id.ans3);
        Button answer4 = (Button) findViewById(R.id.ans4);
        TextView kef1 = (TextView) findViewById(R.id.k1);
        TextView  kef2 = (TextView) findViewById(R.id.k2);
        TextView const1 = (TextView)findViewById(R.id.c1);
        TextView const2 = (TextView)findViewById(R.id.c2);
        a = (int) Math.round(Math.random() * 9 + 1);
        b = (int) Math.round(Math.random() * 9 + 1);
        k = (int) Math.round(Math.random() * 9 + 1);
        c = (int) Math.round(Math.random() * 9 + 1);

        if (b>k){
            int sp=b;
            b=k;
            k=sp;
        }
        kef1.setText(""+(k-b));
        kef2.setText(""+b);
        const1.setText(""+(a*k-c));
        const2.setText(""+c);
        c=a;
        an1 = c - 5;
        an2 = c + 5;
        an3 = c - 10;
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
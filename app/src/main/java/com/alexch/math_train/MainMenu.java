package com.alexch.math_train;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
    }
public void z11 (View v){
        try {
            Intent intent1 = new Intent(MainMenu.this, Level1a.class);
            startActivity(intent1);finish();
        } catch (Exception e){}

}
    public void z12 (View v){
        try {
            Intent intent1 = new Intent(MainMenu.this, Level1b.class);
            startActivity(intent1);finish();
        } catch (Exception e){}

    }
    public void z21 (View v){
        try {
            Intent intent1 = new Intent(MainMenu.this, Level2a.class);
            startActivity(intent1);finish();
        } catch (Exception e){}

    }
    public void z22 (View v){
        try {
            Intent intent1 = new Intent(MainMenu.this, Level2b.class);
            startActivity(intent1);finish();
        } catch (Exception e){}

    }
    public void yravnen (View v){
        try {
            Intent intent1 = new Intent(MainMenu.this, Yravnenia.class);
            startActivity(intent1);finish();
        } catch (Exception e){}

    }
}
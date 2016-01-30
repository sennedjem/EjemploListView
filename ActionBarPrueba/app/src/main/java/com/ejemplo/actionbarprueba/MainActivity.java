package com.ejemplo.actionbarprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pasarDeActivity(View v){
        Intent i = new Intent(this,ActivityConToolbar.class);
        startActivity(i);
    }
}

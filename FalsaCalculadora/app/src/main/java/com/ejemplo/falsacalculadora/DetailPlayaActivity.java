package com.ejemplo.falsacalculadora;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPlayaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playa);
        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText(getIntent().getExtras().getString("nombre"));
        TextView temperatura = (TextView) findViewById(R.id.temperatura);
        if(temperatura != null){
        temperatura.setText(""+getIntent().getExtras().get("temperatura"));}
        ImageView imagen = (ImageView) findViewById(R.id.playa);
        imagen.setImageResource(getIntent().getExtras().getInt("srcImagen"));
    }
}

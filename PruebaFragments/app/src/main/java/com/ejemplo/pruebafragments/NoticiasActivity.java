package com.ejemplo.pruebafragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.ejemplo.pruebafragments.model.Playa;

public class NoticiasActivity extends FragmentActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_noticiaslinear);
    }

    @Override
    public void onRssItemSelected(Playa playa) {
        boolean dual_pane = getResources().getBoolean(R.bool.dual_pane);
        if(dual_pane){
        DetailFragment fragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        fragment.setPlaya(playa);
    } else {
            Intent intent = new Intent (getApplicationContext(),DetailActivity.class);
            intent.putExtra("nombre",playa.getNombre());
            intent.putExtra("temperatura",playa.getTemperatura());
            intent.putExtra("srcImagen",playa.getFotoId());
            startActivity(intent);}
}}

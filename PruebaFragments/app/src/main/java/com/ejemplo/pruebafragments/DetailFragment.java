package com.ejemplo.pruebafragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ejemplo.pruebafragments.model.Playa;

/**
 * Created by sebastian on 05/01/16.
 */
public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        return view;
    }

    public void setPlaya(Playa playa){
        TextView titulo = (TextView) getView().findViewById(R.id.titulo);
        titulo.setText(playa.getNombre());
        ////TextView temperatura = (TextView) getView().findViewById(R.id.temperatura);
        ////    if(temperatura != null){
        ////   temperatura.setText(""+getIntent().getExtras().get("temperatura"));}
        ImageView imagen = (ImageView) getView().findViewById(R.id.playa);
        imagen.setImageResource(playa.getFotoId());
    }
}

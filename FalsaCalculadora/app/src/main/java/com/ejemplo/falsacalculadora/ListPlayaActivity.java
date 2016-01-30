package com.ejemplo.falsacalculadora;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ejemplo.falsacalculadora.adapters.ListPlayaAdapter;
import com.ejemplo.falsacalculadora.model.Playa;

import java.util.ArrayList;
import java.util.List;

public class ListPlayaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_playa);
        List<Playa> playas = new ArrayList<>();
        playas.add(new Playa("Villa Gesell",25.0f,R.drawable.imagen));
        playas.add(new Playa("Mar Del Plata",26.0f,R.drawable.imagen));
        playas.add(new Playa("Carilo",27.0f,R.drawable.imagen));
        playas.add(new Playa("La Paloma",28.0f,R.drawable.beach2));
        playas.add(new Playa("Piriapolis",29.0f,R.drawable.beach2));
        ListView lista = (ListView) findViewById(R.id.listaDePlayas);
        ListPlayaAdapter listaAdaptada = new ListPlayaAdapter(this,playas);
        lista.setAdapter(listaAdaptada);
    }

}

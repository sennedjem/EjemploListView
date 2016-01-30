package com.ejemplo.pruebafragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ejemplo.pruebafragments.adapters.ListPlayaAdapter;
import com.ejemplo.pruebafragments.model.Playa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastian on 05/01/16.
 */
public class ListFragment extends Fragment implements OnItemSelectedListener {

    private OnItemSelectedListener listener;
    List<Playa> playas = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.fragment_news_list,container,false);

        playas.add(new Playa("Villa Gesell",25.0f,R.drawable.imagen));
        playas.add(new Playa("Mar Del Plata",26.0f,R.drawable.imagen));
        playas.add(new Playa("Carilo",27.0f,R.drawable.imagen));
        playas.add(new Playa("La Paloma",28.0f,R.drawable.beach2));
        playas.add(new Playa("Piriapolis",29.0f,R.drawable.beach2));
        ListView lista = (ListView) getActivity().findViewById(R.id.listaDePlayas);
        ListPlayaAdapter listaAdaptada = new ListPlayaAdapter(this,playas);
        lista.setAdapter(listaAdaptada);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnItemSelectedListener){
        listener = (OnItemSelectedListener) context;
        }else{
            throw new ClassCastException(context.toString()+ "must implement MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail(Playa playa){
        listener.onRssItemSelected(playa);
    }


    @Override
    public void onRssItemSelected(Playa playa) {
        updateDetail(playa);
    }
}

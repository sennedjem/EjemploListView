package com.ejemplo.pruebafragments.adapters;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ejemplo.pruebafragments.OnItemSelectedListener;
import com.ejemplo.pruebafragments.R;
import com.ejemplo.pruebafragments.model.Playa;

import java.util.List;

/**
 * Created by sebastian on 18/12/15.
 */
public class ListPlayaAdapter extends BaseAdapter{

    private final Fragment context;
    private final List<Playa> playas;
    private OnItemSelectedListener listener;
    private LayoutInflater inflater;

    public ListPlayaAdapter(Fragment context, List<Playa> playas){

        this.context = context;
        this.playas = playas;
        this.listener =(OnItemSelectedListener) context;

    }

    @Override
    public int getCount() {
        return playas.size();
    }

    @Override
    public Playa getItem(int position) {
        return playas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context.getContext()).inflate(R.layout.itemdelista, parent, false);
        final Playa playa = getItem(position);
        //setContenido(view, playa);
        setOnClick(view, playa);
        return view;
    }

    private void setOnClick(View view, final Playa playa) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(context, DetailPlayaActivity.class);
                //intent.putExtra("nombre",playa.getNombre());
                //intent.putExtra("temperatura",playa.getTemperatura());
                //intent.putExtra("srcImagen",playa.getFotoId());
                //context.startActivity(intent);
                listener.onRssItemSelected(playa);
            }
        });
    }

    private void setContenido(View view, Playa playa) {
        TextView playaNombreView = (TextView) view.findViewById(R.id.playaNombre);
        playaNombreView.setText(playa.getNombre());
        //TextView playaTemperaturaView = (TextView) view.findViewById(R.id.playaTemperatura);
        //playaTemperaturaView.setText(""+playa.getTemperatura());
        //ImageView playaImagenView = (ImageView) view.findViewById(R.id.imagen);
        //playaImagenView.setImageResource(playa.getFotoId());
    }

    private View getViewInflate(ViewGroup parent) {
        //return inflaterinflate(R.layout.itemdelista, parent, false);
        return LayoutInflater.from(context.getContext()).inflate(R.layout.itemdelista, parent, false);
    }
}
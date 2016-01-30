package com.ejemplo.falsacalculadora.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ejemplo.falsacalculadora.DetailPlayaActivity;
import com.ejemplo.falsacalculadora.model.Playa;
import com.ejemplo.falsacalculadora.R;

import java.util.List;

/**
 * Created by sebastian on 18/12/15.
 */
public class ListPlayaAdapter extends BaseAdapter{

    private final Context context;
    private final List<Playa> playas;

    public ListPlayaAdapter(Context context, List<Playa> playas){

        this.context = context;
        this.playas = playas;
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
        View view = getViewInflate(parent);
        final Playa playa = getItem(position);
        setContenido(view, playa);
        setOnClick(view, playa);
        return view;
    }

    private void setOnClick(View view, final Playa playa) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPlayaActivity.class);
                intent.putExtra("nombre",playa.getNombre());
                intent.putExtra("temperatura",playa.getTemperatura());
                intent.putExtra("srcImagen",playa.getFotoId());
                context.startActivity(intent);
            }
        });
    }

    private void setContenido(View view, Playa playa) {
        TextView playaNombreView = (TextView) view.findViewById(R.id.playaNombre);
        playaNombreView.setText(playa.getNombre());
        TextView playaTemperaturaView = (TextView) view.findViewById(R.id.playaTemperatura);
        playaTemperaturaView.setText(""+playa.getTemperatura());
        ImageView playaImagenView = (ImageView) view.findViewById(R.id.imagen);
        playaImagenView.setImageResource(playa.getFotoId());
    }

    private View getViewInflate(ViewGroup parent) {
        return LayoutInflater.from(this.context).inflate(R.layout.itemdelista, parent, false);
    }
}

package uis.tp.grupo1.duelodeleyendas.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import uis.tp.grupo1.duelodeleyendas.Adapters.AbstractListAdapter;
import uis.tp.grupo1.duelodeleyendas.R;

/**
 * Created by sebastian on 29/11/15.
 */
public class PersonajesAdapter extends AbstractListAdapter<String> {
    public PersonajesAdapter(Context context, List<String> pjs) {
        super(context, pjs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String pj = (String) getItem(position);
        View row = generateRow(R.layout.personaje_row, parent);
        setColumnTextView(row,R.id.pjNombre, pj);
        return row;
    }
}

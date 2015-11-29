package uis.tp.grupo1.duelodeleyendas;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.List;

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

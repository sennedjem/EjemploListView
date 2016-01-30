package uis.tp.grupo1.duelodeleyendas;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uis.tp.grupo1.duelodeleyendas.Model.PersonajeRep;
import uis.tp.grupo1.duelodeleyendas.Services.PersonajesServices;
import uis.tp.grupo1.duelodeleyendas.Services.RepoPersonajes;


public class ItemDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "personaje_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String nombrePersonaje = "";

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                nombrePersonaje = getArguments().getString(ARG_ITEM_ID);
                appBarLayout.setTitle(nombrePersonaje);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        return rootView;
    }

}

package uis.tp.grupo1.duelodeleyendas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uis.tp.grupo1.duelodeleyendas.Model.PersonajeRep;
import uis.tp.grupo1.duelodeleyendas.Services.PersonajesServices;
import uis.tp.grupo1.duelodeleyendas.Services.RepoPersonajes;

public class ItemListActivity extends AppCompatActivity
        implements ItemListFragment.Callbacks {

    private boolean mTwoPane;
    private RepoPersonajes repo = new RepoPersonajes();
    private List<String> personajes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_app_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }
       /* pjServices.getPersonajePorNombre("Mirana" ,new Callback<List<String>>() {
            @Override
            public void success(List<String> pjs, Response response) {
                personajes = pjs;
                if(personajes.size()> 0) {
                    TextView texto = (TextView) findViewById(R.id.caja_de_texto);
                    texto.setText(personajes.get(0));
                }
            }

            @Override
            public void failure(RetrofitError error) {
                TextView texto = (TextView) findViewById(R.id.caja_de_texto);
                texto.setText("no se pudo conectar");
            }
        });
    */
        obtenerPj("Mirana");
    }

    private void obtenerPj(String idd) {
        PersonajesServices pjsService = repo.createPersonajesServices();
        pjsService.getPersonajePorNombre(idd, new Callback<PersonajeRep>() {
            @Override
            public void success(PersonajeRep pj, Response response) {
                TextView texto = (TextView) findViewById(R.id.caja_de_texto);
                texto.setText(pj.getPosicionIdeal());
            }

            @Override
            public void failure(RetrofitError error) {
                TextView texto = (TextView) findViewById(R.id.caja_de_texto);
                texto.setText("no se pudo conectar");
            }
        });
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }




}

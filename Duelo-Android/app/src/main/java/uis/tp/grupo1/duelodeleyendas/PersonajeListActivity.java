package uis.tp.grupo1.duelodeleyendas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import uis.tp.grupo1.duelodeleyendas.Services.RepoPersonajes;

public class PersonajeListActivity extends AppCompatActivity
        implements PersonajeListFragment.Callbacks {

    private boolean mTwoPane;
    private RepoPersonajes repo = new RepoPersonajes();
    private List<String> personajes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_app_bar);

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
            ((PersonajeListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }
    }



    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(PersonajeSeleccionadoFragment.ARG_ITEM_ID, id);
            PersonajeSeleccionadoFragment fragment = new PersonajeSeleccionadoFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, PersonajeSeleccionadoActivity.class);
            detailIntent.putExtra(PersonajeSeleccionadoFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }




}

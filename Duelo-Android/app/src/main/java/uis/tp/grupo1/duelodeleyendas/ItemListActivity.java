package uis.tp.grupo1.duelodeleyendas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import uis.tp.grupo1.duelodeleyendas.Services.RepoPersonajes;

public class ItemListActivity extends AppCompatActivity
        implements ItemListFragment.Callbacks {

    private boolean esWideScreen;
    private RepoPersonajes repo = new RepoPersonajes();
    private List<String> personajes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_app_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        if (esUnaTablet()) {
            activarModoWideScreen();
        }
    }

    @Override
    public void onItemSelected(String id) {
        if (esWideScreen) {
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    private void activarModoWideScreen() {
        esWideScreen = true;
        ((ItemListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.item_list))
                .setActivateOnItemClick(true);
    }

    private boolean esUnaTablet() {
        return findViewById(R.id.item_detail_container) != null;
    }


}

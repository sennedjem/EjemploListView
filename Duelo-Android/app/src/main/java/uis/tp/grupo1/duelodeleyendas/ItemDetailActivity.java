package uis.tp.grupo1.duelodeleyendas;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uis.tp.grupo1.duelodeleyendas.Adapters.ImagenAdapter;
import uis.tp.grupo1.duelodeleyendas.Model.PersonajeRep;
import uis.tp.grupo1.duelodeleyendas.Services.PersonajesServices;
import uis.tp.grupo1.duelodeleyendas.Services.RepoPersonajes;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link ItemDetailFragment}.
 */
public class ItemDetailActivity extends AppCompatActivity {
    private RepoPersonajes repoPersonajes= new RepoPersonajes();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Button b = (Button) findViewById(R.id.button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);


        // Show the Up button in the action bar.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();

            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();

        }

        final String loco = getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID);

        Button btnIr= (Button) findViewById(R.id.button);
        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailActivity.this, EstadisticasActivity.class);
                intent.putExtra("nombre", loco);
                startActivity(intent);
            }
        });
        obtenerPersonaje(loco);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void obtenerPersonaje(String idd) {
        PersonajesServices pjService = repoPersonajes.createPersonajesServices();
        pjService.getPersonajePorNombre(idd, new Callback<PersonajeRep>() {
            @Override
            public void success(PersonajeRep pj, Response response) {
                mostrarPj(pj);

            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    private void mostrarPj(PersonajeRep pj) {
        ImageView imgGenero = ((ImageView) findViewById(R.id.imagenPersonaje));
        int entero = new ImagenAdapter().getImagen(pj.getNombre());
        imgGenero.setImageDrawable(getResources().getDrawable(entero));
        ListView esp = (ListView) findViewById(R.id.especialidades);
        ArrayAdapter<String> adapterEsp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, pj.getEspecialidades());
        esp.setAdapter(adapterEsp);
        ListView esp2 = (ListView) findViewById(R.id.debilidadesList);
        ArrayAdapter<String> holis = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, pj.getDebilidades());
        esp2.setAdapter(holis);
        TextView mejorPosicion = ((TextView) findViewById(R.id.mejorUbicacionValue));
        mejorPosicion.setText(pj.getPosicionIdeal());

    }

}

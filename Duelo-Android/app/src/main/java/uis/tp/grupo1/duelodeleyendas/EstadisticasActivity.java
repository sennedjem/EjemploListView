package uis.tp.grupo1.duelodeleyendas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uis.tp.grupo1.duelodeleyendas.Model.EstadisticasRep;
import uis.tp.grupo1.duelodeleyendas.Model.PersonajeRep;
import uis.tp.grupo1.duelodeleyendas.Services.PersonajesServices;
import uis.tp.grupo1.duelodeleyendas.Services.RepoPersonajes;

public class EstadisticasActivity extends AppCompatActivity {

    private RepoPersonajes repo = new RepoPersonajes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView texto = (TextView)findViewById(R.id.caja_de_texto);
        texto.setText(getIntent().getStringExtra("nombre"));
        obtenerPersonaje(getIntent().getStringExtra("nombre"));

    }

    private void obtenerPersonaje(String idd) {
        PersonajesServices pjService = repo.createPersonajesServices();
        pjService.getEstadisticasPersonajePorNombre(idd, new Callback<EstadisticasRep>() {
            @Override
            public void success(EstadisticasRep pjEst, Response response) {
                asignarValores(pjEst);
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    public void asignarValores(EstadisticasRep est){
        TextView ca00 = (TextView) findViewById(R.id.jugadasValue);
        ca00.setText(est.getJugadas());
        TextView ca02 = (TextView) findViewById(R.id.ganadasValue);
        ca00.setText(est.getGanadas());
        TextView ca03 = (TextView) findViewById(R.id.killsValue);
        ca00.setText(est.getKills());
        TextView ca04 = (TextView) findViewById(R.id.deadsValue);
        ca00.setText(est.getDeads());
        TextView ca05 = (TextView) findViewById(R.id.assistsValue);
        ca00.setText(est.getAssists());
        TextView ca06 = (TextView) findViewById(R.id.mejorUbicacionValue);
        ca00.setText(est.getMejorUbicacion());
        TextView ca07 = (TextView) findViewById(R.id.puntajeValue);
        ca00.setText(est.getPuntaje());
    }
    ;
}

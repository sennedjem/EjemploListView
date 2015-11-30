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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarEst);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Holis");
        obtenerPersonaje(getIntent().getStringExtra("nombre"));
    }

    private void obtenerPersonaje(String idd) {
        PersonajesServices pjService = RepoPersonajes.createPersonajesServices();
        pjService.getEstadisticas(idd, new Callback<EstadisticasRep>() {
            @Override
            public void success(EstadisticasRep estadisticasRep, Response response) {
                asignarValores(estadisticasRep);
            }

            @Override
            public void failure(RetrofitError error) {
                EstadisticasRep x = new EstadisticasRep();
                x.setJugadas(1);
                x.setGanadas(1);
                x.setKills(1);
                x.setDeads(1);
                x.setAssists(1);
                x.setMejorUbicacion("la juana");
                x.setPuntaje("diez mil");
                asignarValores(x);
            }
        });
    }

    public void asignarValores(EstadisticasRep est){
        TextView ca00 = (TextView) findViewById(R.id.jugadasValue);
        ca00.setText(""+est.getJugadas());
        TextView ca02 = (TextView) findViewById(R.id.ganadasValue);
        ca02.setText(""+est.getGanadas());
        TextView ca03 = (TextView) findViewById(R.id.killsValue);
        ca03.setText(""+est.getKills());
        TextView ca04 = (TextView) findViewById(R.id.deadsValue);
        ca04.setText(""+est.getDeads());
        TextView ca05 = (TextView) findViewById(R.id.assistsValue);
        ca05.setText(""+est.getAssists());
        TextView ca06 = (TextView) findViewById(R.id.mejorUbicacionValue);
        ca06.setText(""+est.getMejorUbicacion());
        TextView ca07 = (TextView) findViewById(R.id.puntajeValue);
        ca07.setText(""+est.getPuntaje());
    }
    ;
}

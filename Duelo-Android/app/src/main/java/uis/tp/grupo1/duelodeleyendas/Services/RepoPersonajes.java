package uis.tp.grupo1.duelodeleyendas.Services;


import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import uis.tp.grupo1.duelodeleyendas.Model.PersonajeRep;

/**
 * Created by sebastian on 26/10/15.
 */
public class RepoPersonajes {



    public RepoPersonajes(){

    }


    public static PersonajesServices createPersonajesServices(){
        String SERVER_IP = "10.12.0.200";
        String SERVER_IP_GENY= "127.0.0.1";
        String API_URL = "http://10.12.0.200:9000";
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        PersonajesServices personajesServicess = restAdapter.create(PersonajesServices.class);
        return personajesServicess;
    }


}

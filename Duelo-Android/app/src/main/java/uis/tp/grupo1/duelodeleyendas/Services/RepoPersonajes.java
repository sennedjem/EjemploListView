package uis.tp.grupo1.duelodeleyendas.Services;


import retrofit.RestAdapter;

/**
 * Created by sebastian on 26/10/15.
 */
public class RepoPersonajes {



    public RepoPersonajes(){

    }


    public PersonajesServices createPersonajesServices(){
        String SERVER_IP = "127.0.0.1";
        String SERVER_IP_GENY= "127.0.0.1";
        String API_URL = "http://192.168.1.37:9000";
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        PersonajesServices personajesServicess = restAdapter.create(PersonajesServices.class);
        return personajesServicess;
    }

}

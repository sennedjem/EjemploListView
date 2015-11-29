package uis.tp.grupo1.duelodeleyendas;

    import java.util.List;

    import retrofit.Callback;
    import retrofit.http.GET;


/**
 * Created by sebastian on 26/11/15.
 */

public interface PersonajesServices {
    @GET("/personajesNombres")
    void getPersonajesNombres(Callback<List<String>> callback);
}

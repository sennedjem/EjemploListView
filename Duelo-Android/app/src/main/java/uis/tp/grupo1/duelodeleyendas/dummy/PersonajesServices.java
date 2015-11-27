package uis.tp.grupo1.duelodeleyendas.dummy;

    import java.util.List;

    import retrofit.http.GET;
    import retrofit.Call;

/**
 * Created by sebastian on 26/11/15.
 */

public interface PersonajesServices {
    @GET("/personajesNombres")
    Call<List<String>> getPersonajes();
}

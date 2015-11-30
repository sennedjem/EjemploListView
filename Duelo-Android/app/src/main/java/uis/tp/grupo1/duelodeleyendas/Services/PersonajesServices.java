package uis.tp.grupo1.duelodeleyendas.Services;

    import java.util.List;

    import retrofit.Callback;
    import retrofit.http.GET;
    import retrofit.http.Path;
    import uis.tp.grupo1.duelodeleyendas.Model.EstadisticasRep;
    import uis.tp.grupo1.duelodeleyendas.Model.PersonajeRep;


/**
 * Created by sebastian on 26/11/15.
 */

public interface PersonajesServices {
    @GET("/personajesNombres")
    void getPersonajesNombres(Callback<List<String>> callback);

    @GET("/personajesNombres/{persNombre}")
    void getPersonajePorNombre(@Path("persNombre") String personaje, Callback<PersonajeRep> callback);

    @GET("/estadisticas/{persNombre}")
    void getEstadisticasPersonajePorNombre(@Path("persNombre") String personaje, Callback<EstadisticasRep> callback);
}

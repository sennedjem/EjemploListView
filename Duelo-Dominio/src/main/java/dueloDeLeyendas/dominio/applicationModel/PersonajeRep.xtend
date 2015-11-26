package dueloDeLeyendas.dominio.applicationModel

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PersonajeRep {
	
	var String nombre
	var String path
	var List<String> especialidades
	var List<String> debilidades
	var String posicionIdeal
	var EstadisticasRep stat
	
	new(Personaje pers, String p, Jugador jugador){
		nombre = pers.nombre
		path = p
		especialidades = pers.especialidades
		debilidades = pers.debilidades
		posicionIdeal = pers.posicionIdeal
		stat = new EstadisticasRep(jugador.getEstadisticas(pers))
	}
	
}
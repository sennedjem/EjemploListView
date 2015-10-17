package dueloDeLeyendas.dominio.sistemaDeDuelos

import java.util.List

import org.eclipse.xtend.lib.annotations.Accessors

import java.util.ArrayList
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo
import org.uqbar.commons.utils.Observable
import java.util.Random

@Observable
@Accessors class SistemaDeDuelos {
	
	var List<Jugador> jugadores
	var List<Personaje> personajesDisponibles
	var List<Personaje> personajesDesactivados
	val RealizadorDuelo realizadorDuelo
	var List<ResultadoDuelo> resultadosDuelo
	
	/**Constructor, crea una nueva instacia de sistema con un realizador de duelos*/
	new(RealizadorDuelo rd){
		jugadores = new ArrayList
		personajesDisponibles = new ArrayList
		personajesDesactivados = new ArrayList
		realizadorDuelo = rd
	}

	/**Dado un jugador y un personaje, busca un rival apropiado. De no encontrar ninguna lanza una excepcion */
	def Jugador encontrarRivalAcorde(Jugador jugador, Personaje personaje){
		val rankingMenor = jugador.ranking - 100
		val rankingMayor = jugador.ranking + 100	
		for (Jugador j: jugadores){
			if((rankingMenor < j.ranking || rankingMayor > j.ranking) && j!=jugador)
			return j
		}
		throw new NoHayRival()
	}
	
	/**Busca un personaje para el duelo distinto al del retador */
	def Personaje filtrarPersonaje(List<Personaje> personajes, Personaje pers) {
		for(Personaje j: personajes)
			if(j != pers)
			return j 
	}

	/**Inicia un nuevo duelo con los parametros necesarios */
	def ResultadoDuelo iniciarDuelo(Jugador ret, Personaje personaje, String pos){
		val Jugador rival = this.encontrarRivalAcorde (ret, personaje)
		val Personaje rivPers = this.buscarPersonajeParaDuelo(ret, personaje)
		rival.agregarEstadistica(rivPers)
		var ResultadoDuelo res= realizadorDuelo.realizarDuelo(pos, ret, rival, personaje, rivPers)
		resultadosDuelo.add(res)
		res
	}
	
	/**Retorna un personaje apto para iniciar el duelo, de no encontrar ninguno devuelve cualquier personaje siendo este
	 * siempre distinto al personaje del retador */
	def Personaje buscarPersonajeParaDuelo(Jugador jugador, Personaje personaje) { 
		var List<Personaje> personajesAptos = new ArrayList
		var Personaje personajeApto
		for (Estadisticas e: jugador.getMisEstadisticas())
			if (e.cantDuelosIniciados > 0)
 				personajesAptos.add(e.personaje)
		if (personajesAptos.size > 0)
			personajeApto= filtrarPersonaje(jugador.personajesConLosQueJuge,personaje)
		else personajeApto= filtrarPersonaje(personajesAptos,personaje)
			 	
		return personajeApto
	}
	
	/**Agregar un personaje a la lista de personajes disponibles para usar */
	def void agregarPersonaje(Personaje personaje){
		personajesDisponibles.add(personaje)
	}
		
	/**Elimina al personaje de la lista de personajes disponibles pero no del sistema alcenandolo en otra lista */
	def desactivarPersonaje(Personaje personaje){
		personajesDesactivados.add(personaje)
		personajesDisponibles.remove(personaje)
	}
	
	/**Reactiva un personaje */
	def activarPersonaje(Personaje personaje){
		if(personajesDesactivados.contains(personaje))
			personajesDisponibles.add(personaje)
			personajesDesactivados.remove(personaje)
	}
	
	/** Agrega un jugador previamente creado a la lista de jugadores*/
	def void agregarJugador(Jugador jugador){
		jugadores.add(jugador)
	}
	
	/**Crea un jugador nuevo y lo agrega al sistema*/
	def void crearJugadorNuevo(String nombreJugador){
		jugadores.add(new Jugador(nombreJugador, this))
	}	
	
	/**Agrega una habilidad al personaje pasado por parametro */
	def void agregarHabilidadPersonaje(Personaje per, String habilidad){
		if(personajesDisponibles.contains(per))
			per.agregarEspecialidad(habilidad)
	}
	
	/**Agrega una debilidad al personaje pasado por parametro */
	def void agregarDebilidadPersonaje(Personaje per, String debilidad){
		if(personajesDisponibles.contains(per))
			per.agregarDebilidad(debilidad)
	}
	
	/**Quita una hablidad al personaje pasado por parametro */
	def void quitarHabilidad(Personaje per, String habilidad){
		if(personajesDisponibles.contains(per))
			per.especialidades.remove(habilidad)
	}
	
	/**Quita una hablidad al personaje pasado por parametro */
	def void quitarDebilidad(Personaje per, String debilidad){
		if(personajesDisponibles.contains(per))
			per.especialidades.remove(debilidad)
	}
}
package dueloDeLeyendas.dominio.sistemaDeDuelos

import java.util.List

import org.eclipse.xtend.lib.annotations.Accessors

import java.util.ArrayList
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.realizarDuelo.RealizadorDuelo
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

@Accessors class SistemaDeDuelos {
	
	var List<Jugador> jugadores
	var List<Personaje> personajesDisponibles
	var List<Personaje> personajesDesactivados
	val RealizadorDuelo realizadorDuelo
	
	new(RealizadorDuelo realizDuelo) {
		jugadores = new ArrayList
		personajesDisponibles = new ArrayList
		personajesDesactivados = new ArrayList
		realizadorDuelo = realizDuelo
	}

	/*Devuelve un jugador en el mismo escalon de ranking. Si no encuentra ninguno crea y devuelve una nueva instancia de Mr.X */
	def Jugador encontrarRivalAcorde(Jugador jugador, Personaje personaje){
		val rankingMenor = jugador.ranking - 100
		val rankingMayor = jugador.ranking + 100		
		for (Jugador j: jugadores){
			if((rankingMenor < j.ranking || rankingMayor > j.ranking) && j!=jugador )
			return j
		}
		return generarJugadorMrX(jugador, personaje)
	}
	
	/*Genera y devuelve una instancia nueva de Mr.X con todos los paramenteros necesarios para el duelo igual que el retador
	 por lo tanto el ganador del duelo se decide por el numero de suerte*/
	def Jugador generarJugadorMrX(Jugador jugador, Personaje personaje) {
		var Jugador mrX= new Jugador("MR.x", this)
		val Personaje per=filtrarPersonaje(personajesDisponibles, personaje)
		val Estadisticas est = new Estadisticas(per, mrX)
		mrX => [
		puntuacionRanking = jugador.puntuacionRanking
		pesoDenuncias = jugador.pesoDenuncias
		agregarPersonaje(per)]
		val Estadisticas estadisticaMrX= jugador.getEstadisticas(personaje)
		est=>[
			cantDuelosIniciados = estadisticaMrX.cantDuelosIniciados
			cantDuelosGanados = estadisticaMrX.cantDuelosGanados
			cantKills = estadisticaMrX.cantKills
			cantDeads = estadisticaMrX.cantDeads
			assists = estadisticaMrX.assists
			ubicacionesUsadas = estadisticaMrX.ubicacionesUsadas
			mejorUbicacion = estadisticaMrX.mejorUbicacion
			clasificacion = estadisticaMrX.clasificacion
		]
		mrX.misEstadisticas.add(est)
		mrX
	}
	
	/*Devuelve un personaje para participar de un duelo diferente al del retador (que es el pasado por parametro) */
	def Personaje filtrarPersonaje(List<Personaje> personajes, Personaje pers) {
		for(Personaje j: personajes)
			if(j != pers)
				return j
	}

	/*recibe un Jugador (retador), el personaje y la posicion seleccionada por el susodicho, busca un rival y realiza el duelo e/ estos dos */
	def void iniciarDuelo(Jugador ret, Personaje personaje, String pos){
		val Personaje rivPers = this.buscarPersonajeParaDuelo(ret, personaje)
		val Jugador rival = this.encontrarRivalAcorde (ret, personaje)
		realizadorDuelo.realizarDuelo(pos, ret, rival, personaje, rivPers)
	}
	
	/*Dado un jugador busca los personajes capaces de afrontar el duelo. De no encontrar ninguno, devuelve cualquier personaje */
	def Personaje buscarPersonajeParaDuelo(Jugador jugador, Personaje personaje) { 
		var List<Personaje> personajesAptos = new ArrayList
		var Personaje personajeApto
		for (Estadisticas e: jugador.getMisEstadisticas())
			if (e.cantDuelosIniciados > 0)
 				personajesAptos.add(e.personaje)
		if (personajesAptos.size > 0)
			personajeApto= filtrarPersonaje(jugador.personajes,personaje)
		else 
			personajeApto= filtrarPersonaje(personajesAptos,personaje)
			 	
		return personajeApto
	}
	
	/*Agrega un personaje a la lista de personajes del sistema */
	def void agregarPersonaje(Personaje personaje){
		personajesDisponibles.add(personaje)
	}
	
	def  void modificarPersonaje(){
		//454545454545454545454
	}
	
	/*Desactiva un personaje, haciendo que no sea posible seleccionarlo pero no lo elimina del sistema */
	def desactivarPersonaje(Personaje personaje){
		this.personajesDesactivados.add(personaje)
		this.personajesDisponibles.remove(personaje)
	}
	
	/* agregar un jugador previamente creado a la lista de jugadores*/
	def void agregarJugador(Jugador jugador){
		//jugadores.add(new Jugador(nombreJugador, this)) 
		jugadores.add(jugador)
	}
	
	/*Crea un jugador nuevo y lo agrega al sistema*/
	def void crearJugadorNuevo(String nombreJugador){
		jugadores.add(new Jugador(nombreJugador, this))
	}
		
	
}
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
	
	/*Constructor, crea una nueva instacia de sistema con un realizador de duelos*/
	new(RealizadorDuelo rd){
		jugadores = new ArrayList
		personajesDisponibles = new ArrayList
		personajesDesactivados = new ArrayList
		realizadorDuelo = rd
	}

	/*Dado un jugador y un personaje, busca un rival apropiado. De no encontrar ninguna lanza una excepcion */
	def Jugador encontrarRivalAcorde(Jugador jugador, Personaje personaje){
		val rankingMenor = jugador.ranking - 100
		val rankingMayor = jugador.ranking + 100	
		for (Jugador j: jugadores){
			if((rankingMenor < j.ranking || rankingMayor > j.ranking) && j!=jugador)
			return j
		}
		throw new NoHayRival()
	}
	
	/*Crea y retorna al jugador Mr.X cuando no hay un rival apropiado. Se inicializa con parametros identicos al retador*/
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
	
	/*Busca un personaje para el duelo distinto al del retador */
	def Personaje filtrarPersonaje(List<Personaje> personajes, Personaje pers) {
		for(Personaje j: personajes)
			if(j != pers)
				return j
	}

	/*Inicia un nuevo duelo con los parametros necesarios */
	def void iniciarDuelo(Jugador ret, Personaje personaje, String pos){
		val Personaje rivPers = this.buscarPersonajeParaDuelo(ret, personaje)
		val Jugador rival = this.encontrarRivalAcorde (ret, personaje)
		realizadorDuelo.realizarDuelo(pos, ret, rival, personaje, rivPers)
	}
	
	/*Retorna un personaje apto para iniciar el duelo, de no encontrar ninguno devuelve cualquier personaje siendo este
	 * siempre distinto al personaje del retador */
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
	
	/*Agregar un personaje a la lista de personajes disponibles para usar */
	def void agregarPersonaje(Personaje personaje){
		personajesDisponibles.add(personaje)
	}
		
	/*Elimina al personaje de la lista de personajes disponibles pero no del sistema alcenandolo en otra lista */
	def desactivarPersonaje(Personaje personaje){
		this.personajesDesactivados.add(personaje)
		this.personajesDisponibles.remove(personaje)
	}
	
	
	/* Agrega un jugador previamente creado a la lista de jugadores*/
	def void agregarJugador(Jugador jugador){
		jugadores.add(jugador)
	}
	
	/*Crea un jugador nuevo y lo agrega al sistema*/
	def void crearJugadorNuevo(String nombreJugador){
		jugadores.add(new Jugador(nombreJugador, this))
	}	
	
}
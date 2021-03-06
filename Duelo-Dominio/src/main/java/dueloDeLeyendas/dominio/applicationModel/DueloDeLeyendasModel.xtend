package dueloDeLeyendas.dominio.applicationModel

import dueloDeLeyendas.dominio.duelo.RealizadorDuelo
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.utils.Observable

/*
 * Inicializacion a la Application
 */
@Observable
@Accessors
class DueloDeLeyendasModel {
	List<Personaje> personajes
	String posicion
	RealizadorDuelo realizador
	Jugador capitanZanahoria
	
	
	
	/**Inicializa todos los colaboradores de la clase */
	new(){
		sistema = new SistemaDeDuelos(new RealizadorDuelo)
		jugador = new Jugador("Marcos", sistema)
		capitanZanahoria = new Jugador("capitanZanahoria", sistema)
		personajes = new ArrayList
		sistema.agregarJugador(capitanZanahoria)
		inicializarPersonajes
		inicializarStats
		

		
		todosLosPersonajes = personajes.map[ jugador.getPuntajePara(it)]
	}	
	
	/** Crea una serie de stats en cero para los personajes que el jugador todavia no uso */
	
	/** Inicializa los 8 personajes de la pantalla principal, los agrega a la lista de personajes del modelo,
	 * le agrega cuatro personajes al jugador, y pone al primer personaje como el personaje 
	 * seleccionado por defecto en la pantalla */
	def inicializarPersonajes(){
		var habilidades = #["Ataque", "Defensa"]
		var habilidades2= #["Auto recuperacion"]
		var habilidades3 = #["Daño a distancia", "Hundir acorazados"]
		var habilidades4 = #["Proteccion ante hechizos", "Auto recuperacion"]
		var habilidades5 = #["Sale de la B en un año"]
		var habilidades6 = #["Punteria aumentada", "Velocidad superSonica", "Proteccion celestial"]
		var habilidades7 = #["Velocidad de Lince", "Compartir XP"]
		var habilidades8= #["Agilidad imperial", "Robo de vida"]
		
		var debilidades = #["Alergico al agua"]
		var debilidades2= #["Miedo a la Obscuridad", "Ataque de asma"]
		var debilidades3 = #["No sabe leer", ""]
		var debilidades4 = #["Hemorragia veloz"]
		var debilidades5 = #["Torpeza"]
		var debilidades6= # ["Baja concentracion"]
		var debilidades7= #["Inferioridad ante magia"]
		var debilidades8 = #["Fotosensibilidad"]
		
		val Personaje per1= new Personaje("Amumu", habilidades, debilidades7, "MID")
		val Personaje per2 = new Personaje ("Techies", habilidades2, debilidades2, "TOP")
		val Personaje per3 = new Personaje("Katarina", habilidades3, debilidades3, "JUNGLE")
		val Personaje per4 = new Personaje ("Sniper", habilidades4, debilidades4, "BOT")
		val Personaje per5 = new Personaje ("Undaying", habilidades5, debilidades5, "MID")
		val Personaje per6 = new Personaje ("Master Yi", habilidades6, debilidades6, "TOP")
		val Personaje per7 = new Personaje ("Axe", habilidades7, debilidades, "JUNGLE")
		val Personaje per8 = new Personaje ("Ashe", habilidades8, debilidades8,"BOT")
		
		personajes => [
			add(per1)
			add(per2)
			add(per3)
			add(per4)
			add(per5)
			add(per6)
			add(per7)
			add(per8)
		]
		
		jugador =>[
			agregarEstadistica(per1)
			agregarEstadistica(per2)
			agregarEstadistica(per4)
			agregarEstadistica(per5)
		]
		

		
		personajeSeleccionado = new PersonajePuntaje(per1, jugador.getEstadisticas(per1).getClasificacionString)
	}
	
	/**Setea los stats para todos los personajes del jugador y crea la lista de personajes para la tabla */
	def inicializarStats(){

	}	

	
	/**Setea las estadisticas del personaje pasado por parametro y con el jugador y datos pasados por parámetro */



	//
	//Hasta aca
	//	
	
	private PersonajePuntaje personajeSeleccionado
	private String buscado
	private Jugador jugador
	private List<PersonajePuntaje> todosLosPersonajes
	private SistemaDeDuelos sistema
	
	/** Setea el string buscado con lo que se pasa por parametro y busca entre los personajes disponibles
	 * los que tengan algo de ese string para mostrarlo en la tabla de personajes de la pantalla */
	def void setBuscado(String nombre){
		buscado = nombre
		ObservableUtils.firePropertyChanged(this,"resultadoBusquedaDePersonajes")
	}
	
	def List<PersonajePuntaje> getResultadoBusquedaDePersonajes(){
		if (buscado.empty) todosLosPersonajes
		else todosLosPersonajes.filter[it.pers.nombre.contains(buscado)].toList
	}

	/** Devuelve los stats del personaje seleccionado actualmente */
	def getStatsPersonajeSeleccionado(){
	
	}
	
	/** Setea el personaje seleccionado con el que se pasa por parámetro y dispara la notificación
	 * para que se actualicen sus datos en la pantalla */
	def setPersonajeSeleccionado(PersonajePuntaje p){
		personajeSeleccionado = p
		ObservableUtils.firePropertyChanged(this, "statsPersonajeSeleccionado")
	}
	
	def ResultadoDuelo  iniciarDuelo(){
		jugador.peleasCon(personajeSeleccionado.pers)
		sistema.iniciarDuelo(jugador, personajeSeleccionado.pers, posicion)
	}

} 
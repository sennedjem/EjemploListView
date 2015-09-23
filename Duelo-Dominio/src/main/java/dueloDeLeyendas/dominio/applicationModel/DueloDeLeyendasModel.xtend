package dueloDeLeyendas.dominio.applicationModel

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.personaje.Personaje
import java.util.HashSet
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import org.uqbar.commons.model.ObservableUtils
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo

@Observable
@Accessors
class DueloDeLeyendasModel {
	Jugador jugador
	SistemaDeDuelos sistema
	List<PersonajePuntaje> personajesFiltrados
	List<Personaje> personajes
	PersonajePuntaje personajeSeleccionado
	String buscado
	Estadisticas statsPersonajeSeleccionado
	String posicion
	RealizadorDuelo realizador
	ResultadoDuelo resultado
	Jugador capitanZanahoria
	
	/**Inicializa todos los colaboradores de la clase */
	new(){
		sistema = new SistemaDeDuelos(new RealizadorDuelo)
		jugador = new Jugador("Marcos", sistema)
		capitanZanahoria = new Jugador("capitanZanahoria", sistema)
		personajes = new ArrayList
		personajesFiltrados = new ArrayList
		sistema.agregarJugador(capitanZanahoria)
		inicializarPersonajes
		inicializarStats
	}	
	
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
		]
		
		jugador =>[
			agregarPersonaje(per1)
			agregarPersonaje(per2)
			agregarPersonaje(per4)
			agregarPersonaje(per5)
		]
		capitanZanahoria =>[
			agregarPersonaje(per1)
			agregarPersonaje(per2)
			agregarPersonaje(per4)
			agregarPersonaje(per5)
		]
		
		personajeSeleccionado = new PersonajePuntaje(per1, jugador.getEstadisticas(per1).getClasificacionString)
	}
	
	/**Setea los stats para todos los personajes del jugador y crea la lista de personajes para la tabla */
	def inicializarStats(){
		setearEstadisticas(jugador, personajes.get(0), 60, 40, 5, 8, "TOP")
		setearEstadisticas(jugador, personajes.get(1), 40, 50, 4, 9, "MID")
		setearEstadisticas(jugador, personajes.get(3), 10, 70, 7, 0, "JUNGLE")
		setearEstadisticas(jugador, personajes.get(4), 55, 45, 4, 20, "BOT")
		setearEstadisticas(capitanZanahoria, personajes.get(0), 60, 40, 5, 8, "TOP")
		setearEstadisticas(capitanZanahoria, personajes.get(1), 40, 50, 4, 9, "MID")
		setearEstadisticas(capitanZanahoria, personajes.get(3), 10, 70, 7, 0, "JUNGLE")
		setearEstadisticas(capitanZanahoria, personajes.get(4), 55, 45, 4, 20, "BOT")
		
		personajesFiltrados = getPersonajePuntaje()

	}	

	
	/**Setea las estadisticas del personaje pasado por parametro y con el jugador y datos pasados por parámetro */
	def setearEstadisticas(Jugador jugador, Personaje personaje, Integer clas, Integer assist1,
							Integer deads, Integer kills, String pos) {
		jugador.getEstadisticas(personaje)=>[
			assists = assist1
			cantDeads = deads
			cantDuelosGanados = 7
			cantKills = kills
			clasificacion = clas
			mejorUbicacion = pos
			cantDuelosIniciados = 1
			ubicacionesUsadas = new ArrayList()

		]
	
	}
		
	/**Devuelve la lista de PersonajePuntaje en base a los personajes del sistema para mostrar en la 
	 * tabla de personajes de la pantalla */
	def getPersonajePuntaje(){
		var List<PersonajePuntaje> perpunt = new ArrayList
		for (Personaje p : personajes)
			if (jugador.getEstadisticas(p) == null){
				perpunt.add(new PersonajePuntaje(p, "NOOB"))
				}
				else{ 
					val String clas = jugador.getEstadisticas(p).getClasificacionString
					perpunt.add (new PersonajePuntaje(p,clas))
			}
		perpunt
	}
	
	/**Devuelve la lista de PersonajePuntaje en base a la lista pasasda por parametro para mostrar en la 
	 * pantalla al realizar la busqueda de los personajes */
	def getPersonajePuntaje(List<Personaje> pers){
		var List<PersonajePuntaje> perpunt = new ArrayList
		for (Personaje p : pers)
			if (jugador.getEstadisticas(p) == null){
				perpunt.add(new PersonajePuntaje(p, "NOOB"))
				}
				else{
					val String clas = jugador.getEstadisticas(p).getClasificacionString
					perpunt.add (new PersonajePuntaje(p,clas))
			}
		perpunt
	}
	
	/** Setea el string buscado con lo que se pasa por parametro y busca entre los personajes disponibles
	 * los que tengan algo de ese string para mostrarlo en la tabla de personajes de la pantalla */
	def void setBuscado(String nombre){
		buscado = nombre
		if (nombre == ""){
			personajesFiltrados = getPersonajePuntaje(personajes)
		}
		var filtrados = personajes.filter[it.nombre.contains(nombre)].toList
		personajesFiltrados = getPersonajePuntaje(filtrados)
	}

	/** Devuelve los stats del personaje seleccionado actualmente */
	def getStatsPersonajeSeleccionado(){
		if(personajeSeleccionado != null)
			jugador.getEstadisticas(personajeSeleccionado.pers)
			else
			  this.dummyStats(personajeSeleccionado)
	}
	
	/** Setea el personaje seleccionado con el que se pasa por parámetro y dispara la notificación
	 * para que se actualicen sus datos en la pantalla */
	def setPersonajeSeleccionado(PersonajePuntaje p){
		personajeSeleccionado = p
		ObservableUtils.firePropertyChanged(this, "statsPersonajeSeleccionado")
	}
	
	/** Crea una serie de stats en cero para los personajes que el jugador todavia no uso */
	def dummyStats(PersonajePuntaje pp){
		var est = new Estadisticas(pp.pers, null)=>[
			assists = new Integer(0)
			cantDeads = new Integer(0)
			cantDuelosGanados = new Integer(0)
			cantDuelosIniciados = new Integer(0)
			cantKills = new Integer(0)
			mejorUbicacion = ""
			ubicacionesUsadas = new ArrayList()
			jugados = new Integer(0)
			clasificacion = new Integer(0)
		]
		est
	}
	
	/** Setea el resultado del duelo en el colaborador de la clase */
	def ResultadoDuelo setResultado(){
		if (!jugador.personajes.contains(personajeSeleccionado.pers))
			jugador.agregarPersonaje(personajeSeleccionado.pers)
		resultado = sistema.iniciarDuelo(jugador, personajeSeleccionado.pers, posicion)
	}

} 
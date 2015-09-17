package dueloDeLeyendas.dominio.applicationModel

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.realizarDuelo.RealizadorDuelo
import dueloDeLeyendas.dominio.personaje.Personaje
import java.util.HashSet
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import java.util.ArrayList
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class DueloDeLeyendasModel {
	Jugador jugador
	SistemaDeDuelos sistema
	List<Personaje> personajesFiltrados
	List<Personaje> personajes
	PersonajePuntaje personajeSeleccionado
	String buscado
	
	new(){
		sistema = new SistemaDeDuelos(new RealizadorDuelo)
		jugador = new Jugador("Marcos", sistema)
		personajes = new ArrayList
		inicializarPersonajes
		inicializarStats
	}	
	
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
			agregarPersonaje(per1)
			agregarPersonaje(per2)
			agregarPersonaje(per4)
			agregarPersonaje(per5)
		]
		
		personajeSeleccionado = new PersonajePuntaje (per1, 40)
	}
	
	def inicializarStats(){
		setearEstadisticas(jugador, personajes.get(0), 60)
		setearEstadisticas(jugador, personajes.get(1), 40)
		setearEstadisticas(jugador, personajes.get(3), 10)
		setearEstadisticas(jugador, personajes.get(4), 55)
	}
	
	def setearEstadisticas(Jugador jugador, Personaje personaje, Integer clas) {
		jugador.getEstadisticas(personaje)=>[
			assists = 10
			cantDeads = 3
			cantDuelosGanados = 7
			cantKills = 7
			clasificacion = clas
			mejorUbicacion = "TOP"
			ubicacionesUsadas = new HashSet
		]
	}
		
	def getPersonajePuntaje(){
		var List<PersonajePuntaje> perpunt = new ArrayList
		for (Personaje p : personajes)
			if (jugador.getEstadisticas(p) == null){
				perpunt.add(new PersonajePuntaje(p, 0))
				}
				else{ 
					val double clas = jugador.getEstadisticas(p).getClasificacion
					perpunt.add (new PersonajePuntaje(p,clas))
			}
		perpunt
	}
	
	def void setBuscado(String nombre){
		this.buscado = nombre;
		personajesFiltrados = personajes.filter[it.nombre.contains(nombre)].toList
	}

}
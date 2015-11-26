package dueloDeLeyendas.dominio.applicationModel

import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.jugador.Jugador
import java.util.List
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

@Accessors
class RepoWeb {
	var Jugador jugador
	
	new(Jugador j){
		jugador = j
	}
	
	def personajes(){
		var pers = newArrayList
		
		var habilidades = #["Ataque", "Defensa"]
		var habilidades2= #["Auto recuperacion"]
		var habilidades3 = #["Daño a distancia", "Hundir acorazados"]
		var habilidades4 = #["Proteccion ante hechizos", "Auto recuperacion"]
		
		var debilidades = #["Alergico al agua"]
		var debilidades2= #["Miedo a la Obscuridad", "Ataque de asma"]
		var debilidades3 = #["No sabe leer", ""]
		var debilidades4 = #["Hemorragia veloz"]
		
		val Personaje per1= new Personaje("Amumu", habilidades, debilidades, "MID")
		val Personaje per2 = new Personaje ("Mirana", habilidades2, debilidades2, "TOP")
		val Personaje per3 = new Personaje("Pudge", habilidades3, debilidades3, "JUNGLE")
		val Personaje per4 = new Personaje ("Skywrath", habilidades4, debilidades4, "BOT")
		
		jugador =>[
			agregarEstadistica(per1)
			agregarEstadistica(per2)
			agregarEstadistica(per3)
			agregarEstadistica(per4)
		]
		
		val PersonajeRep pers1 = new PersonajeRep(per1, "amumu.jpg",jugador)
		val PersonajeRep pers2 = new PersonajeRep(per2, "mirana.jpg",jugador)
		val PersonajeRep pers3 = new PersonajeRep(per3, "pudge.jpg",jugador)
		val PersonajeRep pers4 = new PersonajeRep(per4, "skywrath.jpg",jugador)
			
		pers => [
			add(pers1)
			add(pers2)
			add(pers3)
			add(pers4)
		]	
	}
	
}
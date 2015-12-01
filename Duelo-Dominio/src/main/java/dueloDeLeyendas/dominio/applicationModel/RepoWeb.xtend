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
		var habilidades5 = #["Magia", "Recuperación acelerada"]
		var habilidades6 = #["Ataque avanzado con espada", "Magia"]
		var habilidades7 = #["Protección durante 10 segundos"]
		var habilidades8 = #["Chaleco antibalas", "Resistencia al fuego"]
		var habilidades9 = #["Ataque triplicado", "Defensa inquebrantable"]
		var habilidades10 =  #["Magia"]
				
		var debilidades = #["Alergico al agua"]
		var debilidades2= #["Miedo a la Obscuridad", "Ataque de asma"]
		var debilidades3 = #["No sabe leer", "Poca resistencia"]
		var debilidades4 = #["Hemorragia veloz"]
		var debilidades5 = #["Impactos de bala", "Batalla cuerpo a cuerpo"]
		var debilidades6 = #["Ataque de espada"]
		var debilidades7 = #["Ataque de brujos"]
		var debilidades8 = #["Ataque de heroes"]
		var debilidades9 = #["Batallas largas"]
		var debilidades10 = #["Ataques directos"]
		
		val Personaje per1= new Personaje("Amumu", habilidades, debilidades, "MID")
		val Personaje per2 = new Personaje ("Mirana", habilidades2, debilidades2, "TOP")
		val Personaje per3 = new Personaje("Pudge", habilidades3, debilidades3, "JUNGLE")
		val Personaje per4 = new Personaje ("Skywrath", habilidades4, debilidades4, "BOT")
		val Personaje per5 = new Personaje ("Clockwerk", habilidades5, debilidades5, "MID")
		val Personaje per6 = new Personaje ("Bloodseeker", habilidades6, debilidades6, "TOP")
		val Personaje per7 = new Personaje ("Clinkz", habilidades7, debilidades7, "JUNGLE")
		val Personaje per8 = new Personaje ("Draven", habilidades8, debilidades8, "BOT")
		val Personaje per9 = new Personaje ("Graves", habilidades9, debilidades9, "JUNGLE")
		val Personaje per10 = new Personaje ("Jayce", habilidades10, debilidades10, "MID")
		
		jugador =>[
			agregarEstadistica(per1)
			agregarEstadistica(per2)
			agregarEstadistica(per3)
			agregarEstadistica(per4)
			agregarEstadistica(per5)
			agregarEstadistica(per6)
			agregarEstadistica(per7)
			agregarEstadistica(per8)
			agregarEstadistica(per9)
			agregarEstadistica(per10)
		]
		
		val PersonajeRep pers1 = new PersonajeRep(per1, "@drawable/amumu",jugador)
		val PersonajeRep pers2 = new PersonajeRep(per2, "@drawable/mirana",jugador)
		val PersonajeRep pers3 = new PersonajeRep(per3, "@drawable/pudge",jugador)
		val PersonajeRep pers4 = new PersonajeRep(per4, "@drawable/skywrath",jugador)
		val PersonajeRep pers5 = new PersonajeRep(per5, "@drawable/clockwerk", jugador)
		val PersonajeRep pers6 = new PersonajeRep(per6, "@drawable/bloodseeker", jugador)
		val PersonajeRep pers7 = new PersonajeRep(per7, "@drawable/clinkz", jugador)
		val PersonajeRep pers8 = new PersonajeRep(per8, "@drawable/draven", jugador)
		val PersonajeRep pers9 = new PersonajeRep(per9, "@drawable/graves", jugador)
		val PersonajeRep pers10 = new PersonajeRep(per10, "@drawable/jayce", jugador)
			
		pers => [
			add(pers1)
			add(pers2)
			add(pers3)
			add(pers4)
			add(pers5)
			add(pers6)
			add(pers7)
			add(pers8)
			add(pers9)
			add(pers10)
		]	
	}
	
}
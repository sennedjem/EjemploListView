package dueloDeLeyendas.dominio.jugador

import dueloDeLeyendas.dominio.applicationModel.PersonajePuntaje
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Observable
@Accessors class Jugador {
	/**Modela al jugador */
	
	var String nombreJugador
	var Integer pesoDenuncias
	var Integer puntuacionRanking
	var List<Estadisticas> misEstadisticas
	var SistemaDeDuelos sistema
	
	
	/** Crea una nueva instancia de jugador con los parametros necesarios */
	new(String nombre, SistemaDeDuelos sist){
		nombreJugador = nombre
		pesoDenuncias = 0
		puntuacionRanking = 0
		misEstadisticas = new ArrayList
		sistema = sist
		agregarTodosLosPjAEstadisticas
	}
	
	def agregarTodosLosPjAEstadisticas() {
		
		 for(Personaje per: sistema.personajesDisponibles){
			agregarEstadistica(per)
         }
	}
	
	/**Devuelve el raking de jugador */
	def Integer getRanking() {
		pesoDenuncias* cantDuelosGanados
	}
	
	/**Devuelde la cantidad de duelos ganador por el jugador */
	def cantDuelosGanados() { 
		var Integer cantidadDG = 0
		for (Estadisticas e: misEstadisticas)
			cantidadDG = cantidadDG + e.getCantDuelosGanados
		
		return cantidadDG
	}
	
	
	def agregarEstadistica(Personaje pers){
		misEstadisticas.add(new Estadisticas(pers, this,sistema))
	}
	
	/**Devuelve la estadistica correspondiente al personaje pasado por parametro */
	def getEstadisticas (Personaje pers){
		var Estadisticas estadistica
		for (Estadisticas est: misEstadisticas)
			if(est.getPersonaje == pers)
				estadistica=est
		estadistica
	}
	
	
	/**Suma al peso de denuncias cuando es denunciado */
	def sumaleATuPesoDeDenuncia(Integer peso) {
		this.setPesoDenuncias (this.pesoDenuncias + peso)
	}
	

	/**Suma una calificacion pasada por parametro a la estadistica de un personaje, tambien pasado por parametro */
	def sumaCalificacion(Personaje per ,Integer i) {
		val Estadisticas est = getEstadisticas(per)
		est.setClasificacion(i)
	}
	
	def getPuntajePara(Personaje personaje) {
			val estadistica = getEstadisticas(personaje)
			if (estadistica == null) new PersonajePuntaje(personaje, "NOOB")
			else new PersonajePuntaje(personaje,estadistica.clasificacionString)
	}
	
	def peleasCon(Personaje per) {
		if (noJugeConPersonaje(per))
			this.agregarEstadistica(per)
	}
	
	def personajesConLosQueJuge() {
		misEstadisticas.map[personaje]
	}
	
	def noJugeConPersonaje(Personaje per) {
		!this.misEstadisticas.forall[e| e.personaje== per]
	}
	
	def agregarPersonajes(java.util.ArrayList<dueloDeLeyendas.dominio.personaje.Personaje> personajes) {
		personajes.addAll(personajes)
	}
	
	
	
	
}
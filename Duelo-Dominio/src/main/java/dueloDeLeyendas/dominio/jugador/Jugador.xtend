package dueloDeLeyendas.dominio.jugador


import java.util.List

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.ArrayList
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos

@Accessors class Jugador {
	/*
	 * 
	 */
	
	var String nombreJugador
	var Integer pesoDenuncias
	var Integer puntuacionRanking
	var List<Personaje> personajes
	var List<Estadisticas> misEstadisticas
	var SistemaDeDuelos sistema
	
	new(String nombre, SistemaDeDuelos sist){
		nombreJugador = nombre
		pesoDenuncias = 0
		puntuacionRanking = 0
		personajes = new ArrayList
		misEstadisticas = new ArrayList
		sistema = sist
	}

	def void iniciarDuelo (SistemaDeDuelos sistema, Personaje personaje, String posicion){
		sistema.iniciarDuelo(this, personaje,posicion)
	} 
	
	def Integer getRanking() {
		pesoDenuncias* cantDuelosGanados
	}
	
	def cantDuelosGanados() {
		var Integer cantidadDG = 0
		for (Estadisticas e: misEstadisticas){
			cantidadDG = cantidadDG + e.getCantDuelosGanados
		}
		return cantidadDG
	}
	
	def agregarPersonaje(Personaje pers){
		personajes.add(pers)
	}
	
	def getEstadisticas (Personaje pers){
		var Estadisticas estadistica
		for (Estadisticas est: misEstadisticas)
			if(est.getPersonaje == pers)
				estadistica=est
		estadistica
	}
	
	def ganeSumarAEstadisticas(Jugador retador, Personaje personaje, String posicion, double clasificacion) {
		var Estadisticas est = getEstadisticas(personaje)
		if (retador == this)
			est.actualizarGaneRetador(posicion,clasificacion)
		 else 
			est.actualizarGane()
	}
	
	def perdiSumarAEstadisticas(Jugador retador, Personaje personaje, String posicion, double clasificacion) {
		var Estadisticas est = getEstadisticas(personaje)
		if (retador == this)
			est.actualizarPerdiRetador(posicion, clasificacion)
		 else 
			est.actualizarPerdi()
	}
	
	def empateSumarAEstadisticas(Jugador retador,Personaje personaje, String ubicacion, double clasificacion) {
		val Estadisticas est = getEstadisticas(personaje)
		if (retador == this)
			est.actualizarEmpateRetador(ubicacion, clasificacion)
		else
			est.actualizarEmpate()
	}
	
	
	def sumaleATuPesoDeDenuncia(Integer peso) {
		this.setPesoDenuncias (this.pesoDenuncias + peso)
	}
	

	
	def sumaCalificacion(Personaje per ,Integer i) {
		val Estadisticas est = getEstadisticas(per)
		est.setClasificacion(i)
	}
	
	
}
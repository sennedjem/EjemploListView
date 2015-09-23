package dueloDeLeyendas.dominio.jugador


import java.util.List

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.ArrayList
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos

@Accessors class Jugador {
	/**Modela al jugador */
	
	var String nombreJugador
	var Integer pesoDenuncias
	var Integer puntuacionRanking
	var List<Personaje> personajes
	var List<Estadisticas> misEstadisticas
	var SistemaDeDuelos sistema
	
	
	/** Crea una nueva instancia de jugador con los parametros necesarios */
	new(String nombre, SistemaDeDuelos sist){
		nombreJugador = nombre
		pesoDenuncias = 0
		puntuacionRanking = 0
		personajes = new ArrayList
		misEstadisticas = new ArrayList
		sistema = sist
	}

	/** Inicia un nuevo duelo con uno mismo como parametro */
	def void iniciarDuelo (SistemaDeDuelos sistema, Personaje personaje, String posicion){
		sistema.iniciarDuelo(this, personaje,posicion)
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
	
	/**Agrega un personaje a la lista de personajes */
	def agregarPersonaje(Personaje pers){
		personajes.add(pers)
		misEstadisticas.add(new Estadisticas(pers, this))
	}
	
	/**Devuelve la estadistica correspondiente al personaje pasado por parametro */
	def getEstadisticas (Personaje pers){
		var Estadisticas estadistica
		for (Estadisticas est: misEstadisticas)
			if(est.getPersonaje == pers)
				estadistica=est
		estadistica
	}
	
	/**Desde el duelo, suma lo necesario a las estadisticas del personaje cuando gana */
	def ganeSumarAEstadisticas(Jugador retador, Personaje personaje, String posicion, double clasificacion) {
		var Estadisticas est = getEstadisticas(personaje)
		if (retador == this)
			est.actualizarGaneRetador(posicion,clasificacion)
		 else 
			est.actualizarGane()
	}
	
	/**Desde el duelo, suma lo necesario a las estadisticas del personaje cuando pierde */
	def perdiSumarAEstadisticas(Jugador retador, Personaje personaje, String posicion, double clasificacion) {
		var Estadisticas est = getEstadisticas(personaje)
		if (retador == this)
			est.actualizarPerdiRetador(posicion, clasificacion)
		 else 
			est.actualizarPerdi()
	}
	
	/**Desde el duelo, suma lo necesario a las estadisticas del personaje cuando empata */
	def empateSumarAEstadisticas(Jugador retador,Personaje personaje, String ubicacion, double clasificacion) {
		val Estadisticas est = getEstadisticas(personaje)
		if (retador == this)
			est.actualizarEmpateRetador(ubicacion, clasificacion)
		else
			est.actualizarEmpate()
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
	
	
	
	
}
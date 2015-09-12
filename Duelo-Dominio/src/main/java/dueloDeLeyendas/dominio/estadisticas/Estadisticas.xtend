package dueloDeLeyendas.dominio.estadisticas


import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Set
import java.util.HashSet

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje

/*
 * Esta clase modela las estadísticas correspondientes a un jugador y un personaje
 */
@Accessors class Estadisticas {
	
	val Personaje personaje
	val Jugador jugador
	var Integer cantDuelosIniciados
	var Integer cantDuelosGanados
	var Integer cantKills
	var Integer cantDeads
	var Integer assists
	var Set<String> ubicacionesUsadas
	var String mejorUbicacion
	var double clasificacion
	
	/*
	 * Este constructor crea una instancia de la clase Estadisticas con los personajes y jugadores pasados
	 * por parametro y todos los demas valores inicializados en 0, o lista vacia.
	 */
	new (Personaje pers, Jugador jug){
		jugador = jug
		personaje = pers
		cantDuelosIniciados = 0
		cantDuelosGanados = 0
		cantKills = 0
		cantDeads = 0
		assists = 0
		ubicacionesUsadas = new HashSet
		mejorUbicacion = ""
		clasificacion = 0
	}
	
	/*
	 * Este metodo aumenta en uno la cantidad de duelos iniciados.
	 */
	 def void sumarIniciado(){
	 	cantDuelosIniciados ++  
	 }
	 
	 /*
	 * Este metodo aumenta en uno la cantidad de duelos ganados.
	 */
	 def void sumarGanado(){
	 	cantDuelosGanados ++
	 }
	  
	 /*
	 * Este metodo aumenta en uno la cantidad de kills.
	 */
	 def void sumarKill(){
	  	cantKills ++
	 }
	   
	 /*
	 * Este metodo aumenta en uno la cantidad de kills.
	 */
	 def void sumarDead(){
	  	cantDeads ++
	 }
	    
	 /*
	 * Este metodo aumenta en uno la cantidad de assists.
	 */
	 def void sumarAssist(){
	   	assists ++
	 }
	     
	 /*
	 * Este metodo agrega la ubicacion en que el personaje fue utilizado en un duelo
	 */
	 def void agregarUbicacion(String ubicacion){
	   	ubicacionesUsadas.add(ubicacion)
	 }
	
	def sumarEmpate(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def sumarPerdida(String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	def sumarVictoria(String string) {
		sumarKill
		sumarGanado
		agregarUbicacion(string)
		setMejorUbicacion(string)
	}
	
	def actualizarGaneRetador(String posicion, double clasificacion) {
		sumarIniciado
		sumarGanado
		agregarUbicacion(posicion)
		setMejorUbicacion(posicion)
		setClasificacion(clasificacion)
	}
	
	def actualizarGane() {
		sumarGanado
		sumarKill
	}
	
	def actualizarPerdi() {
		sumarDead
	}
	
	def actualizarPerdiRetador(String posicion, double clasificacion) {
		sumarIniciado
		agregarUbicacion(posicion)
		setClasificacion(clasificacion)
	}
	
	def actualizarEmpate() {
		sumarAssist
	}
	
	def actualizarEmpateRetador(String posicion,double clasificacion) {
		sumarIniciado
		sumarAssist
		agregarUbicacion(posicion)
		setClasificacion(clasificacion)
		
		
	}
	
	
	def double poderDeAtaque(){
	//calcula el poder de ataque del personaje del jugador
		return (clasificacion * (cantKills + assists / 2 - cantDeads) * cantDuelosIniciados)
	} 
	 
	
	
}
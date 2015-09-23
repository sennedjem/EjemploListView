package dueloDeLeyendas.dominio.estadisticas


import org.eclipse.xtend.lib.annotations.Accessors

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import org.uqbar.commons.utils.Observable
import java.util.List
import java.util.ArrayList
import java.util.Random

/**Modela las estadísticas correspondientes a un jugador y un personaje */
 
@Observable
@Accessors class Estadisticas {
	
	val Personaje personaje
	val Jugador jugador
	var Integer cantDuelosIniciados
	var Integer cantDuelosGanados
	var Integer cantKills
	var Integer cantDeads
	var Integer assists
	var Integer jugados
	var List<String>ubicacionesUsadas
	var String mejorUbicacion
	var double clasificacion
	
	/**Crea una instancia de la clase Estadisticas con los personajes y jugadores pasados
	 * por parametro y todos los demas valores inicializados en 0, o lista vacia. */
	new (Personaje pers, Jugador jug){
		jugador = jug
		personaje = pers
		cantDuelosIniciados = 0
		cantDuelosGanados = 0
		cantKills = 0
		cantDeads = 0
		assists = 0
		jugados = 0
	    ubicacionesUsadas = new ArrayList()	
		mejorUbicacion = ""
		clasificacion = 0
	}
	
	/**Aumenta en uno la cantidad de duelos iniciados. */
	 def void sumarIniciado(){
	 	cantDuelosIniciados ++  
	 }
	 
	 /**Aumenta en uno la cantidad de duelos ganados. */
	 def void sumarGanado(){
	 	cantDuelosGanados ++
	 }
	  
	 /**Aumenta en uno la cantidad de kills. */
	 def void sumarKill(){
	  	cantKills ++
	 }
	   
	 /**Aumenta en uno la cantidad de kills. */
	 def void sumarDead(){
	  	cantDeads ++
	 }
	    
	 /**Aumenta en uno la cantidad de assists. */
	 def void sumarAssist(){
	   	assists ++
	 }
	     
	 /**Agrega la ubicacion en que el personaje fue utilizado en un duelo */
	 def void agregarUbicacion(String ubicacion){
	   	ubicacionesUsadas.add(ubicacion)
	 }
	 
	/**Suma uno a los duelos jugados */
	def sumarJugado(){
		jugados = jugados +1
	}
	
	def sumarVictoria(String string) {
		sumarKill
		sumarGanado
		sumarJugado
		agregarUbicacion(string)
		setMejorUbicacion(string)
	}
	
	/**Actualiza los parametros necesario cuando el jugador que inicia el duelo ganó el mismo */
	def actualizarGaneRetador(String posicion, double clasificacion) {
		sumarIniciado
		sumarGanado
		sumarJugado
		agregarUbicacion(posicion)
		setMejorUbicacion(posicion)
		setClasificacion(clasificacion)
	}
	
	def actualizarGane() {
		sumarGanado
		sumarKill
		sumarJugado
	}
	
	def actualizarPerdi() {
		sumarDead
		sumarJugado
	}
	
	/**Actualiza los parametros necesario cuando el jugador que inicia el duelo perdio el mismo */
	def actualizarPerdiRetador(String posicion, double clasificacion) {
		sumarIniciado
		sumarJugado
		agregarUbicacion(posicion)
		setClasificacion(clasificacion)
	}
	
	def actualizarEmpate() {
		sumarAssist
		sumarJugado
	}
	
	/**Actualiza los parametros necesario cuando el jugador que inicia el duelo empato el mismo */
	def actualizarEmpateRetador(String posicion,double clasificacion) {
		sumarIniciado
		sumarAssist
		sumarJugado
		agregarUbicacion(posicion)
		setClasificacion(clasificacion)	
	}
	
	def setJugados(Integer n){
		jugados = n
	}
	
	/**Evalua y aplica la clasificacion correspondiente */
	def String getClasificacionString() {
	 	var String clas
	 	switch clas {
	 		case esRampage : clas = "RAMPAGE"
	 		case esDominador : clas = "DOMINADOR"
	 		case esKillingSpread  : clas = "KILLING-SPREAD"
	 		case esManco : clas = "MANCO"
	 		default : clas = "NOOB"
	 	}
	 	clas
	 }
	 
	 
	/**Calcula el poder de ataque del personaje del jugador */
	def double poderDeAtaque(){
		return ((cantKills + assists % 2 - cantDeads) * cantDuelosIniciados)
	} 
	 
	def vecesQueUsoPosicionIdeal(){
		var cantPosicionIdeal = 0
		for(ubicacion: ubicacionesUsadas){
			if(ubicacion == mejorUbicacion)
				cantPosicionIdeal ++
		}
		return cantPosicionIdeal
	} 
	
	
	///DEBERIA IR EN OTRA CLASE
	def numeroRandom(){
		val Random rand = new Random(System.currentTimeMillis())
		return rand.nextInt(150)
} 
	
	def esRampage(){
		return cantDuelosGanados >= 5 && vecesQueUsoPosicionIdeal >=5 && numeroRandom >90
	}
	
	/**Determina si el personaje del jugador es Dominador */
	def esDominador(){
		return cantDuelosGanados >= 2 && vecesQueUsoPosicionIdeal >=2 && numeroRandom >70
	}
	
	def esKillingSpread(){
		return numeroRandom >50
	}
	
	def esManco(){
		return numeroRandom >30
	}
}
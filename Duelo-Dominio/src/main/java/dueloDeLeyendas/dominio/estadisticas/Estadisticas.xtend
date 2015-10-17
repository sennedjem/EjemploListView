package dueloDeLeyendas.dominio.estadisticas


import org.eclipse.xtend.lib.annotations.Accessors

import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import org.uqbar.commons.utils.Observable
import java.util.List
import java.util.ArrayList
import java.util.Random
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo

/**Modela las estadísticas correspondientes a un jugador y un personaje */
 
@Observable
@Accessors class Estadisticas {
	
	val Personaje personaje
	val Jugador jugador
	var String mejorUbicacion
	var double clasificacion
	var SistemaDeDuelos sistema
	
	/**Crea una instancia de la clase Estadisticas con los personajes y jugadores pasados
	 * por parametro y todos los demas valores inicializados en 0, o lista vacia. */
	new (Personaje pers, Jugador jug,SistemaDeDuelos sis){
		jugador = jug
		personaje = pers
		mejorUbicacion = personaje.posicionIdeal
		clasificacion = 0
		sistema = sis
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
		return ((getCantKills + getAssists % 2  - getCantDeads) * getCantDuelosIniciados)
	}
	
	def Integer getCantDuelosIniciados() {
		0 + sistema.resultadosDuelo.filter[esIniciador(this.jugador)].size
	}
	
	
	def  Integer getCantDeads() {
		0 +sistema.resultadosDuelo.filter[ esRetado(this.jugador)&& (poderAtaqueIniciador > poderAtaqueRetado)].size
	}

	
	def Integer getAssists() {
		0 + sistema.resultadosDuelo.filter[participo(this.jugador)&&esEmpate].size
	}

	
	def Integer getCantKills() {
		0 +sistema.resultadosDuelo.filter[esRetado(this.jugador) && ganoRetado].size
	}
	
	def Integer getCantGanadosEIniciados() {
		0 +sistema.resultadosDuelo.filter[esIniciador(this.jugador) && ganoIniciador].size
	}
	
	def Integer getGetCantDuelosGanados() {
		0 +this.getCantGanadosEIniciados + this.getCantKills 	
	}
	
	def Personaje getPersonaje() {
		this.personaje
	}
	 
	def vecesQueUsoPosicionIdeal(){
		var cantPosicionIdeal = 0
		for(ubicacion: getUbicacionesUsadas){
			if(ubicacion == mejorUbicacion)
				cantPosicionIdeal ++
		}
		return cantPosicionIdeal
	}
	
	def getUbicacionesUsadas() {
	var posicionesQueJugoComoIniciador = new ArrayList<String>
	for(ResultadoDuelo res : sistema.resultadosDuelo)
	if(res.esIniciador(this.jugador))
	posicionesQueJugoComoIniciador.add(res.posicion)
	posicionesQueJugoComoIniciador
	}
	
	
	///DEBERIA IR EN OTRA CLASE
	def numeroRandom(){
		val Random rand = new Random(System.currentTimeMillis())
		return rand.nextInt(150)
} 
	
	def esRampage(){
		return getCantDuelosGanados >= 5 && vecesQueUsoPosicionIdeal >=5 && numeroRandom >90
	}
	
	/**Determina si el personaje del jugador es Dominador */
	def esDominador(){
		return getCantDuelosGanados >= 2 && vecesQueUsoPosicionIdeal >=2 && numeroRandom >70
	}
	
	def esKillingSpread(){
		return numeroRandom >50
	}
	
	def esManco(){
		return numeroRandom >30
	}
	

	
}
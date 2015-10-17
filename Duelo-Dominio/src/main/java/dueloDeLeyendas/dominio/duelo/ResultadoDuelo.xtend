package dueloDeLeyendas.dominio.duelo
//
import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import org.uqbar.commons.utils.Observable

@Observable
@Accessors  class ResultadoDuelo {
	var Jugador iniciador
	var Jugador retado
	var Personaje iniciadorPersonaje
	var Personaje retadoPersonaje 
	var String posicion
	var double poderAtaqueIniciador
	var double poderAtaqueRetado
	
	
	
	new(Jugador elQueInicio,Jugador jRetado, Personaje personaje, Personaje personaje2, String string, double d, double e) {
		iniciador = elQueInicio
		retado = jRetado
		iniciadorPersonaje = personaje
		retadoPersonaje = personaje2
		posicion = string
		poderAtaqueIniciador = d
		poderAtaqueRetado = e 
	}
	def esEmpate() {
		poderAtaqueIniciador == poderAtaqueRetado
	}
	
	def participo(Jugador jugador) {
		esIniciador(jugador)|| esRetado(jugador)
	}
	def esIniciador(Jugador jugador) {
		iniciador.nombreJugador.equals(jugador.nombreJugador)
	}
	
	def esRetado(Jugador jugador) {
		retado.nombreJugador.equals(jugador.nombreJugador)
	}
	
	def ganoIniciador() {
		poderAtaqueIniciador > poderAtaqueRetado
	}
	
	def ganoRetado() {
		poderAtaqueIniciador < poderAtaqueRetado
	}



	
	
	
}
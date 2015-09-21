package dueloDeLeyendas.dominio.duelo
//
import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje

@Accessors class ResultadoDuelo {
	var Jugador iniciador
	var Jugador retado
	var Jugador ganador
	var Jugador perdedor
	var Personaje ganadorPersonaje
	var Personaje perdedorPersonaje
	var String posicion
	var double poderAtaqueGanador
	var double poderAtaquePerdedor
	
	
	
	new(Jugador elQueInicio,Jugador quienRetaron,Jugador jugador, Jugador jugador2, Personaje personaje, Personaje personaje2, String string, double d, double e) {
		iniciador = elQueInicio
		retado = quienRetaron
		ganador = jugador
		perdedor = jugador2
		ganadorPersonaje = personaje
		perdedorPersonaje = personaje2
		posicion = string
		poderAtaqueGanador = d
		poderAtaquePerdedor = e
	}
	
	
}
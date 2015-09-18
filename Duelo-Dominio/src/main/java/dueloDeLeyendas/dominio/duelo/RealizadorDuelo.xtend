package dueloDeLeyendas.dominio.duelo
//

import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

@Accessors class RealizadorDuelo {
	var String posicion
	var Jugador retador
	var Jugador rival
	var Personaje retadorPersonaje
	var Personaje rivalPersonaje

	def ResultadoDuelo realizarDuelo(String pos, Jugador ret, Jugador riv, Personaje retPer, Personaje rivPer) {
		var Estadisticas estadisticasDeRetadorConSuPj = retador.getEstadisticas(retadorPersonaje)
		var Estadisticas estadisticasDeRivalConSuPj = rival.getEstadisticas(rivalPersonaje)	
		var double poderAtaqueRetador = estadisticasDeRetadorConSuPj.poderDeAtaque
		var double poderAtaqueRival = estadisticasDeRivalConSuPj.poderDeAtaque
		
		if (poderAtaqueRetador > poderAtaqueRival) {
			retador.ganeSumarAEstadisticas(retador,retadorPersonaje, posicion,poderAtaqueRetador)
			rival.perdiSumarAEstadisticas(retador,rivalPersonaje, posicion, poderAtaqueRetador)
			return new ResultadoDuelo(retador, rival, retadorPersonaje, rivalPersonaje, posicion, poderAtaqueRetador, poderAtaqueRival)
		} else 
			if(poderAtaqueRival > poderAtaqueRetador){
				rival.ganeSumarAEstadisticas(retador,rivalPersonaje, posicion, poderAtaqueRetador)
				retador.perdiSumarAEstadisticas(retador, retadorPersonaje, posicion, poderAtaqueRetador)
				return new ResultadoDuelo(rival, retador, rivalPersonaje, retadorPersonaje, posicion, poderAtaqueRival, poderAtaqueRetador)
				}
				else 
					if(poderAtaqueRetador == poderAtaqueRival){
						retador.empateSumarAEstadisticas(retador, retadorPersonaje, posicion, poderAtaqueRetador)
						rival.empateSumarAEstadisticas(retador,rivalPersonaje, posicion, poderAtaqueRetador)
						return	new ResultadoDuelo(retador, rival, retadorPersonaje, rivalPersonaje, posicion, poderAtaqueRetador, poderAtaqueRival)
				}
			}

		}
		
package dueloDeLeyendas.dominio.duelo


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

	def void realizarDuelo(String pos, Jugador ret, Jugador riv, Personaje retPer, Personaje rivPer) {
		var Estadisticas estadisticasDeRetadorConSuPj = retador.getEstadisticas(retadorPersonaje)
		var Estadisticas estadisticasDeRivalConSuPj = rival.getEstadisticas(rivalPersonaje)
		
		var double poderAtaqueRetador = estadisticasDeRetadorConSuPj.poderDeAtaque
		/*retadorPersonaje.getClasificacionNumerica +
			(estadisticasDeRetadorConSuPj.getCantKills + (estadisticasDeRetadorConSuPj.getAssists/ 2) -
				estadisticasDeRetadorConSuPj.getCantDeads) + estadisticasDeRetadorConSuPj.getCantDuelosIniciados*/	
		
		var double poderAtaqueRival = estadisticasDeRivalConSuPj.poderDeAtaque
		/*rivalPersonaje.getClasificacionNumerica +
			(estadisticasDeRivalConSuPj.getCantKills + (estadisticasDeRetadorConSuPj.getAssists / 2) -
				estadisticasDeRivalConSuPj.getCantDeads) + estadisticasDeRivalConSuPj.getCantDuelosIniciados*/
		
		if (poderAtaqueRetador > poderAtaqueRival) {
			retador.ganeSumarAEstadisticas(retador,retadorPersonaje, posicion,poderAtaqueRetador)
			rival.perdiSumarAEstadisticas(retador,rivalPersonaje, posicion, poderAtaqueRetador)
		} else {
			rival.ganeSumarAEstadisticas(retador,rivalPersonaje, posicion, poderAtaqueRetador)
			retador.perdiSumarAEstadisticas(retador, retadorPersonaje, posicion, poderAtaqueRetador)
				}
				if(poderAtaqueRetador == poderAtaqueRival){
					retador.empateSumarAEstadisticas(retador, retadorPersonaje, posicion, poderAtaqueRetador)
					rival.empateSumarAEstadisticas(retador,rivalPersonaje, posicion, poderAtaqueRetador)
				}
			}

		}
		
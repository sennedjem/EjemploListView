package dueloDeLeyendas.dominio.duelo
//

import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

/**Modela al realizador de duelo */
@Accessors class RealizadorDuelo {

	/**Recibe a los jugadores, personajes y la posicion para el duelo. Despues de encontrar al ganador
	 * actualiza las estadisticas de cada uno dependiendo el resultado
	 */
	def ResultadoDuelo realizarDuelo(String pos, Jugador ret, Jugador riv, Personaje retPer, Personaje rivPer) {
		var Estadisticas estadisticasDeRetadorConSuPj = ret.getEstadisticas(retPer)
		var Estadisticas estadisticasDeRivalConSuPj = riv.getEstadisticas(rivPer)	
		var double poderAtaqueRetador = estadisticasDeRetadorConSuPj.poderDeAtaque
		var double poderAtaqueRival = estadisticasDeRivalConSuPj.poderDeAtaque
		
		if (poderAtaqueRetador > poderAtaqueRival) {
			ret.ganeSumarAEstadisticas(ret,retPer, pos,poderAtaqueRetador)
			riv.perdiSumarAEstadisticas(ret,rivPer, pos, poderAtaqueRetador)
			return new ResultadoDuelo(ret, riv,ret, riv, retPer, rivPer, pos, poderAtaqueRetador, poderAtaqueRival)
		} else 
			if(poderAtaqueRival > poderAtaqueRetador){
				riv.ganeSumarAEstadisticas(ret,rivPer, pos, poderAtaqueRetador)
				ret.perdiSumarAEstadisticas(ret, retPer, pos, poderAtaqueRetador)
				return new ResultadoDuelo(ret, riv,riv, ret, rivPer, retPer, pos, poderAtaqueRival, poderAtaqueRetador)
				}
				else 
					if(poderAtaqueRetador == poderAtaqueRival){
						ret.empateSumarAEstadisticas(ret, retPer, pos, poderAtaqueRetador)
						riv.empateSumarAEstadisticas(ret,rivPer, pos, poderAtaqueRetador)
						return	new ResultadoDuelo(ret, riv, ret, riv, retPer, rivPer, pos, poderAtaqueRetador, poderAtaqueRival)
				}
			}

		}
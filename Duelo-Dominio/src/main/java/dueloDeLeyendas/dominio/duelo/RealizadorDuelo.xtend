package dueloDeLeyendas.dominio.duelo
//

import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
 import java.util.Random;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import org.uqbar.commons.utils.Observable
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos

/**Calcula ganadores y perdedores a la hora de hacer un duelo */
@Observable
@Accessors class RealizadorDuelo{
	SistemaDeDuelos sis;
	Random rnd = new Random(System.currentTimeMillis())
	Integer numRandom = rnd.nextInt(2)
	/**Recibe a los jugadores, personajes y la posicion para el duelo. Despues de encontrar al ganador
	 * actualiza las estadisticas de cada uno dependiendo el resultado
	 */
	def ResultadoDuelo realizarDuelo(String pos, Jugador ret, Jugador riv, Personaje retPer, Personaje rivPer) {
		var estadisticasDeRetadorConSuPj = ret.getEstadisticas(retPer)
		var estadisticasDeRivalConSuPj = riv.getEstadisticas(rivPer)		
		var double poderAtaqueRetador = estadisticasDeRetadorConSuPj.poderDeAtaque * numRandom
		var double poderAtaqueRival = estadisticasDeRivalConSuPj.poderDeAtaque * numRandom
		
		return new ResultadoDuelo(ret, riv, retPer, rivPer, pos, poderAtaqueRetador, poderAtaqueRival)

		}			

}
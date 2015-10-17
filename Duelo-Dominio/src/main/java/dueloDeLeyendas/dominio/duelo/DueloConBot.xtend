package dueloDeLeyendas.dominio.duelo

import dueloDeLeyendas.dominio.duelo.ResultadoDuelo
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.personaje.Personaje
import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.estadisticas.Estadisticas
import java.util.Random

@Observable
@Accessors
class DueloConBot {
	SistemaDeDuelos sistema
	Random rnd = new Random(50)
	
	new(SistemaDeDuelos sist){
		sistema = sist
	}
	
	
	def ResultadoDuelo realizarDueloBot(String pos, Jugador ret, Personaje retPer, Personaje personajeBot){
		var Jugador bot = new Jugador("mrX",sistema)
		bot.agregarEstadistica(personajeBot)
		var Estadisticas estRetador = ret.getEstadisticas(retPer)
		
		val poderAtaqueRetador = estRetador.poderDeAtaque//*(rnd.nextInt)
		val poderAtaqueBot = 10 //* (rnd.nextInt)

			return new ResultadoDuelo(ret, bot, retPer, personajeBot, pos, poderAtaqueRetador, poderAtaqueBot)
	}
	

}
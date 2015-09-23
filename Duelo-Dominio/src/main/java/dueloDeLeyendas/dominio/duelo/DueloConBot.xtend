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
		bot.agregarPersonaje(personajeBot)
		var Estadisticas estRetador = ret.getEstadisticas(retPer)
		
		val poderAtaqueRetador = estRetador.poderDeAtaque//*(rnd.nextInt)
		val poderAtaqueBot = 10 //* (rnd.nextInt)
		
		val double dif = poderAtaqueRetador - poderAtaqueBot
		
		switch dif {
			case dif>0 : return ganoRetador(ret, retPer, pos, poderAtaqueRetador,bot, personajeBot, poderAtaqueBot)
			case dif<0 : return perdioRetador(ret, retPer, pos, poderAtaqueRetador,bot, personajeBot, poderAtaqueBot)
			case dif== 0: return empate(ret, retPer, pos, poderAtaqueRetador,bot, personajeBot, poderAtaqueBot)
		}
		if (poderAtaqueRetador<poderAtaqueBot)
			ret.perdiSumarAEstadisticas(ret,retPer,pos,poderAtaqueRetador)
			return new ResultadoDuelo(ret, bot,ret, bot, retPer, personajeBot, pos, poderAtaqueRetador, poderAtaqueBot)
	}
	
	def ganoRetador(Jugador ret, Personaje retPer, String pos, double poderAtaqueRetador, Jugador bot, Personaje personajeBot, double poderAtaqueBot){
		ret.ganeSumarAEstadisticas(ret,retPer, pos,poderAtaqueRetador)
		return new ResultadoDuelo(ret, bot,ret, bot, retPer, personajeBot, pos, poderAtaqueRetador, poderAtaqueBot)
	}
	
	def perdioRetador(Jugador ret, Personaje retPer, String pos, double poderAtaqueRetador, Jugador bot, Personaje personajeBot, double poderAtaqueBot){
		ret.perdiSumarAEstadisticas(ret,retPer,pos,poderAtaqueRetador)
		return new ResultadoDuelo(ret, bot,bot, ret, personajeBot, retPer, pos, poderAtaqueBot , poderAtaqueRetador)
	}
	
	def empate(Jugador ret, Personaje retPer, String pos, double poderAtaqueRetador, Jugador bot, Personaje personajeBot, double poderAtaqueBot){
		ret.empateSumarAEstadisticas(ret, retPer, pos, poderAtaqueRetador)
		return	new ResultadoDuelo(ret, bot, ret, bot, retPer, personajeBot, pos, poderAtaqueRetador, poderAtaqueBot)
	}
}
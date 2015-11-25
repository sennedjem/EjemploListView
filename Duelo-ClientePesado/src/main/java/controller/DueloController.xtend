package controller

import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import dueloDeLeyendas.dominio.applicationModel.RepoWeb
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo
import java.util.List
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

@Controller
class DueloController {

	extension JSONUtils = new JSONUtils

	def static void main(String[] args) {
		XTRest.start(DueloController, 9000)
	}
	
	@Get("/posiciones")
	def Result posiciones(){
		val posiciones = newArrayList
		posiciones =>[
			add("TOP")
			add("MID")
			add("BOT")
			add("JUNGLE")
		]
		response.contentType = ContentType.APPLICATION_JSON
		ok(posiciones.toJson)
	}
	
	@Get("/personajes")
	def Result personajes(){
		val pers = new RepoWeb(new Jugador("Marcos", new SistemaDeDuelos(new RealizadorDuelo))).personajes
		response.contentType = ContentType.APPLICATION_JSON
		ok(pers.toJson)
	}
	
	@Get("/resultadoDuelo/:peers/:pos")
	def Result resultadoDuelo(){
		val realizador= new RealizadorDuelo
		val sistema=new SistemaDeDuelos(realizador)
		val marcos = new Jugador("marcos", sistema) 
//		val resultado= sistema.iniciarDuelo(marcos, getPersonajePorNombre(peers) , pos)
		response.contentType = ContentType.APPLICATION_JSON
		ok("".toJson)
	}
	

	
}

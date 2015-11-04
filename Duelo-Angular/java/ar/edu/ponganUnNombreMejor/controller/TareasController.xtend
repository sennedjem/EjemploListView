package ar.edu.tareas.controller

import ar.edu.tareas.domain.Tarea
import ar.edu.tareas.repos.RepoTareas
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import dueloDeLeyendas.dominio.applicationModel.RepoWeb

@Controller
class TareasController {

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
		val pers = new RepoWeb().personajes
		response.contentType = ContentType.APPLICATION_JSON
		ok(pers.toJson)
	}
	
	
	@Get("/tareas")
	def Result tareas() {
		val tareas = RepoTareas.instance.allInstances
		response.contentType = ContentType.APPLICATION_JSON
		ok(tareas.toJson)
	}
	
	

	@Put('/tareas/:id')
	def Result actualizar(@Body String body) {
		val actualizado = body.fromJson(Tarea)
		if (Integer.parseInt(id) != actualizado.id) {
			return badRequest('{ "error": "Id en URL distinto del body"}')
		}

		RepoTareas.instance.update(actualizado)
		ok('{ "status" : "OK" }');
	}

}

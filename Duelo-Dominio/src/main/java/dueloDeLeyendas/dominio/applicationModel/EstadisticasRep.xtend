package dueloDeLeyendas.dominio.applicationModel

import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.estadisticas.Estadisticas

@Accessors
class EstadisticasRep {
	var Integer jugadas
	var Integer ganadas
	var Integer kills
	var Integer deads
	var Integer assists 
	var String mejorUbicacion
	var String puntaje
	
	new(Estadisticas estadistica){
		jugadas=estadistica.cantDuelosIniciados
		ganadas=estadistica.cantGanadosEIniciados
		kills=estadistica.cantKills
		deads= estadistica.cantDeads
		assists=estadistica.assists
		mejorUbicacion=estadistica.mejorUbicacion
		puntaje=estadistica.clasificacion.toString
	}
}
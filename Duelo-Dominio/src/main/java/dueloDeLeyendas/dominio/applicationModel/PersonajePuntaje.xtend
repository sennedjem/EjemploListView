package dueloDeLeyendas.dominio.applicationModel

import dueloDeLeyendas.dominio.personaje.Personaje
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Observable
@Accessors

class PersonajePuntaje {
	Personaje pers 
	String clasificacion
	
	new (Personaje p, String c){
		pers = p
		clasificacion = c
	}
	
}
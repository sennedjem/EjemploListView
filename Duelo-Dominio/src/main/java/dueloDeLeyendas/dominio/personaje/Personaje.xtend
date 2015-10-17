package dueloDeLeyendas.dominio.personaje

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

/* Modela a los personajes y sus caracteristicas */
@Observable
@Accessors class Personaje {
	
	val String nombre 
	val List<String> especialidades
	val List<String> debilidades
	val String posicionIdeal
	var Integer clasificacion
	
	/*Crea una instancia de la clase con los atributos pasados por parametro */
	new (String name ,List<String> esp, List<String> deb, String posIdeal){
		nombre = name
		posicionIdeal = posIdeal
		debilidades = deb
		especialidades = esp
		clasificacion = 0
	}
	
	/* Agrega una nueva especialidad al personaje */
	def agregarEspecialidad (String especialidad) {
		especialidades.add(especialidad)
	}
	
	/*Agrega una nueva debilidad al personaje */
	 def agregarDebilidad (String debilidad){
	 	debilidades.add(debilidad)
	 }
	
	/*Devuelve la clasificacion correspondiente segun su valor */
	 def String getClasificacion() {
	 	var String clas
	 	val Integer clasificacion = this.clasificacion
	 	switch clas {
	 		case clasificacion >= 100 : clas = "RAMPAGE"
	 		case clasificacion >=75 && clasificacion < 100 : clas = "DOMINADOR"
	 		case clasificacion >=60  && clasificacion <75  : clas = "KILLING-SPREAD"
	 		case clasificacion >=15 && clasificacion <60   : clas = "MANCO"
	 		case clasificacion < 15  : clas = "NOOB"
	 	}
	 	clas
	 }
	
	/*Devuelve la clasificación del personaje en números */
	def getClasificacionNumerica() {
		clasificacion
	}
	
	
}
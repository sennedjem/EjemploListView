package dueloDeLeyendas.dominio.personaje

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

/*
 * Esta clase modela a los personajes y sus caracteristicas
 */
@Accessors class Personaje {
	
	val String nombre
	val List<String> especialidades
	val List<String> debilidades
	val String posicionIdeal
	var Integer clasificacion
	
	/*
	 * Este constructor crea una instancia de la clase con los atributos pasados por parametro
	 */
	new (String name ,List<String> esp, List<String> deb, String posIdeal){
		nombre = name
		posicionIdeal = posIdeal
		debilidades = deb
		especialidades = esp
		clasificacion = 0
	}
	
	/*
	 * Este método le agrega una nueva especialidad al personaje
	 */
	def agregarEspecialidad (String especialidad) {
		especialidades.add(especialidad)
	}
	
	/*
	 * Este metodo le agrega una nueva debilidad al personaje
	 */
	 def agregarDebilidad (String debilidad){
	 	debilidades.add(debilidad)
	 }
	
	/*
	 * Este metodo devuelve la clasificacion correspondiente segun su valor
	 */
	 def String getClasificacion() {
	 	//Eh, una cosita, en lugar de ser calificacion ==X no deberia der >=??
	 	var String clas
	 	val Integer clasificacion = this.clasificacion
	 	switch clas {
	 		case clasificacion==5 : clas = "NOOB"
	 		case clasificacion==15 : clas = "MANCO"
	 		case clasificacion==30 : clas = "SHAME-ON-YOU"
	 		case clasificacion==60 : clas = "KILLING-SPREAD"
	 		case clasificacion==75 : clas = "DOMINADOR"
	 		case clasificacion==100 : clas = "RAMPAGE"
	 	}
	 	clas
	 }
	
	/*
	 * Este método devuelve la clasificación del personaje en números
	 */
	def getClasificacionNumerica() {
		this.clasificacion
	}
	
}
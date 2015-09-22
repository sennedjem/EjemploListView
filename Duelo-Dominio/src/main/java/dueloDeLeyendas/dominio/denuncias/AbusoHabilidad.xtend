package dueloDeLeyendas.dominio.denuncias

class AbusoHabilidad extends MotivoDenuncia {
/**Suma 5 puntos de denuncia por abuso de habilidad */
	new() {
		super(5)
	}

	override def toString(){
		return "Abuso de habilidad"
	}
}

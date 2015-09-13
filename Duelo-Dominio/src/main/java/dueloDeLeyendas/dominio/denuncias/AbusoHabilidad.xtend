package dueloDeLeyendas.dominio.denuncias

class AbusoHabilidad extends MotivoDenuncia {
	new() {
		super(5)
	}

	override def toString(){
		return "Abuso de habilidad"
	}
}

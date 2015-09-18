package dueloDeLeyendas.dominio.denuncias

class ComunicacionAbusiva extends MotivoDenuncia {
/*Suma 7 puntos de denuncia por comunicacion ofensiva */
	new() {
		super(7)
	}
	
	def override toString(){
		"Comunicacion abusiva"
	}

}

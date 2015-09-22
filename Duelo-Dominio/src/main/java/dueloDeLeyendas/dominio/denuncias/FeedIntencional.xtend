package dueloDeLeyendas.dominio.denuncias

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors class FeedIntencional extends MotivoDenuncia {
/**Suma 10 puntos de denuncia por feed intencional */	
	new() {
		super(10)
	}
	
	def override toString(){
		"Feed intencional"
	}

}

package dueloDeLeyendas.dominio.denuncias

import dueloDeLeyendas.dominio.jugador.Jugador

class AbusoDelSistemaDeDenuncias extends MotivoDenuncia {
/*Crea una denuncia al denunciante si no se puede validar la misma */	
	new() {
		super(25)
	}
/*Retorna el jugador denunciado, en este caso es el denunciante */
	override Jugador aQuienCastigo(Jugador denunciado, Jugador denunciante) {
		return denunciante
	}

}

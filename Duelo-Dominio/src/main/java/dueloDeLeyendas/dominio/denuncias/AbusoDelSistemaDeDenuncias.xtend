package dueloDeLeyendas.dominio.denuncias

import dueloDeLeyendas.dominio.jugador.Jugador

class AbusoDelSistemaDeDenuncias extends MotivoDenuncia {
	
	new() {
		super(25)
	}

	override Jugador aQuienCastigo(Jugador denunciado, Jugador denunciante) {
		return denunciante
	}

}

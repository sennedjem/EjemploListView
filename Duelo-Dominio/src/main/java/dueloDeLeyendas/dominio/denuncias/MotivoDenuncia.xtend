package dueloDeLeyendas.dominio.denuncias


import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador

@Accessors abstract class MotivoDenuncia {
	int peso

	new(Integer pesoDenuncia) {
		peso = pesoDenuncia
	}
/*Retorna el jugador al cual se le debe aplicar la denuncia */
	def Jugador aQuienCastigo(Jugador denunciado, Jugador denunciante) {
		return denunciado
	}

}

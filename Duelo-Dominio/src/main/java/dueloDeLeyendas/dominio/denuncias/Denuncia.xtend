package dueloDeLeyendas.dominio.denuncias


import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador

@Accessors class Denuncia {
	String justificacion
	Jugador denunciante
	Jugador denunciado
	MotivoDenuncia motivo

	new(String justificacion, Jugador denunciante, Jugador denunciado, MotivoDenuncia motivo) {
		this.justificacion = justificacion
		this.denunciante = denunciante
		this.denunciado = denunciado
		if (this.esValida()) {
			this.motivo = motivo
		} else {
			this.motivo = new AbusoDelSistemaDeDenuncias()
		}
	}

	def boolean esValida() {
		return this.tieneMasDeTresPalabras(justificacion)
	}

	def private boolean tieneMasDeTresPalabras(String justificacion2) {
		var int aDev = 0

		for (var int i = 0; i < justificacion2.length(); i++) {
			if (justificacion2.charAt(i) === Character.valueOf(' ').charValue) {
				aDev = aDev + 1
			}

		}
		return aDev > 3
	}

	def void realizarPenalizacion() {
		var Jugador jug = motivo.aQuienCastigo(this.getDenunciado(), this.getDenunciante())
		this.castigarJugador(jug)
	}

	def void castigarJugador(Jugador jug) {
		jug.sumaleATuPesoDeDenuncia(motivo.peso)
	}

}

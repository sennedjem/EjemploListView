package dueloDeLeyendas.dominio.denuncias


import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador
import java.util.List
import java.util.ArrayList

@Accessors class Denuncia {
	String justificacion
	Jugador denunciante
	Jugador denunciado
	MotivoDenuncia motivo

	new(Jugador denunciante, Jugador denunciado) {
		this.denunciante = denunciante
		this.denunciado = denunciado
	}
	
	def List<String> tiposDeDenuncia() {
		var List<String> lista = new ArrayList
		lista.add("Abuso de habilidad")
		lista.add("Comunicacion abusiva")
		lista.add("Feed intencional")
		lista
	}
	
	def boolean esValida() {
		return this.tieneMasDeTresPalabras(justificacion)&& this.justificacion.length()>20
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
	
		def getTiposDeDenuncia() {
		#[new AbusoHabilidad, new ComunicacionAbusiva, new FeedIntencional]
	}

}

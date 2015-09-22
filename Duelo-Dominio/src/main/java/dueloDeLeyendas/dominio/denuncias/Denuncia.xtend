package dueloDeLeyendas.dominio.denuncias


import org.eclipse.xtend.lib.annotations.Accessors
import dueloDeLeyendas.dominio.jugador.Jugador
import java.util.List
import java.util.ArrayList

/**Modela a las denuncias con sus diferentes tipos */
@Accessors class Denuncia {
	String justificacion
	Jugador denunciante
	Jugador denunciado
	MotivoDenuncia motivo

/**Crea una nueva instancia de la denuncia con los dos jugadores necesarios */
	new(Jugador denunciante, Jugador denunciado) {
		this.denunciante = denunciante
		this.denunciado = denunciado
	}
	
	
	/**Agrega los tipos de denuncia existentes en el sistema */
	def List<String> tiposDeDenuncia() {
		var List<String> lista = new ArrayList
		lista.add("Abuso de habilidad")
		lista.add("Comunicacion abusiva")
		lista.add("Feed intencional")
		lista
	}
	
	/**Verifica las condiciones para validar la denuncia, estas son: tener mas de tres palabras o una longitud
	 * de mas de 20 caracteres*/
	def boolean esValida() {
		return this.tieneMasDeTresPalabras(justificacion)&& this.justificacion.length()>20
	}

	/**Verifica que la denuncia tenga mas de tres palabras */
	def private boolean tieneMasDeTresPalabras(String justificacion2) {
		var int aDev = 0

		for (var int i = 0; i < justificacion2.length(); i++) {
			if (justificacion2.charAt(i) === Character.valueOf(' ').charValue) {
				aDev = aDev + 1
			}

		}
		return aDev > 3
	}

	/**Aplica la penalizacion correspondiente */
	def void realizarPenalizacion() {
		var Jugador jug = motivo.aQuienCastigo(this.getDenunciado(), this.getDenunciante())
		this.castigarJugador(jug)
	}

	/**Suma el peso correspondiente dependiendo de la sanción aplicada */
	def void castigarJugador(Jugador jug) {
		jug.sumaleATuPesoDeDenuncia(motivo.peso)
	}
	
	/**Retorna la lista con los tipos de denuncia que puede realizar un jugador */
		def getTiposDeDenuncia() {
		#[new AbusoHabilidad, new ComunicacionAbusiva, new FeedIntencional]
	}

}

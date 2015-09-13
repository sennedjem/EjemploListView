package runnable

import org.uqbar.arena.Application
import dueloDeLeyendas.dominio.denuncias.Denuncia
import dueloDeLeyendas.dominio.jugador.Jugador
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import dueloDeLeyendas.dominio.denuncias.AbusoHabilidad
import view.CrearDenunciaWindow
import dueloDeLeyendas.dominio.realizarDuelo.RealizadorDuelo
import view.DenunciaInvalidaWindow
import view.DenunciaValidaWindow

class DenunciasApplication extends Application {
	
	override createMainWindow() {
		var Jugador denunciante = new Jugador("CapitanZanahoria", new SistemaDeDuelos(new RealizadorDuelo))
		var Jugador denunciado = new Jugador("Ammumu", new SistemaDeDuelos(new RealizadorDuelo))
		var Denuncia den = new Denuncia(denunciante,denunciado) 
		new DenunciaValidaWindow(this, den)
	}
	
	def static main(String[] args) {
		new DenunciasApplication().start
	}
}
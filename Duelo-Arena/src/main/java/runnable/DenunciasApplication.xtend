package runnable

import org.uqbar.arena.Application
import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel
import view.DueloDeLeyendasWindow

class DenunciasApplication extends Application {
	
	override createMainWindow() {
		new DueloDeLeyendasWindow(this, new DueloDeLeyendasModel)
	}
	
	def static main(String[] args) {
		new DenunciasApplication().start
	}
}
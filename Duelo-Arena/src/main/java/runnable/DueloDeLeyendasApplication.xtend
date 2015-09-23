package runnable

import org.uqbar.arena.Application
import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel
import view.DueloDeLeyendasWindow

class DueloDeLeyendasApplication extends Application {
	
	override createMainWindow() {
		new DueloDeLeyendasWindow(this, new DueloDeLeyendasModel)
	}
	
	def static main(String[] args) {
		new DueloDeLeyendasApplication().start
	}
}
package view

import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.Dialog
import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel
import dueloDeLeyendas.dominio.duelo.RealizadorDuelo

/**Modela la ventana que se muestra cuando no se encuentra un rival para un jugador que quiere realizar un duelo */
class NoHayRivalWindow extends Dialog<DueloDeLeyendasModel>{
	
	new(SimpleWindow parent, DueloDeLeyendasModel model) {
		super(parent, model)		
	}
	
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel)=>[
			caption="Retar a Mr.X"
			onClick [ | this.generarBot]
		]
		
		new Button(actionsPanel)=>[
			caption="Buscar un nuevo duelo"
			onClick [ | this.close ]			
		]
	}
	
	/**Genera un bot para pelear contra el retador, se realiza el duelo y se abre la ventana con el resultado del mismo */
	def generarBot() {
		val mrX = modelObject.sistema.generarJugadorMrX(modelObject.jugador, modelObject.personajeSeleccionado.pers)
		var dueloBot = new RealizadorDuelo
		val resultadoDuelo = dueloBot.realizarDuelo(modelObject.posicion,modelObject.jugador,mrX,modelObject.personajeSeleccionado.pers,modelObject.sistema.buscarPersonajeParaDuelo(modelObject.jugador, modelObject.personajeSeleccionado.pers)) 
		openDialog(new ResultadoDueloWindow(this, resultadoDuelo))
		this.close
	}
	
	
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel).text ="¡NO HAY NADIE CON MAS PODER QUE VOS!
Puedes intensificar tu poder batiendote a duelo con un bot o esperar a un rival digno de tu poder"
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}	
		
}
	
	
	

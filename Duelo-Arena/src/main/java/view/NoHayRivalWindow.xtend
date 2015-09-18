package view

import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.Dialog
import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel
import dueloDeLeyendas.dominio.realizarDuelo.RealizadorDuelo

class NoHayRivalWindow extends SimpleWindow<DueloDeLeyendasModel>{
	
	new(WindowOwner parent, DueloDeLeyendasModel model) {
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
	
	def generarBot() {
		val mrX = modelObject.sistema.generarJugadorMrX(modelObject.jugador, modelObject.personajeSeleccionado.pers)
		var dueloBot = new RealizadorDuelo=>[
			posicion = modelObject.posicion
			retador = modelObject.jugador
			rival = mrX
			retadorPersonaje = modelObject.personajeSeleccionado.pers
			rivalPersonaje = modelObject.sistema.buscarPersonajeParaDuelo(modelObject.jugador, modelObject.personajeSeleccionado.pers)
		]
		modelObject.realizador= dueloBot
		//esperar Resultado de duelo window
		openDialog(new ResultadoDueloWindow(this, modelObject))
	}
	
	
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel).text ="¡NO HAY NADIE CON MAS PODER QUE VOS!
Puedes intensificar tu poder batiendote a duelo con un bot o esperar a un rival digno de tu poder"
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}	
		
}
	
	
	

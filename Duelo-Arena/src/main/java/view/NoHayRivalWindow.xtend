package view

import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label

class NoHayRivalWindow extends SimpleWindow<SistemaDeDuelos>{
	
	new(WindowOwner parent, SistemaDeDuelos model) {
		super(parent, model)
		taskDescription = "¡No tienes rival"
		//foregound = color.WHITE
		//background = color.RED
		
	}
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel)=>[
			caption="Retar a Mr.X"
			onClick [ | this.generarBot]
		]
		
		new Button(actionsPanel)=>[
			caption="Buscar un nuevo duelo"
			onClick [ | this.nuevoDuelo ]			
		]
	}
	
	def generarBot() {
		//Crear jugador mrX
	}
	
	def getNuevoDuelo() {
		//Vuelve a la pantalla del sistema
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel).text ="¡NO HAY NADIE CON MAS PODER QUE VOS!
Puedes intensificar tu poder batiendote a duelo con un bot o esperar a un rival digno de tu poder"
	}
		
	}
	
	
	

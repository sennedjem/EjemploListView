package view

import dueloDeLeyendas.dominio.denuncias.Denuncia
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.widgets.Button

class DenunciaValidaWindow extends SimpleWindow<Denuncia>{
	
	new(WindowOwner parent, Denuncia model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel) =>[
			caption="Aceptar"
			onClick [ | this.close]
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel)=>[
			text = "Hemos sancionado a " + modelObject.denunciado.nombreJugador
			foreground = Color.WHITE
			background = Color.BLACK
		]
		
		new Label(mainPanel).text = "En Duelo de Leyendas somos partidarios del fair play.
									Gracias por ayudarnos a mantenernos así!!!"
	}
	
}
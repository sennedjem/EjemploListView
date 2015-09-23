package view

import dueloDeLeyendas.dominio.denuncias.Denuncia
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import dueloDeLeyendas.dominio.denuncias.AbusoDelSistemaDeDenuncias
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.windows.Dialog

/**Modela la ventana de una denuncia invalida */
class DenunciaInvalidaWindow extends Dialog<Denuncia> {
	
	new(WindowOwner parent, Denuncia model) {
		super(parent, model)
		title = "Su Denuncia Ha Sido Invalida"
	}
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel) =>[
			caption="Aceptar"
			onClick [ | this.close]
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel)=>[
			text = "Has sido sancionado!"
			foreground = Color.WHITE
			background = Color.BLACK
		]
		
		new Label(mainPanel).text = "Hemos detectado que tu denuncia no tiene fundamentos sólidos.
En duelo de leyendas desalentamos este tipo de actitudes y somos partidarios del fair play.
Con lo que has recibido una sanción por tu actitud antideportiva,esperamos que reflexiones sobre tu actitud."
	
}

}
package view

import dueloDeLeyendas.dominio.denuncias.Denuncia
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import dueloDeLeyendas.dominio.denuncias.AbusoDelSistemaDeDenuncias
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import java.awt.Color

class DenunciaInvalidaWindow extends SimpleWindow<Denuncia> {
	
	new(WindowOwner parent, Denuncia model) {
		super(parent, model)
		modelObject.motivo = new AbusoDelSistemaDeDenuncias
		modelObject.denunciante.sumaleATuPesoDeDenuncia(modelObject.motivo.peso)
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
									 En duelo de leyendas desalentamos este tipo de actitudes y somos
									 partidarios del fair play.
									 Con lo que has recibido una sanción por tu actitud antideportiva, 
									 esperamos que reflexiones sobre tu actitud."
	}
	
}
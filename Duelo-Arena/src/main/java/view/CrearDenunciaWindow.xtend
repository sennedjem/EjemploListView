package view

import dueloDeLeyendas.dominio.denuncias.Denuncia
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.ColumnLayout
import java.awt.Color
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import dueloDeLeyendas.dominio.denuncias.AbusoDelSistemaDeDenuncias

class CrearDenunciaWindow extends SimpleWindow<Denuncia> {
	
	new(WindowOwner parent, Denuncia model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel)=>[
			caption="Denunciar"
			onClick [ | this.verificar]
		]
		
		new Button(actionsPanel)=>[
			caption="Cancelar"
			onClick [ | this.cerrar ]			
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel)=>[
			text = "Hacer denuncia"
			foreground = Color.WHITE
			background = Color.BLACK
		]
		
		new Label(mainPanel)=>[
			text = "Estas queriendo denunciar a " + modelObject.denunciado.nombreJugador
			foreground = Color.GREEN
			]
				
		val denunciasPanel = new Panel(mainPanel)
		denunciasPanel.layout = new ColumnLayout(2)
		
		new Label(denunciasPanel).setText("Motivo")
		new Selector(denunciasPanel)=>[
			allowNull=false
			bindItemsToProperty ("tiposDeDenuncia")
			bindValueToProperty ("motivo")			
		]
		
		new Label(denunciasPanel).setText("Detalles")
		new TextBox(denunciasPanel)=>[
			height = 100
			width = 100
			bindValueToProperty("justificacion")
		]
		
		
	}
	
	def verificar(){
		//if (modelObject.esValida)
			//new DenunciaValidaWindow(modelObject)
		  //else
		  	//new DenunciaInvalidaWindow(modelObject)
	}
	
	def cerrar(){
		modelObject.justificacion = null
		modelObject.motivo = null
		this.close
	}
}
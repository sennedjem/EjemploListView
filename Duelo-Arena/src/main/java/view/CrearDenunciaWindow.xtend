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
import org.uqbar.arena.windows.Dialog

/**Modela la ventana desde donde se realizan las denuncias */
class CrearDenunciaWindow extends Dialog<Denuncia> {
	
	new(WindowOwner parent, Denuncia model) {
		super(parent, model)
		title = "Realizar Denuncia"
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
			width = 250		
		]
		
		new Label(denunciasPanel).setText("Detalles")
		new TextBox(denunciasPanel)=>[
			bindValueToProperty("justificacion")
			width = 250
		]
		
		
	}
	
	/**Verifica la validez de la denuncia y abre la correspondiente ventana dependiendo del caso */
	def verificar(){
		if (modelObject.esValida)
			verDenunciaValidaWindow
		  else
		    verDenunciaInvalidaWindow
	     this.close
	}
	
	/**Abre una ventana indicando que se sanciono al jugador denunciado si se conprueba que la denuncia es valida */
	def verDenunciaValidaWindow(){
		this.openDialog(new DenunciaValidaWindow(this, modelObject))
	}
	
	/**Abre una ventana indicando que se sanciono al jugador denunciante porque los motivos de la denuncia no son validos */
	def verDenunciaInvalidaWindow(){
		this.openDialog(new DenunciaInvalidaWindow(this, modelObject))
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	
	/**Cierra la ventana */
	def cerrar(){
		modelObject.justificacion = null
		modelObject.motivo = null
		this.close
	}
}
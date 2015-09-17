package view

import org.uqbar.arena.windows.SimpleWindow
import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import java.awt.Color
import dueloDeLeyendas.dominio.applicationModel.PersonajePuntaje
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.TextBox
import org.apache.commons.lang.StringUtils

class DueloDeLeyendasWindow extends SimpleWindow <DueloDeLeyendasModel>{
	
	new(WindowOwner parent, DueloDeLeyendasModel model) {
		super(parent, model)
		taskDescription = "¡Bienvenido: " + modelObject.jugador.nombreJugador + "! Desde esta pantalla podras elegir un personaje para batirte a duelo con otro jugador.
¡Recuerda siempre revisar tus stats!"
	}
	
	override protected addActions(Panel actionsPanel) {
		//Implemento mi propio action panel
	}
	
	override protected createFormPanel(Panel mainPanel) {
		val tag = new Label(mainPanel)=>[
			text= "¡Selecciona tu personaje para el duelo!"
			foreground = Color.WHITE
			background = Color.BLACK
		]
		
		val sndMainPanel = new Panel(mainPanel).layout = new ColumnLayout(3)
		
		//Crear panel de tablas
		val tablas = new Panel(sndMainPanel).layout = new VerticalLayout
		val panelSelector = new Panel(tablas).layout = new ColumnLayout(2)
		new Label(panelSelector).text = "Personaje buscado"
		new TextBox(panelSelector) =>[
			withFilter [ event | StringUtils.isAlpha(event.potentialTextResult)]
			bindValueToProperty("buscado")
		]
		crearTablaPersonajes(tablas)

		
		//Crear panel personaje seleccionado
		val panelSelected = new Panel(sndMainPanel) =>[
			layout = new VerticalLayout()
			]
		
	
		crearPanelPersonajeSeleccionado(panelSelected)
	}
	
	def crearTablaPersonajes(Panel panel){
		val table = new Table<PersonajePuntaje> (panel, typeof(PersonajePuntaje))=>[
			bindItemsToProperty("personajePuntaje")
			bindValueToProperty("personajeFiltrado")
			height = 1000
			width = 10000
		]
		this.describeResultGrid(table)
	}
	
	def describeResultGrid (Table<PersonajePuntaje> table){
		new Column<PersonajePuntaje>(table)=>[
			title = "Personaje"
			fixedSize = 100
			bindContentsToProperty("pers.nombre")
		]
		
		new Column<PersonajePuntaje>(table)=>[
			title = "Puntaje"
			fixedSize = 100
			bindContentsToProperty("clasificacion")
		]
	}
	
	def crearPanelPersonajeSeleccionado(Panel panel){
		new Label(panel) => [
			bindValueToProperty("personajeSeleccionado.pers.nombre")
			foreground = Color.BLUE
		]
	}
}
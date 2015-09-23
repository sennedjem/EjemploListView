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
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.windows.Dialog
import dueloDeLeyendas.dominio.sistemaDeDuelos.NoHayRival

/**Modela la ventana del sistema desde la cual un jugador puede elegir personajes y retar a duelo a otros jugadores */
class DueloDeLeyendasWindow extends SimpleWindow <DueloDeLeyendasModel>{
	
	new(WindowOwner parent, DueloDeLeyendasModel model) {
		super(parent, model)
		title = "Duelo De Leyendas"
		taskDescription = "¡Bienvenido: " + modelObject.jugador.nombreJugador + "! Desde esta pantalla podras elegir un personaje para batirte a duelo con otro jugador.
¡Recuerda siempre revisar tus stats!"
	}
	
	override protected addActions(Panel actionsPanel) {
		//Implemento mi propio action panel
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel)=>[
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
		
		//Crear panel stats
		val panelStats = new Panel(sndMainPanel)=>[
			layout = new VerticalLayout
		]
		
		crearPanelStats(panelStats)
		
		new Label(panelStats)=>[
			text = "Jugar"
			foreground = Color.BLUE
		]
		
		var botones = new Panel(panelStats).layout = new ColumnLayout(2)
		
		new Button(botones)=>[
			caption = "TOP"
			onClick[| iniciarDuelo("TOP")]
		]
		
		new Button(botones)=>[
			caption = "MID"
			onClick[| iniciarDuelo("MID")]
		]
		
		new Button(botones)=>[
			caption = "BOT"
			onClick[| iniciarDuelo("BOT")]
		]

		new Button(botones)=>[
			caption = "JUNGLE"
			onClick[| iniciarDuelo("JUNGLE")]
		]
	}
	
	def crearTablaPersonajes(Panel panel){
		val table = new Table<PersonajePuntaje> (panel, typeof(PersonajePuntaje))=>[
			bindItemsToProperty("personajesFiltrados")
			bindValueToProperty("personajeSeleccionado") 
			height = 150
		]
		describeResultGrid(table)
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
		
		new Label(panel) => [
			text = "Especialidades:"
			foreground = Color.GREEN
		]

		new Table<String> (panel, typeof (String))=>[
			bindItemsToProperty("personajeSeleccionado.pers.especialidades")
		]
		
		new Label(panel) => [
			text = "Debilidades:"
			foreground = Color.GREEN
		]
		
		new Table<String> (panel, typeof (String)) => [
			bindItemsToProperty("personajeSeleccionado.pers.debilidades")
		]
		
		new Label(panel) => [
			text = "Mejor Posición:"
			foreground = Color.GREEN
		]
		
		new Label(panel) =>[
			bindValueToProperty("personajeSeleccionado.pers.posicionIdeal")
		]
	}
	
	def crearPanelStats(Panel panel) {
		new Label(panel)=>[
			text = "Stats"
			foreground = Color.BLUE
		]
		
		var Panel stats = new Panel(panel).layout = new ColumnLayout(2)
		
		//Pongo todas las stats del personaje
		new Label(stats).text="Jugadas"
		
		new Label(stats).bindValueToProperty("statsPersonajeSeleccionado.jugados")
		
		new Label(stats).text="Ganadas"
		
		new Label(stats).bindValueToProperty("statsPersonajeSeleccionado.cantDuelosGanados")
		
		new Label(stats).text="Kills"
		
		new Label(stats).bindValueToProperty("statsPersonajeSeleccionado.cantKills")
		
		new Label(stats).text="Deads"
		
		new Label(stats).bindValueToProperty("statsPersonajeSeleccionado.cantDeads")
		
		new Label(stats).text="Assists"
		
		new Label(stats).bindValueToProperty("statsPersonajeSeleccionado.assists")
		
		new Label(stats).text="Mejor ubicación"
		
		new Label(stats).bindValueToProperty("statsPersonajeSeleccionado.mejorUbicacion")
		
		new Label(stats).text="Puntaje"
		
		new Label(stats).bindValueToProperty("personajeSeleccionado.clasificacion")		
	
	}
	
	def iniciarDuelo(String pos){
		try {
			modelObject.setPosicion = pos
			openDialog(new ResultadoDueloWindow(this, modelObject.iniciarDuelo))
		} catch(NoHayRival e){
			this.openDialog(new NoHayRivalWindow(this, modelObject))
		}
		
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.open
	}

}
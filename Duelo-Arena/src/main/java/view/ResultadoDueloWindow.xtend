package view

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.ColumnLayout

class ResultadoDueloWindow extends Dialog <ResultadoDuelo>{//

	
	new(WindowOwner owner, ResultadoDuelo resultado) {
		super(owner, resultado)
	}
	
	override protected addActions(Panel actionsPanel) {
		//Implemento mi propio action panel
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel)=>[
			//text = modelObject.ganador.nombreJugador + "vs" + modelObject.perdedor.nombreJugador
			text = "vs" 
			foreground = Color.WHITE
			background = Color.BLACK
			]
	
		new Label(mainPanel)=>[
			//text = "Ganaste contra" //modelObject.perdedor.nombreJugador
			text = "Ganaste contra" 
			foreground = Color.GREEN
			background = Color.YELLOW
			]

		val sndMainPanel = new Panel(mainPanel).layout = new HorizontalLayout()
		
		
	
		var panelInfo = new Panel(mainPanel)
		panelInfo.setLayout(new HorizontalLayout)
	
	if(modelObject.poderAtaqueGanador == modelObject.poderAtaquePerdedor){
	new Label(panelInfo)=>[
			text = "Ganador: " // + modelObject.ganador.nombreJugador + "!!" +  "- " + modelObject.poderAtaqueGanador + "puntos contra " + modelObject.poderAtaquePerdedor 
			foreground = Color.BLUE
			background = Color.YELLOW
			]
		}
		else 	{
			new Label(panelInfo)=>[
			text = "Empate " // + modelObject.ganador.nombreJugador + ""  + modelObject.poderAtaqueGanador + "puntos contra " + modelObject.perdedor.nombreJugador + modelObject.poderAtaquePerdedor 
			foreground = Color.BLUE
			background = Color.YELLOW
			]
			}
}

	def void crearStatsPorJugador(Panel panel){
			panel.setLayout(new ColumnLayout(3))
			new Label(panel)=>[
			text = ""//jugador.nombre
			foreground = Color.WHITE
			background = Color.BLUE
		]
			new Label(panel)=>[
			text = "Stats"// + personaje.nombre
			foreground = Color.BLUE
		]
		new Label(panel).text="Jugadas"
		
		new Label(panel).bindValueToProperty("estadisticasDeJugadorConPersonaje.cantJugados")
		
		new Label(panel).text="Ganadas"
		
		new Label(panel).bindValueToProperty("estadisticasDeJugadorConPersonaje.cantDuelosGanados")
		
		new Label(panel).text="Kills"
		
		new Label(panel).bindValueToProperty("estadisticasDeJugadorConPersonaje.cantKills")
		
		new Label(panel).text="Deads"
		
		new Label(panel).bindValueToProperty("estadisticasDeJugadorConPersonaje.cantDeads")
		
		new Label(panel).text="Assists"
		
		new Label(panel).bindValueToProperty("estadisticasDeJugadorConPersonaje.assists")
		
		new Label(panel).text="Mejor ubicación"
		
		new Label(panel).bindValueToProperty("estadisticasDeJugadorConPersonaje.mejorUbicacion")
		
		new Label(panel).text="Puntaje"
		
		new Label(panel).bindValueToProperty("estadisticasDeJugadorConPersonaje.clasificacion")
			
		}
}


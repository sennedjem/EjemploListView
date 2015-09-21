package view

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import dueloDeLeyendas.dominio.denuncias.Denuncia

class ResultadoDueloWindow extends Dialog <ResultadoDuelo>{//

	
	new(WindowOwner owner, ResultadoDuelo resultado) {
		super(owner, resultado)
	}
	
	override protected addActions(Panel actionsPanel) {
			new Button(actionsPanel)=>[
			caption="Aceptar resultado"
			onClick [ | this.close ]			
		]
		
			new Button(actionsPanel)=>[
			caption="Denunciar actitud antideportiva"
			onClick [ | this.crearDenuncia ]			
		]
	}
	
	def crearDenuncia() {
		var Denuncia  den = new Denuncia(modelObject.iniciador, modelObject.retado)
		this.openDialog(new CrearDenunciaWindow(this, den))
	}
	
		def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel)=>[
			text = modelObject.ganador.nombreJugador + "vs" + modelObject.perdedor.nombreJugador
			foreground = Color.WHITE
			background = Color.BLACK
			]
	
		new Label(mainPanel)=>[
			if(!(modelObject.poderAtaqueGanador == modelObject.poderAtaquePerdedor)){
			text = "Ganaste contra" + modelObject.perdedor.nombreJugador }
				else { 
					text = "empate contra" + modelObject.perdedor.nombreJugador
						}
			foreground = Color.GREEN
			background = Color.YELLOW
			]

		val sndMainPanel = new Panel(mainPanel).layout = new HorizontalLayout()
		
		
	
		var panelInfo = new Panel(mainPanel)
		panelInfo.setLayout(new HorizontalLayout)
	
	if(!(modelObject.poderAtaqueGanador == modelObject.poderAtaquePerdedor)){
	new Label(panelInfo)=>[
			text = "Ganador: " + modelObject.ganador.nombreJugador + "!!" +  "- " + modelObject.poderAtaqueGanador + "puntos contra " + modelObject.poderAtaquePerdedor 
			foreground = Color.BLUE
			background = Color.YELLOW
			]
		}
		else 	{
			new Label(panelInfo)=>[
			text = "Empate " + modelObject.ganador.nombreJugador + " "  + modelObject.poderAtaqueGanador + " puntos contra " + modelObject.poderAtaquePerdedor 
			foreground = Color.BLUE
			background = Color.YELLOW
			]
			}
}

	def void crearStatsPorJugador(Panel panel){
			panel.setLayout(new ColumnLayout(3))
			new Label(panel)=>[
			text = modelObject.ganador.nombreJugador
			foreground = Color.WHITE
			background = Color.BLUE
		]
			new Label(panel)=>[
			text = "Stats" + modelObject.ganadorPersonaje
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


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
import org.uqbar.arena.layout.VerticalLayout

/**Modela la ventana que muestra el resultado de un duelo */
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
	
	/**Abre la ventana de Denuncia si el jugador lo cree necesario */
	def crearDenuncia() {
		var Denuncia  den = new Denuncia(modelObject.iniciador, modelObject.retado)
		this.openDialog(new CrearDenunciaWindow(this, den))
		this.close
	}
	
		def openDialog(Dialog<?> dialog) {
		dialog.open
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel)=>[
			text = modelObject.ganador.nombreJugador + " vs " + modelObject.perdedor.nombreJugador
			foreground = Color.WHITE
			background = Color.BLACK
			]
	
		new Label(mainPanel)=>[
			if(!(modelObject.poderAtaqueGanador == modelObject.poderAtaquePerdedor)){
			text = "Ganador" + modelObject.ganador.nombreJugador }
				else { 
					text = "empate contra" + modelObject.perdedor.nombreJugador
						}
			foreground = Color.GREEN
			background = Color.YELLOW
			]

	crearStats(mainPanel)
	
	if(!(modelObject.poderAtaqueGanador == modelObject.poderAtaquePerdedor)){
	new Label(mainPanel)=>[
			text = "Ganador: " + modelObject.ganador.nombreJugador + "!!" +  "- " + modelObject.poderAtaqueGanador + "puntos contra " + modelObject.poderAtaquePerdedor 
			foreground = Color.BLUE
			background = Color.YELLOW
			]
		}
		else 	{
			new Label(mainPanel)=>[
			text = "Empate " + modelObject.ganador.nombreJugador + " "  + modelObject.poderAtaqueGanador + " puntos contra " + modelObject.poderAtaquePerdedor 
			foreground = Color.BLUE
			background = Color.YELLOW
			]
			}
}
def void crearStats(Panel panel){
		
		var Panel stats = new Panel(panel).layout = new HorizontalLayout()
		crearStatsPorGanador(stats)
		crearStatsPorGanador(stats)
	
		
		}

	def void crearStatsPorGanador(Panel panel){
	
	
		var Panel dataDelGanador = new Panel(panel).layout = new VerticalLayout()
		new Label(dataDelGanador)=>[
			text = modelObject.ganador.nombreJugador
			foreground = Color.WHITE
			background = Color.BLUE
		]

		new Label(dataDelGanador)=>[
			text = "Stats " + modelObject.ganadorPersonaje.nombre
			foreground = Color.BLUE
		]
		
		
		var Panel stats = new Panel(dataDelGanador).layout = new ColumnLayout(2)

	
		new Label(stats).text="Jugadas"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.jugados")
		
		new Label(stats).text="Ganadas"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.cantDuelosGanados")
		
		new Label(stats).text="Kills"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.cantKills")
		
		new Label(stats).text="Deads"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.cantDeads")
		
		new Label(stats).text="Assists"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.assists")
		
		new Label(stats).text="Mejor ubicación"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.mejorUbicacion")
		
		new Label(stats).text="Puntaje"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.clasificacion")
		
		}
		
		def void crearStatsPorPerdedor(Panel panel){
			
		new Label(panel)=>[
			text = modelObject.perdedor.nombreJugador
			foreground = Color.WHITE
			background = Color.BLUE
		]
		new Label(panel)=>[
			text = "Stats " + modelObject.perdedorPersonaje.nombre
			foreground = Color.BLUE
		]
		
		var Panel stats = new Panel(panel).layout = new ColumnLayout(2)
		
		new Label(stats).text="Jugadas"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.jugados")
		
		new Label(stats).text="Ganadas"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.cantDuelosGanados")
		
		new Label(stats).text="Kills"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.cantKills")
		
		new Label(stats).text="Deads"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.cantDeads")
		
		new Label(stats).text="Assists"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.assists")
		
		new Label(stats).text="Mejor ubicación"
		
		new Label(stats).bindValueToProperty("estGanadorConPersonaje.mejorUbicacion")
		
		new Label(stats).text="Puntaje"
		
		new Label(stats).bindValueToProperty("modelObject.estGanadorConPersonaje.clasificacion")
		
		}
}


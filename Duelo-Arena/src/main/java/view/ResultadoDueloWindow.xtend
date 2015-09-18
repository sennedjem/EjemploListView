package view

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import java.awt.Color
import org.uqbar.arena.layout.HorizontalLayout

class ResultadoDueloWindow extends Dialog <ResultadoDuelo>{//

	Label lala
	Label lala2
	
	new(WindowOwner owner, ResultadoDuelo resultado) {
		super(owner, resultado)
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

	
		var panelInfo = new Panel(mainPanel)
		panelInfo.setLayout(new HorizontalLayout)
	
	lala =	new Label(mainPanel)=>[
			text = "Ganador: " // + modelObject.ganador.nombreJugador + "!!" +  "- " + modelObject.poderAtaqueGanador + "puntos contra " + modelObject.poderAtaquePerdedor 
			foreground = Color.BLUE
			background = Color.YELLOW
			]


}

}


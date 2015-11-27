package view;

import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel;
import dueloDeLeyendas.dominio.applicationModel.PersonajePuntaje;
import dueloDeLeyendas.dominio.duelo.DueloConBot;
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import dueloDeLeyendas.dominio.sistemaDeDuelos.SistemaDeDuelos;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.lacar.ui.model.Action;
import view.ResultadoDueloWindow;

/**
 * Modela la ventana que se muestra cuando no se encuentra un rival para un jugador que quiere realizar un duelo
 */
@SuppressWarnings("all")
public class NoHayRivalWindow extends Dialog<DueloDeLeyendasModel> {
  public NoHayRivalWindow(final SimpleWindow<DueloDeLeyendasModel> parent, final DueloDeLeyendasModel model) {
    super(parent, model);
    this.setTitle("No Hay Rival En El Sistema");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Retar a Mr.X");
        final Action _function = new Action() {
          public void execute() {
            NoHayRivalWindow.this.generarBot();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Buscar un nuevo duelo");
        final Action _function = new Action() {
          public void execute() {
            NoHayRivalWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  /**
   * Genera un bot para pelear contra el retador, se realiza el duelo y se abre la ventana con el resultado del mismo
   */
  public void generarBot() {
    DueloDeLeyendasModel _modelObject = this.getModelObject();
    SistemaDeDuelos _sistema = _modelObject.getSistema();
    DueloConBot dcb = new DueloConBot(_sistema);
    DueloDeLeyendasModel _modelObject_1 = this.getModelObject();
    SistemaDeDuelos _sistema_1 = _modelObject_1.getSistema();
    DueloDeLeyendasModel _modelObject_2 = this.getModelObject();
    Jugador _jugador = _modelObject_2.getJugador();
    DueloDeLeyendasModel _modelObject_3 = this.getModelObject();
    PersonajePuntaje _personajeSeleccionado = _modelObject_3.getPersonajeSeleccionado();
    Personaje _pers = _personajeSeleccionado.getPers();
    Personaje persBot = _sistema_1.buscarPersonajeParaDuelo(_jugador, _pers);
    DueloDeLeyendasModel _modelObject_4 = this.getModelObject();
    String _posicion = _modelObject_4.getPosicion();
    DueloDeLeyendasModel _modelObject_5 = this.getModelObject();
    Jugador _jugador_1 = _modelObject_5.getJugador();
    DueloDeLeyendasModel _modelObject_6 = this.getModelObject();
    PersonajePuntaje _personajeSeleccionado_1 = _modelObject_6.getPersonajeSeleccionado();
    Personaje _pers_1 = _personajeSeleccionado_1.getPers();
    ResultadoDuelo dueloBot = dcb.realizarDueloBot(_posicion, _jugador_1, _pers_1, persBot);
    ResultadoDueloWindow _resultadoDueloWindow = new ResultadoDueloWindow(this, dueloBot);
    this.openDialog(_resultadoDueloWindow);
    this.close();
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    _label.setText("¡NO HAY NADIE CON MAS PODER QUE VOS!\nPuedes intensificar tu poder batiendote a duelo con un bot o esperar a un rival digno de tu poder");
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
}

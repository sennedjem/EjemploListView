package view;

import dueloDeLeyendas.dominio.denuncias.Denuncia;
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo;
import dueloDeLeyendas.dominio.jugador.Jugador;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import view.CrearDenunciaWindow;

/**
 * Modela la ventana que muestra el resultado de un duelo
 */
@SuppressWarnings("all")
public class ResultadoDueloWindow extends Dialog<ResultadoDuelo> {
  public ResultadoDueloWindow(final WindowOwner owner, final ResultadoDuelo resultado) {
    super(owner, resultado);
    this.setTitle("Resultado del Duelo");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar resultado");
        final Action _function = new Action() {
          public void execute() {
            ResultadoDueloWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Denunciar actitud antideportiva");
        final Action _function = new Action() {
          public void execute() {
            ResultadoDueloWindow.this.crearDenuncia();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  /**
   * Abre la ventana de Denuncia si el jugador lo cree necesario
   */
  public void crearDenuncia() {
    ResultadoDuelo _modelObject = this.getModelObject();
    Jugador _iniciador = _modelObject.getIniciador();
    ResultadoDuelo _modelObject_1 = this.getModelObject();
    Jugador _retado = _modelObject_1.getRetado();
    Denuncia den = new Denuncia(_iniciador, _retado);
    CrearDenunciaWindow _crearDenunciaWindow = new CrearDenunciaWindow(this, den);
    this.openDialog(_crearDenunciaWindow);
    this.close();
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method ganador is undefined for the type ResultadoDueloWindow"
      + "\nThe method perdedor is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaqueGanador is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaquePerdedor is undefined for the type ResultadoDueloWindow"
      + "\nThe method ganador is undefined for the type ResultadoDueloWindow"
      + "\nThe method perdedor is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaqueGanador is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaquePerdedor is undefined for the type ResultadoDueloWindow"
      + "\nThe method ganador is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaqueGanador is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaquePerdedor is undefined for the type ResultadoDueloWindow"
      + "\nThe method ganador is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaqueGanador is undefined for the type ResultadoDueloWindow"
      + "\nThe method poderAtaquePerdedor is undefined for the type ResultadoDueloWindow"
      + "\nnombreJugador cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nnombreJugador cannot be resolved"
      + "\n== cannot be resolved"
      + "\n! cannot be resolved"
      + "\nnombreJugador cannot be resolved"
      + "\nnombreJugador cannot be resolved"
      + "\n== cannot be resolved"
      + "\n! cannot be resolved"
      + "\nnombreJugador cannot be resolved"
      + "\nnombreJugador cannot be resolved");
  }
  
  public void crearStats(final Panel panel) {
    Panel _panel = new Panel(panel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    Panel stats = _panel.setLayout(_horizontalLayout);
    this.crearStatsPorGanador(stats);
    this.crearStatsPorPerdedor(stats);
  }
  
  public Binding<Object, Control, ControlBuilder> crearStatsPorPerdedor(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method perdedor is undefined for the type ResultadoDueloWindow"
      + "\nThe method perdedorPersonaje is undefined for the type ResultadoDueloWindow"
      + "\nnombreJugador cannot be resolved"
      + "\nnombre cannot be resolved");
  }
  
  public void crearStatsPorGanador(final Panel panel) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method ganador is undefined for the type ResultadoDueloWindow"
      + "\nThe method ganadorPersonaje is undefined for the type ResultadoDueloWindow"
      + "\nnombreJugador cannot be resolved"
      + "\nnombre cannot be resolved");
  }
}

package view;

import dueloDeLeyendas.dominio.denuncias.Denuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;
import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

/**
 * Modela la ventana de una denuncia valida
 */
@SuppressWarnings("all")
public class DenunciaValidaWindow extends Dialog<Denuncia> {
  public DenunciaValidaWindow(final WindowOwner parent, final Denuncia model) {
    super(parent, model);
    this.setTitle("Denuncia Procesada");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            DenunciaValidaWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        Denuncia _modelObject = DenunciaValidaWindow.this.getModelObject();
        Jugador _denunciado = _modelObject.getDenunciado();
        String _nombreJugador = _denunciado.getNombreJugador();
        String _plus = ("Hemos sancionado a " + _nombreJugador);
        it.setText(_plus);
        it.setForeground(Color.WHITE);
        it.setBackground(Color.BLACK);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("En Duelo de Leyendas somos partidarios del fair play.\nGracias por ayudarnos a mantenernos así!!!");
  }
}

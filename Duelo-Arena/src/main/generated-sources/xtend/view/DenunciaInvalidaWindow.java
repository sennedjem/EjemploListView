package view;

import dueloDeLeyendas.dominio.denuncias.Denuncia;
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
 * Modela la ventana de una denuncia invalida
 */
@SuppressWarnings("all")
public class DenunciaInvalidaWindow extends Dialog<Denuncia> {
  public DenunciaInvalidaWindow(final WindowOwner parent, final Denuncia model) {
    super(parent, model);
    this.setTitle("Su Denuncia Ha Sido Invalida");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            DenunciaInvalidaWindow.this.close();
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
        it.setText("Has sido sancionado!");
        it.setForeground(Color.WHITE);
        it.setBackground(Color.BLACK);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Hemos detectado que tu denuncia no tiene fundamentos sólidos.\nEn duelo de leyendas desalentamos este tipo de actitudes y somos partidarios del fair play.\nCon lo que has recibido una sanción por tu actitud antideportiva,esperamos que reflexiones sobre tu actitud.");
  }
}

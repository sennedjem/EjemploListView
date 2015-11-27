package view;

import dueloDeLeyendas.dominio.denuncias.Denuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;
import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import view.DenunciaInvalidaWindow;
import view.DenunciaValidaWindow;

/**
 * Modela la ventana desde donde se realizan las denuncias
 */
@SuppressWarnings("all")
public class CrearDenunciaWindow extends Dialog<Denuncia> {
  public CrearDenunciaWindow(final WindowOwner parent, final Denuncia model) {
    super(parent, model);
    this.setTitle("Realizar Denuncia");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Denunciar");
        final Action _function = new Action() {
          public void execute() {
            CrearDenunciaWindow.this.verificar();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Cancelar");
        final Action _function = new Action() {
          public void execute() {
            CrearDenunciaWindow.this.cerrar();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Hacer denuncia");
        it.setForeground(Color.WHITE);
        it.setBackground(Color.BLACK);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(mainPanel);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        Denuncia _modelObject = CrearDenunciaWindow.this.getModelObject();
        Jugador _denunciado = _modelObject.getDenunciado();
        String _nombreJugador = _denunciado.getNombreJugador();
        String _plus = ("Estas queriendo denunciar a " + _nombreJugador);
        it.setText(_plus);
        it.setForeground(Color.GREEN);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
    final Panel denunciasPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    denunciasPanel.setLayout(_columnLayout);
    Label _label_2 = new Label(denunciasPanel);
    _label_2.setText("Motivo");
    Selector<Object> _selector = new Selector<Object>(denunciasPanel);
    final Procedure1<Selector<Object>> _function_2 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(false);
        it.bindItemsToProperty("tiposDeDenuncia");
        it.<Object, ControlBuilder>bindValueToProperty("motivo");
        it.setWidth(250);
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_2);
    Label _label_3 = new Label(denunciasPanel);
    _label_3.setText("Detalles");
    TextBox _textBox = new TextBox(denunciasPanel);
    final Procedure1<TextBox> _function_3 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("justificacion");
        it.setWidth(250);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_3);
  }
  
  /**
   * Verifica la validez de la denuncia y abre la correspondiente ventana dependiendo del caso
   */
  public void verificar() {
    Denuncia _modelObject = this.getModelObject();
    boolean _esValida = _modelObject.esValida();
    if (_esValida) {
      this.verDenunciaValidaWindow();
    } else {
      this.verDenunciaInvalidaWindow();
    }
    this.close();
  }
  
  /**
   * Abre una ventana indicando que se sanciono al jugador denunciado si se conprueba que la denuncia es valida
   */
  public void verDenunciaValidaWindow() {
    Denuncia _modelObject = this.getModelObject();
    DenunciaValidaWindow _denunciaValidaWindow = new DenunciaValidaWindow(this, _modelObject);
    this.openDialog(_denunciaValidaWindow);
  }
  
  /**
   * Abre una ventana indicando que se sanciono al jugador denunciante porque los motivos de la denuncia no son validos
   */
  public void verDenunciaInvalidaWindow() {
    Denuncia _modelObject = this.getModelObject();
    DenunciaInvalidaWindow _denunciaInvalidaWindow = new DenunciaInvalidaWindow(this, _modelObject);
    this.openDialog(_denunciaInvalidaWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
  
  /**
   * Cierra la ventana
   */
  public void cerrar() {
    Denuncia _modelObject = this.getModelObject();
    _modelObject.setJustificacion(null);
    Denuncia _modelObject_1 = this.getModelObject();
    _modelObject_1.setMotivo(null);
    this.close();
  }
}

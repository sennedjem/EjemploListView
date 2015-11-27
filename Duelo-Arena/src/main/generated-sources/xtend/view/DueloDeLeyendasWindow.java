package view;

import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel;
import dueloDeLeyendas.dominio.applicationModel.PersonajePuntaje;
import dueloDeLeyendas.dominio.duelo.ResultadoDuelo;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.sistemaDeDuelos.NoHayRival;
import java.awt.Color;
import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import view.NoHayRivalWindow;
import view.ResultadoDueloWindow;

/**
 * Modela la ventana del sistema desde la cual un jugador puede elegir personajes y retar a duelo a otros jugadores
 */
@SuppressWarnings("all")
public class DueloDeLeyendasWindow extends SimpleWindow<DueloDeLeyendasModel> {
  public DueloDeLeyendasWindow(final WindowOwner parent, final DueloDeLeyendasModel model) {
    super(parent, model);
    this.setTitle("Duelo De Leyendas");
    DueloDeLeyendasModel _modelObject = this.getModelObject();
    Jugador _jugador = _modelObject.getJugador();
    String _nombreJugador = _jugador.getNombreJugador();
    String _plus = ("¡Bienvenido: " + _nombreJugador);
    String _plus_1 = (_plus + "! Desde esta pantalla podras elegir un personaje para batirte a duelo con otro jugador.\r\n¡Recuerda siempre revisar tus stats!");
    this.setTaskDescription(_plus_1);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("¡Selecciona tu personaje para el duelo!");
        it.setForeground(Color.WHITE);
        it.setBackground(Color.BLACK);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(3);
    final Panel sndMainPanel = _panel.setLayout(_columnLayout);
    Panel _panel_1 = new Panel(sndMainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    final Panel tablas = _panel_1.setLayout(_verticalLayout);
    Panel _panel_2 = new Panel(tablas);
    ColumnLayout _columnLayout_1 = new ColumnLayout(2);
    final Panel panelSelector = _panel_2.setLayout(_columnLayout_1);
    Label _label_1 = new Label(panelSelector);
    _label_1.setText("Personaje buscado");
    TextBox _textBox = new TextBox(panelSelector);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        final TextFilter _function = new TextFilter() {
          public boolean accept(final TextInputEvent event) {
            String _potentialTextResult = event.getPotentialTextResult();
            return StringUtils.isAlpha(_potentialTextResult);
          }
        };
        it.withFilter(_function);
        it.<Object, ControlBuilder>bindValueToProperty("buscado");
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    this.crearTablaPersonajes(tablas);
    Panel _panel_3 = new Panel(sndMainPanel);
    final Procedure1<Panel> _function_2 = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        VerticalLayout _verticalLayout = new VerticalLayout();
        it.setLayout(_verticalLayout);
      }
    };
    final Panel panelSelected = ObjectExtensions.<Panel>operator_doubleArrow(_panel_3, _function_2);
    this.crearPanelPersonajeSeleccionado(panelSelected);
    Panel _panel_4 = new Panel(sndMainPanel);
    final Procedure1<Panel> _function_3 = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        VerticalLayout _verticalLayout = new VerticalLayout();
        it.setLayout(_verticalLayout);
      }
    };
    final Panel panelStats = ObjectExtensions.<Panel>operator_doubleArrow(_panel_4, _function_3);
    this.crearPanelStats(panelStats);
    Label _label_2 = new Label(panelStats);
    final Procedure1<Label> _function_4 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Jugar");
        it.setForeground(Color.BLUE);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function_4);
    Panel _panel_5 = new Panel(panelStats);
    ColumnLayout _columnLayout_2 = new ColumnLayout(2);
    Panel botones = _panel_5.setLayout(_columnLayout_2);
    Button _button = new Button(botones);
    final Procedure1<Button> _function_5 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("TOP");
        final Action _function = new Action() {
          public void execute() {
            DueloDeLeyendasWindow.this.iniciarDuelo("TOP");
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_5);
    Button _button_1 = new Button(botones);
    final Procedure1<Button> _function_6 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("MID");
        final Action _function = new Action() {
          public void execute() {
            DueloDeLeyendasWindow.this.iniciarDuelo("MID");
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_6);
    Button _button_2 = new Button(botones);
    final Procedure1<Button> _function_7 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("BOT");
        final Action _function = new Action() {
          public void execute() {
            DueloDeLeyendasWindow.this.iniciarDuelo("BOT");
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_7);
    Button _button_3 = new Button(botones);
    final Procedure1<Button> _function_8 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("JUNGLE");
        final Action _function = new Action() {
          public void execute() {
            DueloDeLeyendasWindow.this.iniciarDuelo("JUNGLE");
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_8);
  }
  
  public Column<PersonajePuntaje> crearTablaPersonajes(final Panel panel) {
    Column<PersonajePuntaje> _xblockexpression = null;
    {
      Table<PersonajePuntaje> _table = new Table<PersonajePuntaje>(panel, PersonajePuntaje.class);
      final Procedure1<Table<PersonajePuntaje>> _function = new Procedure1<Table<PersonajePuntaje>>() {
        public void apply(final Table<PersonajePuntaje> it) {
          it.bindItemsToProperty("personajesFiltrados");
          it.<Object, ControlBuilder>bindValueToProperty("personajeSeleccionado");
          it.setHeight(150);
        }
      };
      final Table<PersonajePuntaje> table = ObjectExtensions.<Table<PersonajePuntaje>>operator_doubleArrow(_table, _function);
      _xblockexpression = this.describeResultGrid(table);
    }
    return _xblockexpression;
  }
  
  public Column<PersonajePuntaje> describeResultGrid(final Table<PersonajePuntaje> table) {
    Column<PersonajePuntaje> _xblockexpression = null;
    {
      Column<PersonajePuntaje> _column = new Column<PersonajePuntaje>(table);
      final Procedure1<Column<PersonajePuntaje>> _function = new Procedure1<Column<PersonajePuntaje>>() {
        public void apply(final Column<PersonajePuntaje> it) {
          it.setTitle("Personaje");
          it.setFixedSize(100);
          it.bindContentsToProperty("pers.nombre");
        }
      };
      ObjectExtensions.<Column<PersonajePuntaje>>operator_doubleArrow(_column, _function);
      Column<PersonajePuntaje> _column_1 = new Column<PersonajePuntaje>(table);
      final Procedure1<Column<PersonajePuntaje>> _function_1 = new Procedure1<Column<PersonajePuntaje>>() {
        public void apply(final Column<PersonajePuntaje> it) {
          it.setTitle("Puntaje");
          it.setFixedSize(100);
          it.bindContentsToProperty("clasificacion");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<PersonajePuntaje>>operator_doubleArrow(_column_1, _function_1);
    }
    return _xblockexpression;
  }
  
  public Label crearPanelPersonajeSeleccionado(final Panel panel) {
    Label _xblockexpression = null;
    {
      Label _label = new Label(panel);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.<Object, ControlBuilder>bindValueToProperty("personajeSeleccionado.pers.nombre");
          it.setForeground(Color.BLUE);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      Label _label_1 = new Label(panel);
      final Procedure1<Label> _function_1 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Especialidades:");
          it.setForeground(Color.GREEN);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
      Table<String> _table = new Table<String>(panel, String.class);
      final Procedure1<Table<String>> _function_2 = new Procedure1<Table<String>>() {
        public void apply(final Table<String> it) {
          it.bindItemsToProperty("personajeSeleccionado.pers.especialidades");
        }
      };
      ObjectExtensions.<Table<String>>operator_doubleArrow(_table, _function_2);
      Label _label_2 = new Label(panel);
      final Procedure1<Label> _function_3 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Debilidades:");
          it.setForeground(Color.GREEN);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function_3);
      Table<String> _table_1 = new Table<String>(panel, String.class);
      final Procedure1<Table<String>> _function_4 = new Procedure1<Table<String>>() {
        public void apply(final Table<String> it) {
          it.bindItemsToProperty("personajeSeleccionado.pers.debilidades");
        }
      };
      ObjectExtensions.<Table<String>>operator_doubleArrow(_table_1, _function_4);
      Label _label_3 = new Label(panel);
      final Procedure1<Label> _function_5 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Mejor Posición:");
          it.setForeground(Color.GREEN);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label_3, _function_5);
      Label _label_4 = new Label(panel);
      final Procedure1<Label> _function_6 = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.<Object, ControlBuilder>bindValueToProperty("personajeSeleccionado.pers.posicionIdeal");
        }
      };
      _xblockexpression = ObjectExtensions.<Label>operator_doubleArrow(_label_4, _function_6);
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> crearPanelStats(final Panel panel) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(panel);
      final Procedure1<Label> _function = new Procedure1<Label>() {
        public void apply(final Label it) {
          it.setText("Stats");
          it.setForeground(Color.BLUE);
        }
      };
      ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      Panel _panel = new Panel(panel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      Panel stats = _panel.setLayout(_columnLayout);
      Label _label_1 = new Label(stats);
      _label_1.setText("Jugadas");
      Label _label_2 = new Label(stats);
      _label_2.<Object, ControlBuilder>bindValueToProperty("statsPersonajeSeleccionado.jugados");
      Label _label_3 = new Label(stats);
      _label_3.setText("Ganadas");
      Label _label_4 = new Label(stats);
      _label_4.<Object, ControlBuilder>bindValueToProperty("statsPersonajeSeleccionado.cantDuelosGanados");
      Label _label_5 = new Label(stats);
      _label_5.setText("Kills");
      Label _label_6 = new Label(stats);
      _label_6.<Object, ControlBuilder>bindValueToProperty("statsPersonajeSeleccionado.cantKills");
      Label _label_7 = new Label(stats);
      _label_7.setText("Deads");
      Label _label_8 = new Label(stats);
      _label_8.<Object, ControlBuilder>bindValueToProperty("statsPersonajeSeleccionado.cantDeads");
      Label _label_9 = new Label(stats);
      _label_9.setText("Assists");
      Label _label_10 = new Label(stats);
      _label_10.<Object, ControlBuilder>bindValueToProperty("statsPersonajeSeleccionado.assists");
      Label _label_11 = new Label(stats);
      _label_11.setText("Mejor ubicación");
      Label _label_12 = new Label(stats);
      _label_12.<Object, ControlBuilder>bindValueToProperty("statsPersonajeSeleccionado.mejorUbicacion");
      Label _label_13 = new Label(stats);
      _label_13.setText("Puntaje");
      Label _label_14 = new Label(stats);
      _xblockexpression = _label_14.<Object, ControlBuilder>bindValueToProperty("personajeSeleccionado.clasificacion");
    }
    return _xblockexpression;
  }
  
  public void iniciarDuelo(final String pos) {
    try {
      DueloDeLeyendasModel _modelObject = this.getModelObject();
      _modelObject.setPosicion(pos);
      DueloDeLeyendasModel _modelObject_1 = this.getModelObject();
      ResultadoDuelo _iniciarDuelo = _modelObject_1.iniciarDuelo();
      ResultadoDueloWindow _resultadoDueloWindow = new ResultadoDueloWindow(this, _iniciarDuelo);
      this.openDialog(_resultadoDueloWindow);
    } catch (final Throwable _t) {
      if (_t instanceof NoHayRival) {
        final NoHayRival e = (NoHayRival)_t;
        DueloDeLeyendasModel _modelObject_2 = this.getModelObject();
        NoHayRivalWindow _noHayRivalWindow = new NoHayRivalWindow(this, _modelObject_2);
        this.openDialog(_noHayRivalWindow);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void openDialog(final Dialog<?> dialog) {
    dialog.open();
  }
}

package runnable;

import dueloDeLeyendas.dominio.applicationModel.DueloDeLeyendasModel;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import view.DueloDeLeyendasWindow;

@SuppressWarnings("all")
public class DueloDeLeyendasApplication extends Application {
  public Window<?> createMainWindow() {
    DueloDeLeyendasModel _dueloDeLeyendasModel = new DueloDeLeyendasModel();
    return new DueloDeLeyendasWindow(this, _dueloDeLeyendasModel);
  }
  
  public static void main(final String[] args) {
    DueloDeLeyendasApplication _dueloDeLeyendasApplication = new DueloDeLeyendasApplication();
    _dueloDeLeyendasApplication.start();
  }
}

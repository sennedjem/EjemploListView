package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;
import org.eclipse.xtend.lib.annotations.Accessors;

@Accessors
@SuppressWarnings("all")
public class FeedIntencional extends MotivoDenuncia {
  public FeedIntencional() {
    super(Integer.valueOf(10));
  }
  
  public String toString() {
    return "Feed intencional";
  }
}

package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;

@SuppressWarnings("all")
public class ComunicacionAbusiva extends MotivoDenuncia {
  public ComunicacionAbusiva() {
    super(Integer.valueOf(7));
  }
  
  public String toString() {
    return "Comunicacion abusiva";
  }
}

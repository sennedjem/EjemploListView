package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;

@SuppressWarnings("all")
public class AbusoHabilidad extends MotivoDenuncia {
  public AbusoHabilidad() {
    super(Integer.valueOf(5));
  }
  
  public String toString() {
    return "Abuso de habilidad";
  }
}

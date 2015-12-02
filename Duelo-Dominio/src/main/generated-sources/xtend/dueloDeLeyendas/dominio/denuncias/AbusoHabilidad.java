package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;

@SuppressWarnings("all")
public class AbusoHabilidad extends MotivoDenuncia {
  /**
   * Suma 5 puntos de denuncia por abuso de habilidad
   */
  public AbusoHabilidad() {
    super(Integer.valueOf(5));
  }
  
  public String toString() {
    return "Abuso de habilidad";
  }
}

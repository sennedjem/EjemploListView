package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.jugador.Jugador;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Modela al tipo de denuncia, su peso y quien es denunciado se define en las subclases de esta
 */
@Accessors
@SuppressWarnings("all")
public abstract class MotivoDenuncia {
  private int peso;
  
  public MotivoDenuncia(final Integer pesoDenuncia) {
    this.peso = (pesoDenuncia).intValue();
  }
  
  /**
   * Retorna el jugador al cual se le debe aplicar la denuncia
   */
  public Jugador aQuienCastigo(final Jugador denunciado, final Jugador denunciante) {
    return denunciado;
  }
  
  @Pure
  public int getPeso() {
    return this.peso;
  }
  
  public void setPeso(final int peso) {
    this.peso = peso;
  }
}

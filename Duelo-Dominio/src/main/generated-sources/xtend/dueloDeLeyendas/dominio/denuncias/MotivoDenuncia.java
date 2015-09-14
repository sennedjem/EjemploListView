package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.jugador.Jugador;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public abstract class MotivoDenuncia {
  private int peso;
  
  public MotivoDenuncia(final Integer pesoDenuncia) {
    this.peso = (pesoDenuncia).intValue();
  }
  
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

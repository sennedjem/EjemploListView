package dueloDeLeyendas.dominio.applicationModel;

import dueloDeLeyendas.dominio.personaje.Personaje;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class PersonajePuntaje {
  private Personaje pers;
  
  private String clasificacion;
  
  public PersonajePuntaje(final Personaje p, final String c) {
    this.pers = p;
    this.clasificacion = c;
  }
  
  @Pure
  public Personaje getPers() {
    return this.pers;
  }
  
  public void setPers(final Personaje pers) {
    this.pers = pers;
  }
  
  @Pure
  public String getClasificacion() {
    return this.clasificacion;
  }
  
  public void setClasificacion(final String clasificacion) {
    this.clasificacion = clasificacion;
  }
}

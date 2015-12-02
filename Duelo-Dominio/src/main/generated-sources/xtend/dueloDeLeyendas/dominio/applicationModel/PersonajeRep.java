package dueloDeLeyendas.dominio.applicationModel;

import dueloDeLeyendas.dominio.applicationModel.EstadisticasRep;
import dueloDeLeyendas.dominio.estadisticas.Estadisticas;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class PersonajeRep {
  private String nombre;
  
  private String path;
  
  private List<String> especialidades;
  
  private List<String> debilidades;
  
  private String posicionIdeal;
  
  private EstadisticasRep stat;
  
  public PersonajeRep(final Personaje pers, final String p, final Jugador jugador) {
    String _nombre = pers.getNombre();
    this.nombre = _nombre;
    this.path = p;
    List<String> _especialidades = pers.getEspecialidades();
    this.especialidades = _especialidades;
    List<String> _debilidades = pers.getDebilidades();
    this.debilidades = _debilidades;
    String _posicionIdeal = pers.getPosicionIdeal();
    this.posicionIdeal = _posicionIdeal;
    Estadisticas _estadisticas = jugador.getEstadisticas(pers);
    EstadisticasRep _estadisticasRep = new EstadisticasRep(_estadisticas);
    this.stat = _estadisticasRep;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
  
  @Pure
  public List<String> getEspecialidades() {
    return this.especialidades;
  }
  
  public void setEspecialidades(final List<String> especialidades) {
    this.especialidades = especialidades;
  }
  
  @Pure
  public List<String> getDebilidades() {
    return this.debilidades;
  }
  
  public void setDebilidades(final List<String> debilidades) {
    this.debilidades = debilidades;
  }
  
  @Pure
  public String getPosicionIdeal() {
    return this.posicionIdeal;
  }
  
  public void setPosicionIdeal(final String posicionIdeal) {
    this.posicionIdeal = posicionIdeal;
  }
  
  @Pure
  public EstadisticasRep getStat() {
    return this.stat;
  }
  
  public void setStat(final EstadisticasRep stat) {
    this.stat = stat;
  }
}

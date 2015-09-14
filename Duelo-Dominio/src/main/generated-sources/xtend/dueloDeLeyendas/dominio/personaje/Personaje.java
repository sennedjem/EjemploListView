package dueloDeLeyendas.dominio.personaje;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Esta clase modela a los personajes y sus caracteristicas
 */
@Accessors
@SuppressWarnings("all")
public class Personaje {
  private final String nombre;
  
  private final List<String> especialidades;
  
  private final List<String> debilidades;
  
  private final String posicionIdeal;
  
  private Integer clasificacion;
  
  /**
   * Este constructor crea una instancia de la clase con los atributos pasados por parametro
   */
  public Personaje(final String name, final List<String> esp, final List<String> deb, final String posIdeal) {
    this.nombre = name;
    this.posicionIdeal = posIdeal;
    this.debilidades = deb;
    this.especialidades = esp;
    this.clasificacion = Integer.valueOf(0);
  }
  
  /**
   * Este método le agrega una nueva especialidad al personaje
   */
  public boolean agregarEspecialidad(final String especialidad) {
    return this.especialidades.add(especialidad);
  }
  
  /**
   * Este metodo le agrega una nueva debilidad al personaje
   */
  public boolean agregarDebilidad(final String debilidad) {
    return this.debilidades.add(debilidad);
  }
  
  /**
   * Este metodo devuelve la clasificacion correspondiente segun su valor
   */
  public String getClasificacion() {
    String _xblockexpression = null;
    {
      String clas = null;
      final Integer clasificacion = this.clasificacion;
      boolean _matched = false;
      if (!_matched) {
        if (((clasificacion).intValue() == 5)) {
          _matched=true;
          clas = "NOOB";
        }
      }
      if (!_matched) {
        if (((clasificacion).intValue() == 15)) {
          _matched=true;
          clas = "MANCO";
        }
      }
      if (!_matched) {
        if (((clasificacion).intValue() == 30)) {
          _matched=true;
          clas = "SHAME-ON-YOU";
        }
      }
      if (!_matched) {
        if (((clasificacion).intValue() == 60)) {
          _matched=true;
          clas = "KILLING-SPREAD";
        }
      }
      if (!_matched) {
        if (((clasificacion).intValue() == 75)) {
          _matched=true;
          clas = "DOMINADOR";
        }
      }
      if (!_matched) {
        if (((clasificacion).intValue() == 100)) {
          _matched=true;
          clas = "RAMPAGE";
        }
      }
      _xblockexpression = clas;
    }
    return _xblockexpression;
  }
  
  /**
   * Este método devuelve la clasificación del personaje en números
   */
  public Integer getClasificacionNumerica() {
    return this.clasificacion;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  @Pure
  public List<String> getEspecialidades() {
    return this.especialidades;
  }
  
  @Pure
  public List<String> getDebilidades() {
    return this.debilidades;
  }
  
  @Pure
  public String getPosicionIdeal() {
    return this.posicionIdeal;
  }
  
  public void setClasificacion(final Integer clasificacion) {
    this.clasificacion = clasificacion;
  }
}

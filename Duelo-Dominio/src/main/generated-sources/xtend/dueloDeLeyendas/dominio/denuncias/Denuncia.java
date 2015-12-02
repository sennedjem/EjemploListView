package dueloDeLeyendas.dominio.denuncias;

import dueloDeLeyendas.dominio.denuncias.AbusoHabilidad;
import dueloDeLeyendas.dominio.denuncias.ComunicacionAbusiva;
import dueloDeLeyendas.dominio.denuncias.FeedIntencional;
import dueloDeLeyendas.dominio.denuncias.MotivoDenuncia;
import dueloDeLeyendas.dominio.jugador.Jugador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

/**
 * Modela a las denuncias con sus diferentes tipos
 */
@Observable
@Accessors
@SuppressWarnings("all")
public class Denuncia {
  private String justificacion;
  
  private Jugador denunciante;
  
  private Jugador denunciado;
  
  private MotivoDenuncia motivo;
  
  /**
   * Crea una nueva instancia de la denuncia con los dos jugadores necesarios
   */
  public Denuncia(final Jugador denunciante, final Jugador denunciado) {
    this.denunciante = denunciante;
    this.denunciado = denunciado;
  }
  
  /**
   * Agrega los tipos de denuncia existentes en el sistema
   */
  public List<String> tiposDeDenuncia() {
    List<String> _xblockexpression = null;
    {
      List<String> lista = new ArrayList<String>();
      lista.add("Abuso de habilidad");
      lista.add("Comunicacion abusiva");
      lista.add("Feed intencional");
      _xblockexpression = lista;
    }
    return _xblockexpression;
  }
  
  /**
   * Verifica las condiciones para validar la denuncia, estas son: tener mas de tres palabras o una longitud
   * de mas de 20 caracteres
   */
  public boolean esValida() {
    boolean _and = false;
    boolean _tieneMasDeTresPalabras = this.tieneMasDeTresPalabras(this.justificacion);
    if (!_tieneMasDeTresPalabras) {
      _and = false;
    } else {
      int _length = this.justificacion.length();
      boolean _greaterThan = (_length > 20);
      _and = _greaterThan;
    }
    return _and;
  }
  
  /**
   * Verifica que la denuncia tenga mas de tres palabras
   */
  private boolean tieneMasDeTresPalabras(final String justificacion2) {
    int aDev = 0;
    for (int i = 0; (i < justificacion2.length()); i++) {
      char _charAt = justificacion2.charAt(i);
      Character _valueOf = Character.valueOf(' ');
      char _charValue = _valueOf.charValue();
      boolean _tripleEquals = (_charAt == _charValue);
      if (_tripleEquals) {
        aDev = (aDev + 1);
      }
    }
    return (aDev > 3);
  }
  
  /**
   * Aplica la penalizacion correspondiente
   */
  public void realizarPenalizacion() {
    Jugador _denunciado = this.getDenunciado();
    Jugador _denunciante = this.getDenunciante();
    Jugador jug = this.motivo.aQuienCastigo(_denunciado, _denunciante);
    this.castigarJugador(jug);
  }
  
  /**
   * Suma el peso correspondiente dependiendo de la sanción aplicada
   */
  public void castigarJugador(final Jugador jug) {
    int _peso = this.motivo.getPeso();
    jug.sumaleATuPesoDeDenuncia(Integer.valueOf(_peso));
  }
  
  /**
   * Retorna la lista con los tipos de denuncia que puede realizar un jugador
   */
  public List<? extends MotivoDenuncia> getTiposDeDenuncia() {
    AbusoHabilidad _abusoHabilidad = new AbusoHabilidad();
    ComunicacionAbusiva _comunicacionAbusiva = new ComunicacionAbusiva();
    FeedIntencional _feedIntencional = new FeedIntencional();
    return Collections.<MotivoDenuncia>unmodifiableList(CollectionLiterals.<MotivoDenuncia>newArrayList(_abusoHabilidad, _comunicacionAbusiva, _feedIntencional));
  }
  
  @Pure
  public String getJustificacion() {
    return this.justificacion;
  }
  
  public void setJustificacion(final String justificacion) {
    this.justificacion = justificacion;
  }
  
  @Pure
  public Jugador getDenunciante() {
    return this.denunciante;
  }
  
  public void setDenunciante(final Jugador denunciante) {
    this.denunciante = denunciante;
  }
  
  @Pure
  public Jugador getDenunciado() {
    return this.denunciado;
  }
  
  public void setDenunciado(final Jugador denunciado) {
    this.denunciado = denunciado;
  }
  
  @Pure
  public MotivoDenuncia getMotivo() {
    return this.motivo;
  }
  
  public void setMotivo(final MotivoDenuncia motivo) {
    this.motivo = motivo;
  }
}

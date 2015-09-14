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

@Accessors
@SuppressWarnings("all")
public class Denuncia {
  private String justificacion;
  
  private Jugador denunciante;
  
  private Jugador denunciado;
  
  private MotivoDenuncia motivo;
  
  public Denuncia(final Jugador denunciante, final Jugador denunciado) {
    this.denunciante = denunciante;
    this.denunciado = denunciado;
  }
  
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
  
  public boolean esValida() {
    return this.tieneMasDeTresPalabras(this.justificacion);
  }
  
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
  
  public void realizarPenalizacion() {
    Jugador _denunciado = this.getDenunciado();
    Jugador _denunciante = this.getDenunciante();
    Jugador jug = this.motivo.aQuienCastigo(_denunciado, _denunciante);
    this.castigarJugador(jug);
  }
  
  public void castigarJugador(final Jugador jug) {
    int _peso = this.motivo.getPeso();
    jug.sumaleATuPesoDeDenuncia(Integer.valueOf(_peso));
  }
  
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

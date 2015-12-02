package dueloDeLeyendas.dominio.applicationModel;

import dueloDeLeyendas.dominio.applicationModel.PersonajeRep;
import dueloDeLeyendas.dominio.jugador.Jugador;
import dueloDeLeyendas.dominio.personaje.Personaje;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoWeb {
  private Jugador jugador;
  
  public RepoWeb(final Jugador j) {
    this.jugador = j;
  }
  
  public ArrayList<PersonajeRep> personajes() {
    ArrayList<PersonajeRep> _xblockexpression = null;
    {
      ArrayList<PersonajeRep> pers = CollectionLiterals.<PersonajeRep>newArrayList();
      List<String> habilidades = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataque", "Defensa"));
      List<String> habilidades2 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Auto recuperacion"));
      List<String> habilidades3 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Daño a distancia", "Hundir acorazados"));
      List<String> habilidades4 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Proteccion ante hechizos", "Auto recuperacion"));
      List<String> habilidades5 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Magia", "Recuperación acelerada"));
      List<String> habilidades6 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataque avanzado con espada", "Magia"));
      List<String> habilidades7 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Protección durante 10 segundos"));
      List<String> habilidades8 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Chaleco antibalas", "Resistencia al fuego"));
      List<String> habilidades9 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataque triplicado", "Defensa inquebrantable"));
      List<String> habilidades10 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Magia"));
      List<String> debilidades = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Alergico al agua"));
      List<String> debilidades2 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Miedo a la Obscuridad", "Ataque de asma"));
      List<String> debilidades3 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("No sabe leer", "Poca resistencia"));
      List<String> debilidades4 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Hemorragia veloz"));
      List<String> debilidades5 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Impactos de bala", "Batalla cuerpo a cuerpo"));
      List<String> debilidades6 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataque de espada"));
      List<String> debilidades7 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataque de brujos"));
      List<String> debilidades8 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataque de heroes"));
      List<String> debilidades9 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Batallas largas"));
      List<String> debilidades10 = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Ataques directos"));
      final Personaje per1 = new Personaje("Amumu", habilidades, debilidades, "MID");
      final Personaje per2 = new Personaje("Mirana", habilidades2, debilidades2, "TOP");
      final Personaje per3 = new Personaje("Pudge", habilidades3, debilidades3, "JUNGLE");
      final Personaje per4 = new Personaje("Skywrath", habilidades4, debilidades4, "BOT");
      final Personaje per5 = new Personaje("Clockwerk", habilidades5, debilidades5, "MID");
      final Personaje per6 = new Personaje("Bloodseeker", habilidades6, debilidades6, "TOP");
      final Personaje per7 = new Personaje("Clinkz", habilidades7, debilidades7, "JUNGLE");
      final Personaje per8 = new Personaje("Draven", habilidades8, debilidades8, "BOT");
      final Personaje per9 = new Personaje("Graves", habilidades9, debilidades9, "JUNGLE");
      final Personaje per10 = new Personaje("Jayce", habilidades10, debilidades10, "MID");
      final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
        public void apply(final Jugador it) {
          it.agregarEstadistica(per1);
          it.agregarEstadistica(per2);
          it.agregarEstadistica(per3);
          it.agregarEstadistica(per4);
          it.agregarEstadistica(per5);
          it.agregarEstadistica(per6);
          it.agregarEstadistica(per7);
          it.agregarEstadistica(per8);
          it.agregarEstadistica(per9);
          it.agregarEstadistica(per10);
        }
      };
      ObjectExtensions.<Jugador>operator_doubleArrow(
        this.jugador, _function);
      final PersonajeRep pers1 = new PersonajeRep(per1, "@drawable/amumu", this.jugador);
      final PersonajeRep pers2 = new PersonajeRep(per2, "@drawable/mirana", this.jugador);
      final PersonajeRep pers3 = new PersonajeRep(per3, "@drawable/pudge", this.jugador);
      final PersonajeRep pers4 = new PersonajeRep(per4, "@drawable/skywrath", this.jugador);
      final PersonajeRep pers5 = new PersonajeRep(per5, "@drawable/clockwerk", this.jugador);
      final PersonajeRep pers6 = new PersonajeRep(per6, "@drawable/bloodseeker", this.jugador);
      final PersonajeRep pers7 = new PersonajeRep(per7, "@drawable/clinkz", this.jugador);
      final PersonajeRep pers8 = new PersonajeRep(per8, "@drawable/draven", this.jugador);
      final PersonajeRep pers9 = new PersonajeRep(per9, "@drawable/graves", this.jugador);
      final PersonajeRep pers10 = new PersonajeRep(per10, "@drawable/jayce", this.jugador);
      final Procedure1<ArrayList<PersonajeRep>> _function_1 = new Procedure1<ArrayList<PersonajeRep>>() {
        public void apply(final ArrayList<PersonajeRep> it) {
          it.add(pers1);
          it.add(pers2);
          it.add(pers3);
          it.add(pers4);
          it.add(pers5);
          it.add(pers6);
          it.add(pers7);
          it.add(pers8);
          it.add(pers9);
          it.add(pers10);
        }
      };
      _xblockexpression = ObjectExtensions.<ArrayList<PersonajeRep>>operator_doubleArrow(pers, _function_1);
    }
    return _xblockexpression;
  }
  
  @Pure
  public Jugador getJugador() {
    return this.jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this.jugador = jugador;
  }
}

package uis.tp.grupo1.duelodeleyendas;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando on 26/10/15.
 */
public class RepoPersonajes {

    public static List<Personaje> personajes(){
        Personaje per1 = new Personaje("Axe","MID");
        Personaje per2 = new Personaje("Ashe","JUNGLE");
        Personaje per3 = new Personaje("Master Yi","BOT");
        Personaje per4 = new Personaje("Sniper","TOP");
        Personaje per5 = new Personaje("Katarina","MID");
        Personaje per6 = new Personaje("Amumu", "TOP");

        List<Personaje> personajes = new ArrayList<Personaje>();
        personajes.add(per1);
        personajes.add(per2);
        personajes.add(per3);
        personajes.add(per4);
        personajes.add(per5);
        personajes.add(per6);

        return personajes;
    }
}

package uis.tp.grupo1.duelodeleyendas;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando on 26/10/15.
 */
public class RepoPersonajes {

    public Personaje per1;
    public Personaje per2;
    public Personaje per3;
    public List<Personaje> pers;

    public RepoPersonajes(){
        this.per1 = new Personaje("01","Axe","MID");
        this.per2 = new Personaje("02","Ashe","JUNGLE");
        this.per3 = new Personaje("03","Master Yi","BOT");
        this.pers = new ArrayList<Personaje>();
        pers.add(per1);
        pers.add(per2);
        pers.add(per3);
    }

    public List<Personaje> personajes(){
        return pers;
    }

    public Personaje getPorNombre(String nombre){
        for(Personaje per:this.pers){
            if(per.getNombre().equals(nombre)){return per;}
        }

        return new Personaje("0"," ", "");
    }

    /*
    public static List<Personaje> personajes(){
        Personaje per1 = new Personaje("01","Axe","MID");
        Personaje per2 = new Personaje("02","Ashe","JUNGLE");
        Personaje per3 = new Personaje("03","Master Yi","BOT");
        Personaje per4 = new Personaje("04","Sniper","TOP");
        Personaje per5 = new Personaje("05","Katarina","MID");
        Personaje per6 = new Personaje("06","Amumu", "TOP");

        List<Personaje> personajes = new ArrayList<Personaje>();
        personajes.add(per1);
        personajes.add(per2);
        personajes.add(per3);
        personajes.add(per4);
        personajes.add(per5);
        personajes.add(per6);

        return personajes;
    }
*/

}

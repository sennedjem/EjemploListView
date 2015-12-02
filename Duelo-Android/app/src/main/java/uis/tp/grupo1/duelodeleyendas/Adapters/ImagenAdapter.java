package uis.tp.grupo1.duelodeleyendas.Adapters;

import java.util.HashMap;
import java.util.Map;

import uis.tp.grupo1.duelodeleyendas.R;

/**
 * Created by sebastian on 01/12/15.
 */
public class ImagenAdapter {
    static Map<String, Integer> mapaImagenes;

    private Map<String, Integer> getMapaImagenes() {
        if (mapaImagenes == null) {
            mapaImagenes = new HashMap<String, Integer>();
            mapaImagenes.put("Amumu", R.drawable.amumu);
            mapaImagenes.put("Mirana", R.drawable.mirana);
            mapaImagenes.put("Pudge", R.drawable.pudge);
            mapaImagenes.put("Skywrath", R.drawable.skywrath);
            mapaImagenes.put("Clockwerk", R.drawable.clockwerk);
            mapaImagenes.put("Bloodseeker", R.drawable.bloodseeker);
            mapaImagenes.put("Clinkz", R.drawable.clinkz);
            mapaImagenes.put("Draven", R.drawable.draven);
            mapaImagenes.put("Graves", R.drawable.graves);
            mapaImagenes.put("Jayce", R.drawable.jayce);
        }
        return mapaImagenes;
    }

    public int getImagen(String stringExtra) {
        Integer result = getMapaImagenes().get(stringExtra);
        if (result == null) {
            return R.drawable.android;
        }
        return result.intValue();
    }
}

package Controladores.app;

import Entidad.app.Pokemon;
import JSON.app.JsonUtiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ControladoraJSON {
    private String fuente;

    public ControladoraJSON (String archivo){
        fuente = JsonUtiles.leer(archivo);
    }

    public LinkedHashSet <Pokemon> generarPokemon(){
        LinkedHashSet<Pokemon> arrayPokemon = new LinkedHashSet<>();
        try {
            JSONArray jsonArray = new JSONArray(fuente);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject temp = jsonArray.getJSONObject(i);
                JSONArray array_type = temp.getJSONArray("Types");
                ArrayList<String> aux_type = new ArrayList<String>();
                for (int j = 0; j < array_type.length(); j++) {
                    aux_type.add(array_type.getString(j));
                }
                JSONArray array_abilities = temp.getJSONArray("Abilities");
                ArrayList<String> aux_abilities = new ArrayList<String>();
                for (int e = 0; e < array_abilities.length(); e++) {
                    aux_abilities.add(array_abilities.getString(e));
                }

                arrayPokemon.add(new Pokemon(temp.getInt("Id"),temp.getString("Name"),temp.getString("Sprite"),aux_type,aux_abilities));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayPokemon;
    }
}

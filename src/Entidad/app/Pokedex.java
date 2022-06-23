package Entidad.app;

import Entidad.app.Pokemon;

import java.io.Serializable;
import java.util.ArrayList;


public class Pokedex implements Serializable {
    private ArrayList<Pokemon> pokedex;

    public Pokedex() {
        this.pokedex=new ArrayList<>();
    }

    public void agregar(Pokemon elemento) {
        this.pokedex.add(elemento);
    }

    public Pokemon borrar(Pokemon elemento) {
        Pokemon aux= new Pokemon();
        for(Pokemon p: pokedex) {
            if(p.equals(elemento))
            {
                aux=p;
            }
        }
        pokedex.remove(aux);
        return aux;
    }

    public ArrayList<Pokemon> listar() {
        return pokedex;
    }
    public void limpiarPokedex ()
    {
        this.pokedex.clear();
    }
}




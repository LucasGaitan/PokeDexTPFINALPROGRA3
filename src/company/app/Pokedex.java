package company.app;

public class Pokedex {

import Entidad.app.Pokemon;

import java.util.ArrayList;


public class Pokedex{
    ArrayList<Pokemon> pokedex;

    public ArrayList<Pokemon> listar(){
        return pokedex;
    }

    public void agregar(Pokemon elemento) {
        pokedex.add(elemento);
    }

    public Pokemon borrar(Pokemon elemento) {
        Pokemon aux= new Pokemon();
        for(Pokemon p: pokedex)
        {
            if(p.equals(elemento))
            {
                aux=p;
            }
        }
        pokedex.remove(aux);
        return aux;
    }

    public void pokedex() {

    }

    public void listar() {

    }

    public void transferir() {

    }

    public Pokedex borrar(Pokedex elemento) {
        return null;
    }

}




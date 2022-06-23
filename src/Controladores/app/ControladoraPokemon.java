package Controladores.app;


import Entidad.app.Pokemon;
import Entidad.app.Usuario;
import Exception.app.ENotFoundException;
import Interfaces.app.IAbm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;


public class ControladoraPokemon implements IAbm<Pokemon> {
    private LinkedHashSet<Pokemon> listaDePokemon;


    public ControladoraPokemon (LinkedHashSet <Pokemon> listaDePokemon)
    {
        this.listaDePokemon=listaDePokemon;
    }


    @Override
    public void agregar(Pokemon elemento) {
        listaDePokemon.add(elemento);
    }

    @Override
    public Pokemon borrar(Pokemon elemento) {
        listaDePokemon.remove(elemento);
        return elemento;
    }

    @Override
    public void modificar(Pokemon elemento) {
        for(Pokemon p: listaDePokemon)
        {
            if(p.equals(elemento))
            {
                listaDePokemon.remove(p);
                listaDePokemon.add(elemento);
            }
        }
    }


}
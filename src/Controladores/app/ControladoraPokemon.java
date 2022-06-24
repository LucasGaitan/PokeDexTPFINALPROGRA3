package Controladores.app;


import Entidad.app.Pokemon;
import Interfaces.app.IAbm;

import java.util.LinkedHashSet;


public class ControladoraPokemon implements IAbm<Pokemon> {
    private LinkedHashSet<Pokemon> listaDePokemon;

    //constructor utilizado para asignar la lista de pokemones desde aplicacion
    public ControladoraPokemon (LinkedHashSet <Pokemon> listaDePokemon)
    {
        this.listaDePokemon=listaDePokemon;
    }

    ///agrego un pokemon al linkedhashset
    @Override
    public void agregar(Pokemon elemento) {
        listaDePokemon.add(elemento);
    }
    ///borro un pokemon del linkedhashset
    @Override
    public Pokemon borrar(Pokemon elemento) {
        listaDePokemon.remove(elemento);
        return elemento;
    }
    //modifico un pokemon recibido por parametro y lo reemplazo en el linkedhashset
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
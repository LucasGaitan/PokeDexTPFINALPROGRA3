package Controladores.app;

import Entidad.app.Pokemon;
import Interfaces.app.IAbm;
import java.util.ArrayList;


public class ControladoraPokemon implements IAbm<Pokemon> {
    ArrayList <Pokemon> listaDePokemon;

    public Pokemon crearPokemon(int id, String name, String sprite, ArrayList<String> type, ArrayList<String> abilities)
    {
        Pokemon nuevo= new Pokemon(id, name, sprite, type, abilities);
        return nuevo;
    }

    public StringBuilder listarPokemon()
    {
        StringBuilder builder= new StringBuilder();
        for(Pokemon p: listaDePokemon)
        {
            builder.append(p.toString());
            builder.append("\n");
        }
        return builder;
    }

    @Override
    public void agregar(Pokemon elemento) {

    }

    @Override
    public Pokemon borrar(Pokemon elemento) {
        return null;
    }

    @Override
    public void modificar(Pokemon elemento) {

    }
}

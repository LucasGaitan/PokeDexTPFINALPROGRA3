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
    private HashMap<String, Usuario> usuarios;

    public ControladoraPokemon (LinkedHashSet <Pokemon> listaDePokemon)
    {
        this.listaDePokemon=listaDePokemon;
    }

    public Pokemon crearPokemon(int id, String name, String sprite, ArrayList<String> type, ArrayList<String> abilities)
    {
        Pokemon nuevo= new Pokemon(id, name, sprite, type, abilities);
        return nuevo;
    }

    public Pokemon buscarPokemonEnLista(String nombre) throws ENotFoundException
    {
        Pokemon aux = new Pokemon();
        for (Pokemon p : listaDePokemon) {
            if (p.getName().equals(nombre)) {
                aux = p;
            }
        }
        if(aux.getName()==null)
        {
            throw new ENotFoundException("Pokemon no encontrado");
        }
        return aux;
    }

    public Pokemon buscarPokemon(String nombre)
    {
        Pokemon aux= new Pokemon();
        try {
            aux=buscarPokemonEnLista(nombre);
        }catch (ENotFoundException e){
            e.printStackTrace();
        }
        return aux;
    }

    public String mostrarPokemon(Pokemon pokemon)
    {
        return pokemon.toString();
    }

    public HashSet<Pokemon> listarPokemon()
    {
        return listaDePokemon;
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
package com.company;

import com.Controladores.ControladoraJSON;
import com.Entidad.Pokemon;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {
        ControladoraJSON controladoraJSON = new ControladoraJSON("Pokemons");
        LinkedHashSet<Pokemon> pokemons = new LinkedHashSet<>();
        pokemons = controladoraJSON.generarPokemon();
        System.out.println(pokemons);
    }
}

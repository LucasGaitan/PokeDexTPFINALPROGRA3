package company.app;



import Controladores.app.ControladoraJSON;
import Entidad.app.Pokemon;

import java.util.LinkedHashSet;

public class Main {

    public static void main(String[] args) {
        ControladoraJSON controladoraJSON = new ControladoraJSON("Pokemons");
        LinkedHashSet<Pokemon> pokemons = new LinkedHashSet<>();
        pokemons = controladoraJSON.generarPokemon();
        System.out.println(pokemons);
    }
}

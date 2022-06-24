package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Entidad.app.Pokemon;
import Entidad.app.Usuario;
import Interfaces.app.IInterfacesGraficas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringJoiner;

public class VerPokedex extends vistasPokemon implements IInterfacesGraficas {

    private ArrayList<Pokemon> pokemons;

    @FXML
    private Button borrarPokemon;



    public VerPokedex(Inicio inicio) { ///inicializo la ventana
        super(inicio, "InterfacesGraficas/VerPokedex.fxml", "Pokedex");

    }

    @FXML
    public void initialize() { //inicializo los eventos con sus excepciones elevadas
        super.initialize(pokemons);
        cargarListaPokedex();
        super.seleccionListView(pokemons);
        borrarPokemon.setOnAction(event -> {borrarPokemon();
        cargarListaPokedex();});
    }

    public void borrarPokemon(){ //borra el pokemon seleccionado de la pokedex
        getInicio().getEncontrado().getPokedex().borrar(getSeleccionado());
        setEventoLabel("Pokémon eliminado con éxito!");
    }

    public void cargarListaPokedex() { ///carga la pokedex del usuario
        this.pokemons = getInicio().getEncontrado().getPokedex().listar();
        ArrayList<String> lista = new ArrayList<>();
        for (Pokemon p : pokemons) {
            lista.add(p.getName());
        }
        ObservableList<String> observableList = FXCollections.observableArrayList(lista); ///casteo a observablelist para mostrar en listView
        getListPokemon().setItems(observableList);
    }
}


package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Entidad.app.Pokemon;
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
import java.util.LinkedHashSet;
import java.util.StringJoiner;

public class AltaListPokemon extends vistasPokemon {

    @FXML
    private Button capturarPokemon;


    private LinkedHashSet<Pokemon> pokemons;

    public AltaListPokemon(Inicio inicio){
        super(inicio,"InterfacesGraficas/AltaListPokemon.fxml","Listar | Capturar Pokemon");
    }

    @FXML
    public void initialize(){ //inicializo los eventos
        super.initialize(getAplicacion().getListaDePokemon());
        this.pokemons=getAplicacion().getListaDePokemon();
        super.seleccionListView(pokemons);
        cargarLista();
        capturarPokemon.setOnAction(event -> altaPokemon());
    }

    public void cargarLista(){ //cargo la lista con todos los pokemones de la 1ra generacion
        for (Pokemon p : this.pokemons) {
            getListPokemon().getItems().add(p.getName());
        }
    }

    public void altaPokemon (){ //capturo el pokemon a la pokedex del usuario activo
        getInicio().getEncontrado().getPokedex().agregar(getSeleccionado());
        setEventoLabel("Capturado con éxito!");
    }

}


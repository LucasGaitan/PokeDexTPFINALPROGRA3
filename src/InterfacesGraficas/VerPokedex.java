package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraPokemon;
import Entidad.app.Pokemon;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class VerPokedex {

    private final Stage thisStage;
    private final Inicio inicio;
    private ArrayList<Pokemon> pokemons;
    Aplicacion aplicacion;

    @FXML
    private Label usuario;

    @FXML
    private ImageView urlPokemon;

    @FXML
    private ListView<String> listPokemon;

    @FXML
    private Label tipoPokemon;

    @FXML
    private Label idPokemon;

    @FXML
    private Label habilidadPokemon;

    @FXML
    private Button atras;

    public VerPokedex(Inicio inicio) {
        this.aplicacion = inicio.getAplicacion();
        thisStage = inicio.getThisStage();
        this.inicio = inicio;
        this.pokemons = new ArrayList<>();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/VerPokedex.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Pokedex");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    public void irAtras() {
        PrincipalUser principalUser = new PrincipalUser(inicio);
        principalUser.showStage();
    }

    @FXML
    private void initialize() {
        usuario.setText(inicio.getEncontrado().getUserName());
        atras.setOnAction(event -> irAtras());
        listPokemon.setOnMouseClicked(mouseEvent -> seleccionListView());
        String seleccionado = new String();
        inicio.getEncontrado().getPokedex().agregar(new Pokemon(1, "bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", new ArrayList<>(), new ArrayList<>()));
        inicio.getEncontrado().getPokedex().agregar(new Pokemon(2, "ivysaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png", new ArrayList<>(), new ArrayList<>()));
        pokemons = inicio.getEncontrado().getPokedex().listar();
        for (Pokemon p : pokemons) {
            listPokemon.getItems().add(p.getName());
        }
    }

    public void seleccionListView() {
        String nombre = listPokemon.getSelectionModel().getSelectedItem();
        //buscarlo desde pokedex
        Pokemon encontrado=new Pokemon();
        for (Pokemon p : pokemons){
            if (p.getName().equals(nombre)){
                encontrado=p;
            }
        }
        setPokedexUi(encontrado);
    }
    public void setPokedexUi (Pokemon pokemon)
    {
        Image image = new Image(pokemon.getSprite(), 1000, 1000, true, true);
        urlPokemon.setImage(image);
        urlPokemon.setPreserveRatio(true);
        idPokemon.setText(String.valueOf(pokemon.getId()));
        
    }


    public void AccionBoton(String seleccionado) {
        seleccionado = (String) listPokemon.getSelectionModel().getSelectedItem();
        //nombrePokemon.setText(seleccionado);

    }


}


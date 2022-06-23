package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraPokemon;
import Entidad.app.Pokemon;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class VerPokedex{

    private final Stage thisStage;
    private final Inicio inicio;
    Aplicacion aplicacion;
    @FXML
    private ImageView urlPokemon;

    @FXML
    private ListView<String> listPokemon;

    @FXML
    private Label nombrePokemon;

    public VerPokedex(Inicio inicio){
        this.aplicacion = inicio.getAplicacion();
        thisStage = inicio.getThisStage();
        this.inicio = inicio;
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


    @FXML
    private void initialize(){
        inicio.getEncontrado().getPokedex().agregar(new Pokemon(1,"pingo","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",new ArrayList<>(),new ArrayList<>()));
        inicio.getEncontrado().getPokedex().agregar(new Pokemon(2,"pingo2","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",new ArrayList<>(),new ArrayList<>()));
        ArrayList<Pokemon> pokemons = inicio.getEncontrado().getPokedex().listar();
        for(Pokemon p: pokemons)
        {
            listPokemon.getItems().add(p.getName());
        }

        Image image = new Image(inicio.getEncontrado().getPokedex().listar().get(1).getSprite(), 1000, 1000, true, true);
        urlPokemon.setImage(image);
        urlPokemon.setPreserveRatio(true);
        nombrePokemon.setOnMouseClicked(this::AccionBoton);
        /*ObservableList<String> pokemons2 = FXCollections.observableArrayList(
                for (pokemons : )
        );


        for (int i = 0; i < pokemons2.size(); i++) {
            pokemons2.add(pokemons.get(i).getName());
            listPokemon.getItems().setAll();
        }
        */

    }

    public String AccionBoton (MouseEvent event) ///eliminar
    {
    String seleccionado=(String)listPokemon.getSelectionModel().getSelectedItem();
    return seleccionado;

    }

}


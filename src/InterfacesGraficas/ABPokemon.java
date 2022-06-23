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
import java.util.HashSet;

public class ABPokemon{

    private final Stage thisStage;
    private final Inicio inicio;
    Aplicacion aplicacion;

    @FXML
    private Label usuario;

    @FXML
    private ImageView urlPokemon;

    @FXML
    private ListView<String> listPokemon;

    @FXML
    private Button atras;

    public ABPokemon(Inicio inicio){
        this.aplicacion = inicio.getAplicacion();
        thisStage = inicio.getThisStage();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/ABPokemon.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Agregar | Borrar Pokemon a Pokedex");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    public void irAtras(){
        PrincipalUser principalUser = new PrincipalUser(inicio);
        principalUser.showStage();
    }

    @FXML
    private void initialize(){
        usuario.setText(inicio.getEncontrado().getUserName());
        atras.setOnAction(event -> irAtras());
        HashSet<Pokemon> pokemons = inicio.getAplicacion().getControladoraPokemon().listarPokemon();
        listPokemon.getItems().setAll(String.valueOf(pokemons));

        /*Image image = new Image(inicio.getEncontrado().getPokedex().listar().get(1).getSprite(), 1000, 1000, true, true);
        urlPokemon.setImage(image);
        urlPokemon.setPreserveRatio(true);*/
        /*ObservableList<String> pokemons2 = FXCollections.observableArrayList(
                for (pokemons : )
        );


        for (int i = 0; i < pokemons2.size(); i++) {
            pokemons2.add(pokemons.get(i).getName());
            listPokemon.getItems().setAll();
        }
        */

    }

}


package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Entidad.app.Pokemon;
import Entidad.app.Usuario;
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
import java.util.StringJoiner;

public class VerPokedex {

    private final Stage thisStage;
    private  Inicio inicio;
    private ArrayList<Pokemon> pokemons;
    private Aplicacion aplicacion;
    private Pokemon seleccionado;

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

    @FXML
    private Button borrarPokemon;

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
        cargarLista();
        listPokemon.setOnMouseClicked(mouseEvent -> seleccionListView());
        borrarPokemon.setOnAction(event -> {borrarPokemon();
        cargarLista();});
    }

    public void cargarLista(){
        pokemons = inicio.getEncontrado().getPokedex().listar();
        ArrayList <String> lista=new ArrayList<>();
        for (Pokemon p : pokemons) {
            lista.add(p.getName());
            //listPokemon.getItems().add(p.getName());
        }
        ObservableList<String> observableList = FXCollections.observableArrayList(lista);
        listPokemon.setItems(observableList);


    }
    public void seleccionListView() {
        String nombre = listPokemon.getSelectionModel().getSelectedItem();
        Pokemon seleccionado=new Pokemon();
        for (Pokemon p : pokemons){
            if (p.getName().equals(nombre)){
                seleccionado=p;
            }
        }
        if (nombre!=null && !pokemons.isEmpty() )
        {
            this.seleccionado = seleccionado;
            setPokedexUi();
        }
    }
    public void setPokedexUi ()
    {
        Image image = new Image(seleccionado.getSprite(), 1000, 1000, true, true);
        urlPokemon.setImage(image);
        urlPokemon.setPreserveRatio(true);
        idPokemon.setText(String.valueOf(seleccionado.getId()));

        StringJoiner tipos = new StringJoiner("/");
        for (String recorrer : seleccionado.getType()){
            tipos.add(recorrer);
        }
        tipoPokemon.setText(tipos.toString());

        StringJoiner habilidades = new StringJoiner("/");
        for (String recorrer : seleccionado.getAbilities()){
            habilidades.add(recorrer);
        }
        habilidadPokemon.setText(habilidades.toString());
    }

    public void borrarPokemon(){
        inicio.getEncontrado().getPokedex().borrar(seleccionado);
        cargarLista();
    }
}


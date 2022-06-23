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
import java.util.StringJoiner;

public class AltaListPokemon {

    private final Stage thisStage;
    private  Inicio inicio;
    private Pokemon seleccionado;
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

    @FXML
    private Button capturarPokemon;

    public AltaListPokemon(Inicio inicio){
        this.aplicacion = inicio.getAplicacion();
        thisStage = inicio.getThisStage();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/AltaListPokemon.fxml"));

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
        capturarPokemon.setOnAction(event -> altaPokemon());
        cargarLista();
        listPokemon.setOnMouseClicked(mouseEvent -> seleccionListView());
    }
    public void cargarLista(){

        for (Pokemon p : aplicacion.getListaDePokemon()) {
            listPokemon.getItems().add(p.getName());
        }

    }
    public void seleccionListView() {
        String nombre = listPokemon.getSelectionModel().getSelectedItem();
        //buscarlo desde pokedex
        Pokemon seleccionado = new Pokemon();
        for (Pokemon p : aplicacion.getListaDePokemon()){
            if (p.getName().equals(nombre)){
                seleccionado=p;
            }
        }
        this.seleccionado = seleccionado;
        setPokemonUi();
    }
    public void setPokemonUi ()
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

    public void altaPokemon (){
        inicio.getEncontrado().getPokedex().agregar(seleccionado);
    }

}


package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Entidad.app.Pokemon;
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

public class vistasPokemon {
    private final Stage thisStage;
    private Inicio inicio;
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

    @FXML
    private Label eventoLabel;

    public vistasPokemon(Inicio inicio, String FXML, String title) {
        this.aplicacion = inicio.getAplicacion();
        thisStage = inicio.getThisStage();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(FXML));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle(title);

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
    public void initialize(Collection<Pokemon> pokemons) {
        usuario.setText(inicio.getEncontrado().getUserName());
        atras.setOnAction(event -> irAtras());
        listPokemon.setOnMouseClicked(mouseEvent -> seleccionListView(pokemons));
    }

    public void seleccionListView(Collection<Pokemon> pokemons) {
        if (pokemons instanceof ArrayList<Pokemon>){
            pokemons=getInicio().getEncontrado().getPokedex().listar();
        }
        else {
            pokemons=aplicacion.getListaDePokemon();
        }
        String nombre = listPokemon.getSelectionModel().getSelectedItem();
        Pokemon seleccionado = new Pokemon();
        for (Pokemon p : pokemons) {
            if (p.getName().equals(nombre)) {
                seleccionado = p;
            }
        }
        if (nombre != null && !pokemons.isEmpty()) {
            this.seleccionado = seleccionado;
            setPokedexUi();
        }
    }

    public void setPokedexUi() {
        Image image = new Image(seleccionado.getSprite(), 1000, 1000, true, true);
        urlPokemon.setImage(image);
        urlPokemon.setPreserveRatio(true);
        idPokemon.setText(String.valueOf(seleccionado.getId()));

        StringJoiner tipos = new StringJoiner("/");
        for (String recorrer : seleccionado.getType()) {
            tipos.add(recorrer);
        }
        tipoPokemon.setText(tipos.toString());

        StringJoiner habilidades = new StringJoiner("/");
        for (String recorrer : seleccionado.getAbilities()) {
            habilidades.add(recorrer);
        }
        habilidadPokemon.setText(habilidades.toString());
        setEventoLabel("");
    }

    public Inicio getInicio() {
        return inicio;
    }

    public Pokemon getSeleccionado() {
        return seleccionado;
    }

    public Label getUsuario() {
        return usuario;
    }

    public Stage getThisStage() {
        return thisStage;
    }


    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public ListView<String> getListPokemon() {
        return listPokemon;
    }

    public void setEventoLabel(String text) {
        this.eventoLabel.setText(text);
    }
}

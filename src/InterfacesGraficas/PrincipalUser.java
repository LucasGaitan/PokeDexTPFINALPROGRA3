package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Interfaces.app.IInterfacesGraficas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class PrincipalUser implements IInterfacesGraficas {

    private Stage thisStage;

    private Inicio inicio;

    private Aplicacion aplicacion;

    @FXML
    private Label usuario;

    @FXML
    private Button logOut;

    @FXML
    private Button verPokedex;

    @FXML
    private Button altaListPokemon;

    public PrincipalUser(Inicio inicio){  //inicializo la ventana PrincipalUser
        this.aplicacion = inicio.getAplicacion();
        thisStage = inicio.getThisStage();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/PrincipalUser.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Usuario");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    @FXML
    public void initialize(){ ///inicializo los eventos
        usuario.setText(inicio.getEncontrado().getUserName());
        logOut.setOnAction(event -> userLogOut());
        verPokedex.setOnAction(event -> openVerPokedex());
        altaListPokemon.setOnAction(event -> openABPokemon());
    }

    public void userLogOut(){ ///metodo que cierra la sesion y abre la pantalla de logIn
        Inicio logOut = new Inicio(aplicacion, thisStage);
        logOut.showStage();
    }

    public void openVerPokedex() { ///metodo que abre la pokedex
        VerPokedex verPokedex = new VerPokedex(inicio);
        verPokedex.showStage();
    }

    public void openABPokemon() { ///metodo que abre la lista de pokemones para agregar a la pokedex
        AltaListPokemon altaListPokemon = new AltaListPokemon(inicio);
        altaListPokemon.showStage();
    }

}

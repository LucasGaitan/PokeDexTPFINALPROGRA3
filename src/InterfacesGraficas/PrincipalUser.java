package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class PrincipalUser{

    private final Stage thisStage;
    private final Inicio inicio;
    Aplicacion aplicacion;
    @FXML
    private Label usuario;

    @FXML
    private Button logOut;

    @FXML
    private Button verPokedex;

    public PrincipalUser(Inicio inicio){
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

    public void userLogOut(){
        Inicio logOut = new Inicio(aplicacion, thisStage);
        logOut.showStage();
    }

    public void openVerPokedex() {
        VerPokedex verPokedex = new VerPokedex(inicio);
        verPokedex.showStage();
    }

    @FXML
    private void initialize(){
        usuario.setText(inicio.getEncontrado().getUserName());
        logOut.setOnAction(event -> userLogOut());
        verPokedex.setOnAction(event -> openVerPokedex());
    }

}

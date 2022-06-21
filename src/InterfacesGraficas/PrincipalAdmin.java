package InterfacesGraficas;
import Aplicacion.app.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PrincipalAdmin{
    private final Stage thisStage;
    private Aplicacion aplicacion;
    @FXML
    private Button btnListar;

    public PrincipalAdmin(Inicio inicio, Aplicacion aplicacion){

        thisStage = inicio.getThisStage();
        this.aplicacion=aplicacion;
        //this.logIn = logIn;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/PrincipalAdmin.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Administracion");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }


    @FXML
    public void initialize() {
        ListarUsuarios listarUsuarios=new ListarUsuarios(this, aplicacion);
        btnListar.setOnAction(event -> listarUsuarios.showStage());
    }


    public Stage getThisStage() {
        return thisStage;
    }

}

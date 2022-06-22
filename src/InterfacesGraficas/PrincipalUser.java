package InterfacesGraficas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class PrincipalUser{

    private final Stage thisStage;
    private final Inicio inicio;

    @FXML
    private Label usuario;

    public PrincipalUser(Inicio inicio){

        thisStage = inicio.getThisStage();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/PrincipalUser.fxml"));

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
        usuario.setText(inicio.getEncontrado().getUserName());
    }

}

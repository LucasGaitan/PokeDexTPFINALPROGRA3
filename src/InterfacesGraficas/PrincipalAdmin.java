package InterfacesGraficas;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PrincipalAdmin{
    private final Stage thisStage;

    public PrincipalAdmin(LogIn logIn){

        thisStage = logIn.getThisStage();
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

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

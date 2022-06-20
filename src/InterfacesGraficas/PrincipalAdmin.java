package InterfacesGraficas;
import Entidad.app.Usuario;
import company.app.Pokedex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PrincipalAdmin {
    @FXML
    private Label userLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private AnchorPane anchorPane1;

    @FXML
    public void initialize() {
        userLabel.setText("asd");
    }

    public void administracion (ActionEvent event) throws IOException
    {
        // Step 1
        Usuario u = new Usuario(1, "jorge", "passardi", false, new Pokedex());
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        //stage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PrincipalAdmin.fxml"));

            loader.setController(this);

            Scene scene=new Scene(loader.load());
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

}



package InterfacesGraficas;

import company.app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LogIn {

    public LogIn() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();

        if (username.getText().toString().equals("prueba") && password.getText().toString().equals("123")) {

            Parent root = FXMLLoader.load(getClass().getResource("PrincipalAdmin.fxml"));
            wrongLogIn.setText("pokimon");
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("New Window");
            primaryStage.setScene(scene);
            primaryStage.initModality(Modality.NONE);// default
            primaryStage.show();


        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Por favor, ingrese sus datos");
        } else {
            wrongLogIn.setText("Usuario o contraseña incorrectos!");
        }
    }


}
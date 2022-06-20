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

        PrincipalAdmin controller = new PrincipalAdmin();
        controller.administracion(event);


    }

    private void checkLogin() throws IOException {

        if (username.getText().toString().equals("prueba") && password.getText().toString().equals("123")) {




        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {

            //ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
        /*
        try {
            Usuario encontrado = controladoraUsuario.login(this.username.getText(),this.password.getText());
            m.changeScene("InterfacesGraficas/User.fxml");
        } catch (EUsuarioPassIncorrecta e) {
            wrongLogIn.setText("Usuario o contraseña incorrectos!");
        } catch (EUsuarioNotFound e) {
            wrongLogIn.setText("Por favor, ingrese sus datos");
        } else {
            wrongLogIn.setText("Usuario o contraseña incorrectos!");
        }
        */

        }


    }
}
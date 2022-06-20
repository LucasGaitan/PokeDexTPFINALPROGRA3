package InterfacesGraficas;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import Exception.app.EUsuarioNotFound;
import Exception.app.EUsuarioPassIncorrecta;
import company.app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
        try {
            Usuario encontrado = controladoraUsuario.login(this.username.getText(),this.password.getText());
            m.changeScene("InterfacesGraficas/User.fxml");
        } catch (EUsuarioPassIncorrecta e) {
            wrongLogIn.setText("Usuario o contraseña incorrectos!");
        } catch (EUsuarioNotFound e) {
            wrongLogIn.setText("Por favor, ingrese sus datos");
        }
    }


}
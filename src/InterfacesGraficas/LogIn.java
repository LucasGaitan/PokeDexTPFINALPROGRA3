package InterfacesGraficas;

import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import Exception.app.EUsuarioPassIncorrecta;
import company.app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.management.loading.PrivateClassLoader;
import java.io.IOException;

public class LogIn {

    private final Stage thisStage;
    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private Usuario encontrado;

    public LogIn() {
        thisStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/Inicio.fxml"));

            loader.setController(this);

            thisStage.setResizable(false);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Inicio");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    private void openPrincipalUser() {
        PrincipalUser principalUser = new PrincipalUser(this);
        principalUser.showStage();
    }

    @FXML
    private void initialize() {
        button.setOnAction(event -> {
            try {
                userLogIn(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void userLogIn(ActionEvent event) throws IOException {
        Usuario encontrado = checkLogin();
        encontrado.setUserName("Lucas");
        encontrado.setAdmin(true);
        this.encontrado = encontrado;
        if (encontrado.isAdmin()) {
            openPrincipalAdmin();
        } else {
            openPrincipalUser();
        }
    }

    private Usuario checkLogin() {
        ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
        Usuario encontrado = new Usuario();
        try {
            encontrado = controladoraUsuario.login(this.username.getText(), this.password.getText());
        } catch (EUsuarioPassIncorrecta e) {
            wrongLogIn.setText(e.getMessage());
            encontrado = checkLogin();
        }
        return encontrado;
    }

    public void openPrincipalAdmin() {
        PrincipalAdmin principalAdmin = new PrincipalAdmin(this);
        principalAdmin.showStage();
    }

    public Usuario getEncontrado() {
        return encontrado;
    }

    public Stage getThisStage() {
        return thisStage;
    }
}
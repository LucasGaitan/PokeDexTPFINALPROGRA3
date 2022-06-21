package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import Exception.app.EDatosVacios;
import Exception.app.EUsuarioExiste;
import Exception.app.EUsuarioPassIncorrecta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Inicio {

    private final Stage thisStage;
    private Usuario encontrado;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    Aplicacion aplicacion;


    public Inicio(Aplicacion aplicacion) {
        thisStage = new Stage();
        this.aplicacion=aplicacion;
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

    @FXML
    private void initialize() {
        button.setOnAction(event -> {
            userLogIn(event);
        });
        button2.setOnAction(event -> {
            userSignUp(event);
        });

    }

    public void userLogIn(ActionEvent event){
        aplicacion.getControladoraUsuario().testUsuario();
        Usuario encontradologin = null;
        try
        {
            encontradologin = checkLogin();
        }
        catch (EUsuarioPassIncorrecta e)
        {
            wrongLogIn.setText(e.getMessage());
        }
        if (encontradologin!=null){
            if (encontradologin.isAdmin()) {
                this.encontrado = encontradologin;
                openPrincipalAdmin();
            } else {
                this.encontrado = encontradologin;
                openPrincipalUser();
            }
        }

    }

    public void userSignUp(ActionEvent event){

        Usuario elemento = aplicacion.getControladoraUsuario().crearUsuario(username.getText(),password.getText());
        boolean error = false;
        try {
            aplicacion.getControladoraUsuario().agregar(elemento);
        } catch (EUsuarioExiste | EDatosVacios e) {
            wrongLogIn.setText(e.getMessage());
            error = true;
        }
        if (!error){
            this.encontrado = elemento;
            openPrincipalUser();
        }
    }

    public Usuario checkLogin() throws EUsuarioPassIncorrecta {
        encontrado = aplicacion.getControladoraUsuario().login(this.username.getText(), this.password.getText());
        return encontrado;
    }

    public void openPrincipalAdmin() {
        PrincipalAdmin principalAdmin = new PrincipalAdmin(this, aplicacion);
        principalAdmin.showStage();
    }

    private void openPrincipalUser() {
        PrincipalUser principalUser = new PrincipalUser(this);
        principalUser.showStage();
    }

    public Usuario getEncontrado() {
        return encontrado;
    }

    public Stage getThisStage() {
        return thisStage;
    }
}
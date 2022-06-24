package InterfacesGraficas;


import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import Exception.app.EDatosVacios;
import Exception.app.EUsuarioExiste;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AgregarUsuario {
    private Aplicacion aplicacion;

    private Stage thisStage;

    private Inicio inicio;

    @FXML
    private Button atras;
    @FXML
    private TextField usernameM;
    @FXML
    private TextField passwordM;
    @FXML
    private Button CrearUsuario;
    @FXML
    private Label errorLabel;
    @FXML
    private CheckBox adminM;

    private Usuario nuevo;


    public AgregarUsuario(Inicio inicio) {
        this.aplicacion = inicio.getAplicacion();
        thisStage = inicio.getThisStage();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/AgregarUsuario.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Agregar Usuario");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    @FXML
    private void initialize() {
        atras.setOnMouseClicked(event -> irAtras());
        CrearUsuario.setOnMouseClicked(event -> agregarUsuario());
    }

    public void irAtras() {
        PrincipalAdmin PrincipalAdmin = new PrincipalAdmin(inicio);
        PrincipalAdmin.showStage();
    }

    public void agregarUsuario() { //funcion que se invoca al hacer click en agregar usuario
        try {
            if (usernameM.getText().trim().length() == 0 || usernameM.getText().trim().length() == 0) { //si alguno de los campos esta vacio lanza una excepcion
                throw new EDatosVacios("Por favor ingrese todos los datos");
            }
            ControladoraUsuario controller = aplicacion.getControladoraUsuario(); //instancio una controladora de usuario para agregar a la lista el nuevo usuario
            nuevo = controller.crearUsuarioAdmin(usernameM.getText(), passwordM.getText(), adminM.isSelected()); //creo el usuario apartir de los datos de la interfaz grafica


            controller.agregar(nuevo); //agrego el usuario
            irAtras(); //vuelvo a principalAdmin

        } catch (EDatosVacios | EUsuarioExiste ex) { //atrapo las exepciones y muestro por pantalla el mensaje
            errorLabel.setText(ex.getMessage());
        }
    }
}



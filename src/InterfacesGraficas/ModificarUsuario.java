package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Pokedex;
import Entidad.app.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModificarUsuario {
    private final Stage thisStage;
    private Inicio inicio;
    private Aplicacion aplicacion;

    @FXML
    private Label usuario;

    @FXML
    private TextField passwordM;

    @FXML
    private CheckBox adminM;

    @FXML
    private Button atras;

    @FXML
    private CheckBox limpiarPokedex;

    @FXML
    private Button modificarUsuario;

    private final Usuario seleccionado;

    public ModificarUsuario(Inicio inicio, Usuario seleccionado) {
        this.seleccionado = seleccionado;
        thisStage = inicio.getThisStage();
        this.aplicacion = inicio.getAplicacion();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/ModificarUsuario.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Modificar Usuario");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    @FXML
    public void initialize() {
        atras.setOnAction(event -> irAtras());
        modificarUsuario.setOnAction(event -> {modificarUsuario(seleccionado);
        irAtras();});
        usuario.setText(seleccionado.getUserName());
        cargarDatos(seleccionado);
    }

    public void irAtras() {
        PrincipalAdmin principalAdmin = new PrincipalAdmin(inicio);
        principalAdmin.showStage();
    }

    public void cargarDatos(Usuario usuario) {
        passwordM.setText(usuario.getPassword());
        if (usuario.isAdmin()) {
            adminM.setSelected(true);
        } else {
            adminM.setSelected(false);
        }
    }

    public void modificarUsuario(Usuario usuario) {
        usuario.setPassword(passwordM.getText());
        if (adminM.isSelected()) {
            usuario.setAdmin(true);
        } else
        {
            usuario.setAdmin(false);
        }
        if (limpiarPokedex.isSelected())
        {
            Pokedex pokedex=usuario.getPokedex();
            pokedex.limpiarPokedex();
        }
        ControladoraUsuario controller=aplicacion.getControladoraUsuario();
        controller.modificar(usuario);

    }


}

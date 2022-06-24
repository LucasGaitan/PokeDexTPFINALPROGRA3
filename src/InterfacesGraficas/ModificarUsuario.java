package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Pokedex;
import Entidad.app.Usuario;
import Exception.app.EDatosVacios;
import Interfaces.app.IInterfacesGraficas;
import com.sun.source.tree.TryTree;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModificarUsuario implements IInterfacesGraficas {
    private Stage thisStage;

    private Inicio inicio;

    private Aplicacion aplicacion;

    private Usuario seleccionado;

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
    @FXML
    private Label errorLabel ;



    public ModificarUsuario(Inicio inicio, Usuario seleccionado) { //inicializo la ventana
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
    public void initialize() { ///inicializo los eventos con las funciones elevadas
        atras.setOnAction(event -> irAtras());
        modificarUsuario.setOnAction(event -> {modificarUsuario(seleccionado);
            irAtras();});
        usuario.setText(seleccionado.getUserName());
        cargarDatos(seleccionado);
    }

    public void irAtras() { ///metodo para volver a PrincipalAdmin
        PrincipalAdmin principalAdmin = new PrincipalAdmin(inicio);
        principalAdmin.showStage();
    }

    public void cargarDatos(Usuario usuario) { ///cargo los datos en la interfaz grafica del usuario
        passwordM.setText(usuario.getPassword());
        if (usuario.isAdmin()) {
            adminM.setSelected(true);
        } else {
            adminM.setSelected(false);
        }
    }

    public void modificarUsuario(Usuario usuario) { ///realizo las validaciones necesarias para modificar el usario
        try {
            if (passwordM.getText().trim().length() == 0) { ///si la contraseña esta vacia lanzo una excepcion
                throw new EDatosVacios("Se debe ingresar una contraseña");
            } else { //guardo el usuario modificado en el hashmap
                usuario.setPassword(passwordM.getText());
                if (adminM.isSelected()) {
                    usuario.setAdmin(true);
                } else {
                    usuario.setAdmin(false);
                }
                if (limpiarPokedex.isSelected()) {
                    Pokedex pokedex = usuario.getPokedex();
                    pokedex.limpiarPokedex();
                }
                ControladoraUsuario controller = aplicacion.getControladoraUsuario();
                controller.modificar(usuario);
            }
        }catch (EDatosVacios ex)
        {
            errorLabel.setText(ex.getMessage());
        }
    }


}

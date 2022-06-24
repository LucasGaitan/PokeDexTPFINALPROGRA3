
package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraJSON;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import Exception.app.EDatosVacios;
import Exception.app.ENotDeleteAdmin;
import JSON.app.JsonUtiles;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class PrincipalAdmin {

    private final Stage thisStage;
    private Inicio inicio;
    private Aplicacion aplicacion;

    @FXML
    private TableView<Usuario> table;

    @FXML
    private TableColumn IdColumn;

    @FXML
    private TableColumn UsernameColumn;

    @FXML
    private TableColumn PasswordColumn;

    @FXML
    private TableColumn AdminColumn;

    @FXML
    private TableColumn NpokemonIdColumn;

    @FXML
    private Button logOut;

    @FXML
    private Button agregarUsuario;

    @FXML
    private Button modificarUsuario;

    @FXML
    private Button eliminarUsuario;

    @FXML
    private Label errorLabel;

    @FXML
    private Button ExportarAJson;

    public PrincipalAdmin(Inicio inicio) { //inicializo controlador de fxml

        thisStage = inicio.getThisStage(); ///tomo como modelo la ventana principal
        this.aplicacion = inicio.getAplicacion(); ///traigo la instancia de apligacion
        this.inicio = inicio;
        try {
            //cargo fxml
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/PrincipalAdmin.fxml"));
            //asigno como controlador a esta clase
            loader.setController(this);
            //creo la scene para este stage
            thisStage.setScene(new Scene(loader.load()));
            //titulo del stage
            thisStage.setTitle("Administracion");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    } //metodo para mostrar este estage

    public void userLogOut() { //vuelvo al menu principal
        Inicio logOut = new Inicio(aplicacion, thisStage);
        logOut.showStage();
    }

    @FXML
    public void cargarTabla() { ///metodo para cargar el table view
        ControladoraUsuario controller = aplicacion.getControladoraUsuario();
        HashMap<String, Usuario> usuarioHashMap = controller.getHashMapUsuarios();
        ArrayList<Usuario> usuarioArrayList = controller.castHashMapToArrayList(usuarioHashMap); //al no poder castear de hashmap a observablelist tranformo el hash en un arraylist

        ObservableList<Usuario> lista = FXCollections.observableArrayList(usuarioArrayList); //declaro el obervableview y lo incializo con los valores del arraylist
        ///asigno a cada columna del tableView los valores de cada usuario
        IdColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("id"));
        UsernameColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("userName"));
        PasswordColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("password"));
        AdminColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("admin"));
        table.setItems(lista); ///cargo los usuarios en el tableView

    }

    @FXML
    public void initialize() { //inicializo los eventos con las excepciones elevadas de los metodos
        cargarTabla();
        logOut.setOnAction(event -> userLogOut());
        modificarUsuario.setOnMouseClicked(event -> {
            try {
                openModificarUsuario(getUsuarioSeleccionado());
            } catch (EDatosVacios e) {
                errorLabel.setText(e.getMessage());
            }
        });
        eliminarUsuario.setOnMouseClicked(event -> {
            try {
                eliminarUsuario(getUsuarioSeleccionado());
            } catch (ENotDeleteAdmin | EDatosVacios e) {
                errorLabel.setText(e.getMessage());
            }
        });
        ExportarAJson.setOnMouseClicked(event -> {
            try {
                exportarUsuarioAJson(getUsuarioSeleccionado());
            } catch (EDatosVacios e) {
                errorLabel.setText(e.getMessage());
            }
        });
        agregarUsuario.setOnMouseClicked(event -> openAgregarUsuario());
    }

    public Usuario getUsuarioSeleccionado() throws EDatosVacios { ///elevo la excepcion
        Usuario seleccionado = table.getSelectionModel().getSelectedItem(); ///tomo el objeto usuario de la fila del tableview
        if (seleccionado == null) { //si seleccione una fila vacia el valor es null
            throw new EDatosVacios("No se ha seleccionado ningun usuario"); ///lanzo la escepcion y la elevo
        }
        return seleccionado;
    }

    public void openModificarUsuario(Usuario seleccionado) { //abre ventana de modificar usuario
        ModificarUsuario verModificarUsuario = new ModificarUsuario(inicio, seleccionado);
        verModificarUsuario.showStage();

    }

    public void eliminarUsuario(Usuario seleccionado) throws ENotDeleteAdmin {//abre ventana de eliminar usuario
        if (!seleccionado.isAdmin()) { //si el usuario seleccionado para borrar es un admin lanzo una excepcion
            ControladoraUsuario controller = aplicacion.getControladoraUsuario();
            controller.borrar(seleccionado);
            cargarTabla();

        } else {
            throw new ENotDeleteAdmin("No se pueden eliminar administradores");
        }


    }


    public void exportarUsuarioAJson(Usuario seleccionado) {
        ControladoraJSON controladoraJSON = new ControladoraJSON();
        JSONArray array = controladoraJSON.generarUsuarioJSON(seleccionado);
        JsonUtiles.grabar(array);
        errorLabel.setText("Usuario exportado a JSON");
    }

    public void openAgregarUsuario() {
        AgregarUsuario agregarUsuario = new AgregarUsuario(inicio);
        agregarUsuario.showStage();
    }

}
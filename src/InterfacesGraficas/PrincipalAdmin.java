
package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraJSON;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import Exception.app.EDatosVacios;
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

    public PrincipalAdmin(Inicio inicio) {

        thisStage = inicio.getThisStage();
        this.aplicacion = inicio.getAplicacion();
        this.inicio = inicio;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/PrincipalAdmin.fxml"));

            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));

            thisStage.setTitle("Administracion");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    public void userLogOut() {
        Inicio logOut = new Inicio(aplicacion, thisStage);
        logOut.showStage();
    }

    @FXML
    public void cargarTabla() {
        ControladoraUsuario controller = aplicacion.getControladoraUsuario();
        HashMap<String, Usuario> usuarioHashMap = controller.getHashMapUsuarios();
        ArrayList<Usuario> usuarioArrayList = controller.castHashMapToArrayList(usuarioHashMap);

        ObservableList<Usuario> lista = FXCollections.observableArrayList(usuarioArrayList);

        IdColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("id"));
        UsernameColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("userName"));
        PasswordColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("password"));
        AdminColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>("admin"));


        table.setItems(lista);

    }

    @FXML
    public void initialize() {
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
            } catch (EDatosVacios e) {
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

    public Usuario getUsuarioSeleccionado() throws EDatosVacios {
        Usuario seleccionado = table.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            throw new EDatosVacios("No se ha seleccionado ningun usuario");
        }
        return seleccionado;
    }

    public void openModificarUsuario(Usuario seleccionado) {
        ModificarUsuario verModificarUsuario = new ModificarUsuario(inicio, seleccionado);
        verModificarUsuario.showStage();

    }

    public void eliminarUsuario(Usuario seleccionado) {

        ControladoraUsuario controller = aplicacion.getControladoraUsuario();
        controller.borrar(seleccionado);
        cargarTabla();

        errorLabel.setText("No se ha seleccionado ningun usuario.");
    }


    public void exportarUsuarioAJson(Usuario seleccionado) {
            ControladoraJSON controladoraJSON = new ControladoraJSON();
            JSONArray array = controladoraJSON.generarUsuarioJSON(seleccionado);
            JsonUtiles.grabar(array);
    }

    public void openAgregarUsuario() {
        AgregarUsuario agregarUsuario = new AgregarUsuario(inicio);
        agregarUsuario.showStage();
    }

}

package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class PrincipalAdmin {

    private final Stage thisStage;
    private  Inicio inicio;
    private Aplicacion aplicacion;

    @FXML
    private TableView <Usuario> table;

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

    public void userLogOut(){
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
        modificarUsuario.setOnMouseClicked(event -> openModificarUsuario(getUsuarioSeleccionado()));
        eliminarUsuario.setOnMouseClicked(event -> eliminarUsuario(getUsuarioSeleccionado()));
    }

    public Usuario getUsuarioSeleccionado ()
    {
        Usuario seleccionado = table.getSelectionModel().getSelectedItem();
        return seleccionado;
    }

    public void openModificarUsuario (Usuario seleccionado)
    {
            if (seleccionado!=null)
            {
                ModificarUsuario verModificarUsuario = new ModificarUsuario(inicio, seleccionado);
                verModificarUsuario.showStage();
            }
            else
            {
            errorLabel.setText("No se ha seleccionado ningun usuario.");
            }
    }
    public void eliminarUsuario (Usuario seleccionado)
    {
        if (seleccionado!=null)
        {
            ControladoraUsuario controller=aplicacion.getControladoraUsuario();
            controller.borrar(seleccionado);
            cargarTabla();
        }
        else
        {
            errorLabel.setText("No se ha seleccionado ningun usuario.");
        }
    }

}
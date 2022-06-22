
package InterfacesGraficas;

import Aplicacion.app.Aplicacion;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import company.app.Pokedex;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ListarUsuarios {
    @FXML
    public void initialize() {
    cargarTabla();
    }

    @FXML
    private TableView table;
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

    private Stage thisStage;
    private Aplicacion aplicacion;
    public ListarUsuarios(PrincipalAdmin principalAdmin, Aplicacion aplicacion){

        thisStage = principalAdmin.getThisStage();
        this.aplicacion=aplicacion;
        //this.logIn = logIn;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("InterfacesGraficas/ListarUsuarios.fxml"));

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

    @FXML
    public void cargarTabla() {
        ControladoraUsuario controller = new ControladoraUsuario();
        ArrayList<Usuario> mockList = new ArrayList<Usuario>();
        Usuario u1 = new Usuario(1, "user1", "psd", false, new Pokedex());
        Usuario u2 = new Usuario(2, "user2", "asd", false, new Pokedex());
        mockList.add(u1);
        mockList.add(u2);

        for (Usuario u:mockList)
        {
            IdColumn.setCellValueFactory(new PropertyValueFactory<String, Usuario>(Integer.toString(u1.getId())));
        }


        table.getColumns().addAll(IdColumn, UsernameColumn, PasswordColumn, AdminColumn, NpokemonIdColumn);
    }


}
package InterfacesGraficas;

import Controladores.app.ControladoraUsuario;
import Entidad.app.Usuario;
import company.app.Pokedex;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class ListarUsuarios implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private TableView table = new TableView();
    @FXML
    private TableColumn IdColumn=new TableColumn();
    @FXML
    private TableColumn UsernameColumn=new TableColumn();
    @FXML
    private TableColumn PasswordColumn=new TableColumn();
    @FXML
    private TableColumn AdminColumn=new TableColumn();
    @FXML
    private TableColumn NpokemonIdColumn=new TableColumn();


    public void cargarTabla ()
    {
        ControladoraUsuario controller=new ControladoraUsuario();
        ArrayList<Usuario> mockList=new ArrayList<Usuario>();
        Usuario u1=new Usuario(1, "user1","psd",false, new Pokedex());
        Usuario u2=new Usuario(2, "user2","asd",false, new Pokedex());
        mockList.add(u1);
        mockList.add(u2);
/*
        for (Usuario u:mockList)
        {
            IdColumn.setCellValueFactory(new PropertyValueFactory<>(u1.getId()));
        }

 */
        table.getColumns().addAll(IdColumn, UsernameColumn, PasswordColumn, AdminColumn, NpokemonIdColumn);
    }


}

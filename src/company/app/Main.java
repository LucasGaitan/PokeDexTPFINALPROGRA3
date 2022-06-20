package company.app;
import Controladores.app.ControladoraJSON;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Pokemon;
import InterfacesGraficas.LogIn;
import InterfacesGraficas.PrincipalUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedHashSet;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("InterfacesGraficas/Inicio.fxml"));
        primaryStage.setTitle("Pokedex");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/

        LogIn logIn = new LogIn();

        logIn.showStage();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

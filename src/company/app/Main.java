package company.app;
import Aplicacion.app.Aplicacion;
import InterfacesGraficas.Inicio;
import javafx.application.Application;
import javafx.stage.Stage;

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
        Aplicacion aplicacion = new Aplicacion();
        Inicio inicio = new Inicio(aplicacion);

        inicio.showStage();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

package company.app;
import Aplicacion.app.Aplicacion;
import InterfacesGraficas.Inicio;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stg;
    private static Aplicacion aplicacion;

    @Override
    public void start(Stage primaryStage) throws Exception{
        aplicacion = new Aplicacion();
        aplicacion.iniciarPrograma();
        Inicio inicio = new Inicio(aplicacion, new Stage());
        inicio.showStage();
    }

    @Override
    public void stop() throws Exception {
        aplicacion.getControladoraArchivoUsuarios().agregarUsuariosToFile("Usuarios.bin", aplicacion.getControladoraUsuario().getHashMapUsuarios());
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

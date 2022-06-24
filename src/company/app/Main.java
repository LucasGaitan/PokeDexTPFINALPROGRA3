package company.app;
import Aplicacion.app.Aplicacion;
import InterfacesGraficas.Inicio;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stg;
    private static Aplicacion aplicacion; //Tuvimos que poner la aplicacion como un atributo estatico para poder guardar la coleccion de usuarios en el archivo al momento de cerrar el sistema

    @Override
    public void start(Stage primaryStage) throws Exception{
        aplicacion = new Aplicacion();
        aplicacion.iniciarPrograma();
        Inicio inicio = new Inicio(aplicacion, new Stage());
        inicio.showStage();
    }

    @Override
    public void stop() throws Exception { //Al momento de cerrar el sistema se guardan todos los usuarios en el archivo.
        aplicacion.getControladoraArchivoUsuarios().agregarUsuariosToFile("Usuarios.bin", aplicacion.getControladoraUsuario().getHashMapUsuarios());
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

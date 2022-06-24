package Controladores.app;

import Entidad.app.Usuario;
import Interfaces.app.IAbm;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ControladoraArchivoUsuarios{

    public ControladoraArchivoUsuarios(){

    }

    public void agregarUsuariosToFile(String archivo, HashMap<String, Usuario> usuarios) { ///guardo los usuarios del hashmap en el archivo
        Iterator<Map.Entry<String,Usuario>> iterator = usuarios.entrySet().iterator();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            while (iterator.hasNext()){
                Map.Entry<String, Usuario> entradaMapa = iterator.next();
                objectOutputStream.writeObject(entradaMapa.getValue());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Usuario> agregarFiletoHashMap(File archivo){ ///tomo los usuarios desde el archivo y los cargo en el hashmap
        HashMap<String, Usuario> usuarios = new HashMap<>();
        try {
            if (archivo.length() != 0) { //si el archivo no esta vacio cargo los usuarios en el hashmap
                FileInputStream file = new FileInputStream(archivo);
                BufferedInputStream buffer = new BufferedInputStream(file);
                ObjectInputStream in = new ObjectInputStream(buffer);
                Usuario Slinea = null;
                while ((Slinea = (Usuario) in.readObject()) != null) {
                    usuarios.put(Slinea.getUserName(), Slinea);
                }
            }
        }catch (EOFException ignored){

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


}

package Controladores.app;

import Entidad.app.Usuario;
import Interfaces.app.IAbm;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

public class ControladoraArchivoUsuarios{

    public void agregar(String archivo, Usuario elemento) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(elemento);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public Usuario borrar(File archivo, Usuario elemento) {  /// CLASE QUE POSIBLEMENTE NO SE PUEDA HACER
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Usuario aux = (Usuario) objectInputStream.readObject();
                if (aux.getUserName().equals(elemento.getUserName())) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }*/

    public void borrarArchivo(File archivo) {
        archivo.delete();
    }

    public void modificar(File archivo, Usuario elemento) {
        Random numAleatorio = new Random(3816L);
        String sinNombreFichNew = "/auxiliar" + String.valueOf(numAleatorio);
        File FficheroNuevo = new File(sinNombreFichNew);
        InputStream file = null;
        InputStream buffer = null;
        ObjectInputStream in = null;
        try {
            if (archivo.exists()) {
                file = new FileInputStream(archivo);
                buffer = new BufferedInputStream(file);
                in = new ObjectInputStream(buffer);
                Usuario Slinea = null;
                while ((Slinea = (Usuario) in.readObject()) != null) {
                    if (Slinea.equals(elemento)) {
                        agregar(FficheroNuevo.getName(), elemento);
                    } else {
                        agregar(FficheroNuevo.getName(), Slinea);
                    }
                }

            } else {
                System.out.println("Fichero no existe");
            }
        } catch (EOFException exception) {
            try {
                buffer.close();
                in.close();
                file.close();
                JFileChooser choose = new JFileChooser();
                choose.showOpenDialog(null);
                File f = choose.getSelectedFile();
                Path source = Paths.get(f.getAbsolutePath());
                String SnomAntiguo = archivo.getName();
                Files.move(source,source.resolveSibling(SnomAntiguo), StandardCopyOption.REPLACE_EXISTING);
            /*borrarArchivo(archivo);
            FficheroNuevo.renameTo(archivo);*/ // ESTO DEBERIAMOS USAR PERO NO FUNCIONA
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void mostrarArchivo(String archivo) {
        try {

            FileInputStream fileInputStream = new FileInputStream(archivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Usuario aux = (Usuario) objectInputStream.readObject();
                System.out.println(aux);
            }
        } catch (IOException e) {
            System.out.println("Se termino el archivo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

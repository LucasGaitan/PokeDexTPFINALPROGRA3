package Controladores.app;

import Entidad.app.Usuario;
import Interfaces.app.IAbm;

import java.io.*;

public class ControladoraArchivoUsuarios implements IAbm<Usuario> {

    @Override
    public void agregar(Usuario elemento) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("usuarios.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(elemento);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario borrar(Usuario elemento) {
        try {
            FileInputStream fileInputStream = new FileInputStream("usuarios.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true){
                Usuario aux = (Usuario) objectInputStream.readObject();
                if (aux.getUserName().equals(elemento.getUserName())){
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void modificar(Usuario elemento) {

    }
}

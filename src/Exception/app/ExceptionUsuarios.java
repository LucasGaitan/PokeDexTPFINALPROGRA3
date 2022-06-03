package Exception.app;

import Entidad.app.Usuario;

public class ExceptionUsuarios extends Exception{
    /*public boolean ExceptionLogin(Usuario encontrado, String password) throws Exception {
        if (encontrado == null){
            throw new Exception("Usuario o contraseña incorrectos");
        }
        if (!encontrado.getPassword().equals(password)){
            throw new Exception("Usuario o contraseña incorrectos");
        }
        return true;

    }

    public boolean usuarioNotFoundException(Usuario encontrado) throws Exception {
        if (encontrado == null){
            throw new Exception("No existe el usuario");
        }
        return true;
    }*/


    public static void loginException (String msg) throws Exception {
        throw new Exception(msg);
    }
}
